package com.ntt.service;

import java.time.LocalDateTime;
import java.util.List;

import com.ntt.dto.MovimientoFechaDto;
import com.ntt.model.Movimientos;

public interface IMovimientoService extends ICRUD<Movimientos, Integer>{

	List<Movimientos> listarMovFechaUsuario( LocalDateTime fechaInicial, LocalDateTime fechaFinal, Integer idpersona) throws Exception;
}
