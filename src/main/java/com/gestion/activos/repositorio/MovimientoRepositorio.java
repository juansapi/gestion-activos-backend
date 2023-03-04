package com.gestion.activos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.activos.modelo.Activo;
import com.gestion.activos.modelo.Movimiento;

@Repository
public interface MovimientoRepositorio extends JpaRepository<Movimiento, Long>{

}