package com.ntt.controller;

import java.net.URI;
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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ntt.dto.ClienteDto;
import com.ntt.dto.CuentaDto;
import com.ntt.exception.ModelNotFoundException;
import com.ntt.model.Cliente;
import com.ntt.model.Cuenta;
import com.ntt.service.ICuentaService;

@RestController
@RequestMapping("/cuentas")
public class CuentaController {
	
	@Autowired
	private ICuentaService ctService;
	
	@Autowired
	private ModelMapper mapper;
	
	@GetMapping
	public ResponseEntity<List<CuentaDto>> listar() throws Exception{
		List<CuentaDto> lista =  ctService.listar().stream().map( cta -> mapper.map(cta, CuentaDto.class)).collect(Collectors.toList());;
		return new ResponseEntity<List<CuentaDto>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CuentaDto> listarPorId(@PathVariable("id") Integer id ) throws Exception {
		Cuenta cuenta = ctService.listarPorId(id);
		
		if( cuenta == null )
			throw new ModelNotFoundException("Cuenta no encontrado");
		
		CuentaDto dto = mapper.map(cuenta, CuentaDto.class);
		
		return new ResponseEntity<CuentaDto>(dto, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Void> registrar(@Valid @RequestBody CuentaDto dtoRequest) throws Exception {
		
		Cuenta cuenta = mapper.map(dtoRequest, Cuenta.class);
		System.out.println("Datos:" + dtoRequest.getCliente().getIdPersona());
		Cuenta obj = ctService.registrar(cuenta);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cuenta.getNumeroCuenta()).toUri();
		return ResponseEntity.created(location).build();
	}
}
