package com.ntt.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Cuenta Dto con campos de persona")
public class CuentaDto {
	
	private Integer numeroCuenta;
	
	private String tipoCuenta;
	
	private double saldoInicial;
	
	private boolean status;
	
	//private Integer idPersona;
	
	private ClienteDto cliente;

	public Integer getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(Integer numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public String getTipoCuenta() {
		return tipoCuenta;
	}

	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}

	public double getSaldoInicial() {
		return saldoInicial;
	}

	public void setSaldoInicial(double saldoInicial) {
		this.saldoInicial = saldoInicial;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public ClienteDto getCliente() {
		return cliente;
	}

	public void setCliente(ClienteDto cliente) {
		this.cliente = cliente;
	}
	
}
