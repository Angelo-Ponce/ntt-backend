package com.ntt.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Cliente Dto with Persona")
public class ClienteDto {
	
	@Schema( description = "id de persona")
	private Integer idPersona;
	
	@Schema( description = "identificacion de persona")
	@NotNull
	@Size(min = 5, message = "{dni.size}")
	private String identificacion;
	
	@NotNull
	private String name;
	
	@NotNull
	private String gender;
	
	@NotNull
	private Integer age;
	
	@NotNull
	private String direccion;
	
	@Size( min = 10, max = 10, message = "{phone.size}")
	private String phone;
	
	@NotNull
	private String idCliente;
	
	@NotNull
	private String password;
	
	@NotNull
	private boolean status;

	public Integer getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

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
