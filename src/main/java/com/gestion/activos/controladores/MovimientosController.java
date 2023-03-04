package com.gestion.activos.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.activos.excepciones.ResourceNotFoundException;
import com.gestion.activos.modelo.Movimiento;
import com.gestion.activos.repositorio.MovimientoRepositorio;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class MovimientosController {
	
	@Autowired
	private MovimientoRepositorio repositorio;
	
	@GetMapping("/movimientos")
	public List<Movimiento> listarTodosLosMovimientos() {
		return repositorio.findAll();
	}
	
	@PostMapping("/movimientos")
	public Movimiento guardarMovimiento(@RequestBody Movimiento movimiento) {
		return repositorio.save(movimiento);
	}
	
	@GetMapping("/movimientos/{id}")
	public ResponseEntity<Movimiento> obtenerMovimientoPorId(@PathVariable Long id){
		Movimiento movimiento = repositorio.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No existe el movimiento con el ID : " + id));
		return ResponseEntity.ok(movimiento);				
	}

}
