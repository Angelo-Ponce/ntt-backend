package com.ntt.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntt.model.Movimientos;
import com.ntt.repo.IGenericRepo;
import com.ntt.repo.IMovimientoRepo;
import com.ntt.service.IMovimientoService;

@Service
public class MovimientoServiceImpl extends CRUDImpl<Movimientos, Integer> implements IMovimientoService{
	
	@Autowired
	private IMovimientoRepo repo;

	@Override
	protected IGenericRepo<Movimientos, Integer> getRepo() {
		// TODO Auto-generated method stub
		return repo;
	}

	@Override
	public List<Movimientos> listarMovFechaUsuario(LocalDateTime fechaInicial, LocalDateTime fechaFinal, Integer idpersona)
			throws Exception {
		// TODO Auto-generated method stub
		return repo.listarMovFechaUsuario(fechaInicial, fechaFinal.plusDays(1), idpersona);
	}
}