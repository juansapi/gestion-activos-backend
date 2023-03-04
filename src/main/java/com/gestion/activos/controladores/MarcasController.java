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
import com.gestion.activos.modelo.Marca;
import com.gestion.activos.repositorio.MarcaRepositorio;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class MarcasController {

	@Autowired
	private MarcaRepositorio repositorio;
	
	@GetMapping("/marcas")
	public List<Marca> listarTodosLasMarcas() {
		return repositorio.findAll();
	}
		
	@GetMapping("/marcas/{id}")
	public ResponseEntity<Marca> obtenerMarcaPorId(@PathVariable Long id){
		Marca marca = repositorio.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No existe la marca con el ID : " + id));
		return ResponseEntity.ok(marca);				
	}
	
}
