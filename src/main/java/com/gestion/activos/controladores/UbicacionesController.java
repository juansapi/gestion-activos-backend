package com.gestion.activos.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.activos.excepciones.ResourceNotFoundException;
import com.gestion.activos.modelo.Ubicacion;
import com.gestion.activos.repositorio.UbicacionRepositorio;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class UbicacionesController {
	
	@Autowired
	private UbicacionRepositorio repositorio;
	
	@GetMapping("/ubicaciones")
	public List<Ubicacion> listarTodosLasUbicaciones() {
		return repositorio.findAll();
	}
	
	@GetMapping("/ubicaciones/{id}")
	public ResponseEntity<Ubicacion> obtenerUbicacionesPorId(@PathVariable Long id){
		Ubicacion ubicacion = repositorio.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No existe la ubicacion con el ID : " + id));
		return ResponseEntity.ok(ubicacion);				
	}

}
