package com.ntt.repo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ntt.model.Movimientos;

public interface IMovimientoRepo extends IGenericRepo<Movimientos, Integer>{

	@Query("FROM Movimientos m WHERE m.cuenta.cliente.idPersona = :idpersona AND m.fecha BETWEEN :fechaInicial AND :fechaFinal")
	List<Movimientos> listarMovFechaUsuario(@Param("fechaInicial") LocalDateTime fechaInicial, @Param("fechaFinal") LocalDateTime fechaFinal, @Param("idpersona") Integer idpersona);
}
