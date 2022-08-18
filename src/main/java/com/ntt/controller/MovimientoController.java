package com.ntt.controller;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ntt.dto.MovimientoDto;
import com.ntt.dto.MovimientoFechaDto;
import com.ntt.exception.ModelNotFoundException;
import com.ntt.model.Cuenta;
import com.ntt.model.Movimientos;
import com.ntt.service.ICuentaService;
import com.ntt.service.IMovimientoService;

@RestController
@RequestMapping("/movimientos")
public class MovimientoController {
	
	@Autowired
	private IMovimientoService movService;
	
	@Autowired
	private ICuentaService ctService;
	
	@Autowired
	private ModelMapper mapper;
	
	@GetMapping
	public ResponseEntity<List<MovimientoDto>> listar() throws Exception{
		List<MovimientoDto> lista =  movService.listar().stream().map( mov -> mapper.map(mov, MovimientoDto.class)).collect(Collectors.toList());;
		return new ResponseEntity<List<MovimientoDto>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<MovimientoDto> listarPorId(@PathVariable("id") Integer id ) throws Exception {
		Movimientos movimiento = movService.listarPorId(id);
		
		if( movimiento == null )
			throw new ModelNotFoundException("Movimiento no encontrado");
		
		MovimientoDto dto = mapper.map(movimiento, MovimientoDto.class);
		
		return new ResponseEntity<MovimientoDto>(dto, HttpStatus.OK);
	}
	
	@GetMapping("/buscar")
	public ResponseEntity<List<MovimientoFechaDto>> buscarFecha(@RequestParam(value = "idpersona") Integer idpersona, @RequestParam(value = "fechaInicial") String fechaInicial, @RequestParam(value = "fechaFinal") String fechaFinal) throws Exception {
		List<Movimientos> movimiento = new ArrayList<>();
		

		movimiento = movService.listarMovFechaUsuario(LocalDateTime.parse(fechaInicial), LocalDateTime.parse(fechaFinal), idpersona);
		
		//List<MovimientoFechaDto> movDTO = mapper.map(movimiento, new TypeToken<List<MovimientoFechaDto>>() {}.getType());
		//List<MovimientoFechaDto> lista =  movService.listarMovFechaUsuario(LocalDateTime.parse(fechaInicial), LocalDateTime.parse(fechaFinal), idpersona).stream().map( mov -> mapper.map(mov, MovimientoFechaDto.class)).collect(Collectors.toList());;
		List<MovimientoFechaDto> movDTO = new ArrayList<>();;
		
		for (Movimientos mov : movimiento) {
			MovimientoFechaDto dto = new MovimientoFechaDto(
					mov.getFecha(), 
					mov.getCuenta().getCliente().getName(), 
					mov.getCuenta().getNumeroCuenta(), 
					mov.getCuenta().getTipoCuenta(), 
					mov.getCuenta().getSaldoInicial(), 
					mov.getCuenta().isStatus(), 
					mov.getValor(), 
					mov.getSaldo());
			movDTO.add(dto);
		}
		

		return new ResponseEntity<>(movDTO, HttpStatus.OK);
	}
	
	
	@PostMapping
	public ResponseEntity<Void> registrar(@Valid @RequestBody MovimientoDto dtoRequest) throws Exception {
		
		Movimientos movimiento = mapper.map(dtoRequest, Movimientos.class);
		System.out.println("Datos:" + dtoRequest.getCuenta().getNumeroCuenta());
		System.out.println("Datos:" + dtoRequest.getIdMovimiento());
		
		Cuenta cuenta = ctService.listarPorId(dtoRequest.getCuenta().getNumeroCuenta());
		if( cuenta == null )
			throw new ModelNotFoundException("Cuenta # " + dtoRequest.getCuenta().getNumeroCuenta() + " no encontrado");
		
		double saldo = cuenta.getSaldoInicial() + (movimiento.getValor());
		System.out.println("Valor: " + saldo);
		if(saldo <= 0)
			throw new Exception("Saldo no disponible, para el movimiento");
		
		movimiento.setSaldo(saldo);
		cuenta.setSaldoInicial(saldo);
		
		Movimientos obj = movService.registrar(movimiento);
		ctService.registrar(cuenta);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdMovimiento()).toUri();
		return ResponseEntity.created(location).build();
	}

}
