package com.ntt.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "movimientos")
public class Movimientos {

	// Un movimiento tiene: Fecha, tipo movimiento, valor, saldo
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idMovimiento;
	
	// @JsonFormat(shape = JsonFormat.Shape.STRING, pattern= "dd/mm/yyyy")
	@Column(nullable = false)
	private LocalDateTime fecha; // ISO Date yyyy-mm-ddTHH:mm:ss
	// Spring Boot 1.5 | JDK 6*,7,[8] -> pom.xml jsr310
	
	@Column(nullable = false, scale = 2)
    private double valor;
	
	@Column(nullable = false, scale = 2)
    private double saldo;
	
	@ManyToOne
	@JoinColumn(name = "numero_cuenta", nullable = false, foreignKey = @ForeignKey(name = "FK_mov_cuenta"))
	private Cuenta cuenta;

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

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}
	
}