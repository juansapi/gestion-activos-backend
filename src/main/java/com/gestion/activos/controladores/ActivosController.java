package com.gestion.activos.controladores;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.activos.modelo.Activo;
import com.gestion.activos.repositorio.ActivoRepositorio;
import com.gestion.activos.excepciones.ResourceNotFoundException;



@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class ActivosController {
	
	@Autowired
	private ActivoRepositorio repositorio;
	
	
	@GetMapping("/activos")
	public List<Activo> listarTodosLosActivos() {
		return repositorio.findAll();
	}
	
	@PostMapping("/activos")
	public Activo guardarActivo(@RequestBody Activo activo) {
		return repositorio.save(activo);
	}
	
	@GetMapping("/activos/{id}")
	public ResponseEntity<Activo> obtenerActivoPorId(@PathVariable Long id){
		Activo empleado = repositorio.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No existe el Activo con el ID : " + id));
		return ResponseEntity.ok(empleado);				
	}
	
	@PutMapping("/activos/{id}")
	public ResponseEntity<Activo> actualizarActivo(@PathVariable Long id, @RequestBody Activo detallesActivo){
		Activo activo = repositorio.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No existe el Activo con el ID : " + id));
			
		activo.setDescripcion(detallesActivo.getDescripcion());
		activo.setReferencia(detallesActivo.getDescripcion());
		activo.setMarca(detallesActivo.getMarca());
		activo.setEstado(detallesActivo.getDescripcion());
		
		Activo activoActualizado = repositorio.save(activo);
		return ResponseEntity.ok(activoActualizado);
					
	}
	@DeleteMapping("/activos/{id}")
	public ResponseEntity<Map<String,Boolean>> eliminarEmpleado(@PathVariable Long id){
		Activo activo = repositorio.findById(id)
				            .orElseThrow(() -> new ResourceNotFoundException("No existe el Activo con el ID : " + id));
		
		repositorio.delete(activo);
		Map<String, Boolean> respuesta = new HashMap<>();
		respuesta.put("eliminar",Boolean.TRUE);
		return ResponseEntity.ok(respuesta);
    }

}
