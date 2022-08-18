package com.ntt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntt.model.Cuenta;
import com.ntt.repo.ICuentaRepo;
import com.ntt.repo.IGenericRepo;
import com.ntt.service.ICuentaService;

@Service
public class CuentaServiceImpl extends CRUDImpl<Cuenta, Integer> implements ICuentaService{
	
	@Autowired
	private ICuentaRepo repo;

	@Override
	protected IGenericRepo<Cuenta, Integer> getRepo() {
		// TODO Auto-generated method stub
		return repo;
	}

}
