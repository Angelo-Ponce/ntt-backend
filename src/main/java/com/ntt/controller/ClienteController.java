package com.ntt.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ntt.dto.ClienteDto;
import com.ntt.exception.ModelNotFoundException;
import com.ntt.model.Cliente;
import com.ntt.service.IClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private IClienteService clService;
	
	@Autowired
	private ModelMapper mapper;
	
	@GetMapping
	public ResponseEntity<List<ClienteDto>> listar() throws Exception{
		List<ClienteDto> lista =  clService.listar().stream().map( cli -> mapper.map(cli, ClienteDto.class)).collect(Collectors.toList());
		return new ResponseEntity<List<ClienteDto>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ClienteDto> listarPorId(@PathVariable("id") Integer id ) throws Exception {
		Cliente cliente = clService.listarPorId(id);
		
		if( cliente == null )
			throw new ModelNotFoundException("ID no encontrado");
		
		ClienteDto dto = mapper.map(cliente, ClienteDto.class);
		
		return new ResponseEntity<ClienteDto>(dto, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Void> registrar(@Valid @RequestBody ClienteDto dtoRequest) throws Exception {
		
		Cliente cliente = mapper.map(dtoRequest, Cliente.class);
		Cliente obj = clService.registrar(cliente);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdPersona()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	
	@PutMapping
	public ResponseEntity<Cliente> modificar( @Valid @RequestBody ClienteDto dtoRequest) throws Exception {
		
		Cliente cli = clService.listarPorId(dtoRequest.getIdPersona());
		
		if( cli == null )
			throw new ModelNotFoundException("ID no encontrado");
		
		Cliente cliente = mapper.map(dtoRequest, Cliente.class);
		Cliente obj = clService.modificar(cliente);
		
		return new ResponseEntity<Cliente>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id ) throws Exception {
		
		Cliente cli = clService.listarPorId(id);
		
		if( cli == null )
			throw new ModelNotFoundException("ID no encontrado");
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	} 
}
