package com.ntt.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
@DiscriminatorValue( value="CL" )
public class Cliente extends Persona {
	
	// clienteid, contraseña, estado. 
	
	@Column(nullable = false, unique = true)
	private String idCliente;
	
	@Column(name = "clave", nullable = false)
	private String password;
	
	@Column(name = "estado", nullable = false)
	private boolean status;

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}