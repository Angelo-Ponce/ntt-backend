package com.ntt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntt.model.Cliente;
import com.ntt.repo.IClienteRepo;
import com.ntt.repo.IGenericRepo;
import com.ntt.service.IClienteService;

@Service
public class ClienteServiceImpl extends CRUDImpl<Cliente, Integer> implements IClienteService{
	
	@Autowired
	private IClienteRepo clienteRepo;

	@Override
	protected IGenericRepo<Cliente, Integer> getRepo() {
		return clienteRepo;
	}

}