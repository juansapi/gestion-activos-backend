package com.gestion.activos.modelo;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name = "movimientos")
public class Movimiento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cod_movimiento;
	
	private Long fecha_mov;
	
	private String origen;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	private Ubicacion ubicacion;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	private Activo activo;
	
	public Long getCod_movimiento() {
		return cod_movimiento;
	}

	public void setCod_movimiento(Long cod_movimiento) {
		this.cod_movimiento = cod_movimiento;
	}

	public Long getFecha_mov() {
		return fecha_mov;
	}

	public void setFecha_mov(Long fecha_mov) {
		this.fecha_mov = fecha_mov;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}

	public Activo getActivos() {
		return activo;
	}

	public void setActivos(Activo activos) {
		this.activo = activos;
	}

	
	public Movimiento() {
		
	}

}
