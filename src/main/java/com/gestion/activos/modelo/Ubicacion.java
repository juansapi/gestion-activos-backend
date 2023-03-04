package com.gestion.activos.modelo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ubicaciones")
public class Ubicacion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cod_ubicacion;
	
	private String descripcion;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "ubicacion")
	private Set<Movimiento> movimientos = new HashSet<>();
	
	public Long getCod_ubicacion() {
		return cod_ubicacion;
	}

	public void setCod_ubicacion(Long cod_ubicacion) {
		this.cod_ubicacion = cod_ubicacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Set<Movimiento> getMovimientos() {
		return movimientos;
	}

	public void setMovimientos(Set<Movimiento> movimientos) {
		this.movimientos = movimientos;
	}
	
	public Ubicacion() {
		
	}
	
}
