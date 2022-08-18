package com.ntt.repo;

import com.ntt.model.Cliente;

public interface IClienteRepo extends IGenericRepo<Cliente, Integer>{
	
	/*@Query("FROM Cliente c WHERE LOWER(c.nombre) LIKE %:nombre%")
	List<Cliente> findOneByUsername(@Param("nombre") String nombre);
	
	@Query("FROM Cliente c WHERE c.identificacion = :dni")
	Cliente findOneByDni( @Param("dni")  String dni);*/
}
