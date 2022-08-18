package com.ntt.dto;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema( description = "Movimiento por fecha")
public class MovimientoFechaDto {

	private LocalDateTime fecha;
	
	private String name;
	
	private Integer numeroCuenta;
	
	private String tipoCuenta;
	
	private double saldoInicial;
	
	@Schema( description = "estado de la cuenta")
	private boolean status;
	
	@Schema( description = "valor del movimiento")
	private double valor;
	
	@Schema( description = "Saldo disponible")
	private double saldo;
	
	

	public MovimientoFechaDto(LocalDateTime fecha, String name, Integer numeroCuenta, String tipoCuenta,
			double saldoInicial, boolean status, double valor, double saldo) {
		super();
		this.fecha = fecha;
		this.name = name;
		this.numeroCuenta = numeroCuenta;
		this.tipoCuenta = tipoCuenta;
		this.saldoInicial = saldoInicial;
		this.status = status;
		this.valor = valor;
		this.saldo = saldo;
	}

	public MovimientoFechaDto() {
		super();
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

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
	
}
