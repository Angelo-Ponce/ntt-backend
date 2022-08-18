/*package com.ntt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ntt.model.Persona;

public interface IPersonaRepo extends IGenericRepo<Persona, Integer>{
	
	@Query("FROM Persona p WHERE LOWER(p.name) LIKE %:nombre%")
	List<Persona> findOneByUsername(String nombre);
	
	@Query("FROM Persona p WHERE p.dni = :dni")
	Persona findOneByDni( @Param("dni")  String dni);
}*/
