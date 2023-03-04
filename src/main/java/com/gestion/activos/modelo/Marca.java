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
@Table(name = "marcas")
public class Marca {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cod_marca;
	
	private String descripcion;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "marca")
	private Set<Activo> activos = new HashSet<>();
	
	public Long getCod_marca() {
		return cod_marca;
	}

	public void setCod_marca(Long cod_marca) {
		this.cod_marca = cod_marca;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Set<Activo> getActivos() {
		return activos;
	}

	public void setActivos(Set<Activo> activos) {
		this.activos = activos;
	}
	
	public Marca() {
		
	}
	
}
