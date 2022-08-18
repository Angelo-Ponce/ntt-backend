package com.ntt.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Cliente Dto with Persona")
public class MovimientoDto {
	
	private Integer idMovimiento;
	
	@NotNull
	private LocalDateTime fecha;
	
	@NotNull
	private double valor;
	
	private double saldo;
	
	@NotNull
	private CuentaDto cuenta;

	public Integer getIdMovimiento() {
		return idMovimiento;
	}

	public void setIdMovimiento(Integer idMovimiento) {
		this.idMovimiento = idMovimiento;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public CuentaDto getCuenta() {
		return cuenta;
	}

	public void setCuenta(CuentaDto cuenta) {
		this.cuenta = cuenta;
	}

}
