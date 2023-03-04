package com.gestion.activos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.gestion.activos.modelo.Ubicacion;

@Repository
public interface UbicacionRepositorio extends JpaRepository<Ubicacion, Long>{

}