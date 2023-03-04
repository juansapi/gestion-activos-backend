package com.gestion.activos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.activos.modelo.Activo;

@Repository
public interface ActivoRepositorio extends JpaRepository<Activo, Long>{

}
