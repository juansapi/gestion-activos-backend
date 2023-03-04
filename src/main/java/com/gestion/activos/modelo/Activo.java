package com.gestion.activos.modelo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "activos")
public class Activo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cod_activo;
	
	private String descripcion;
	
	private String referencia;
	
	private String estado;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "activo")
	private Set<Movimiento> movimientos = new HashSet<>();
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	private Marca marca;
	
	public Long getCod_activo() {
		return cod_activo;
	}

	public void setCod_activo(Long cod_activo) {
		this.cod_activo = cod_activo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Set<Movimiento> getMovimientos() {
		return movimientos;
	}

	public void setMovimientos(Set<Movimiento> movimientos) {
		this.movimientos = movimientos;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public Activo() {
		
	}

}
