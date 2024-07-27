package com.ista.usuario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ista.usuario.entity.ListaReproducción;
import com.ista.usuario.services.ListaReproduccionService;

@RestController
@RequestMapping("/api")
public class ListaReproduccionController {
	
	@Autowired
	private ListaReproduccionService listaReproduccionService;
	
	@GetMapping("/listarep")
	public List<ListaReproducción> index() {
		return listaReproduccionService.findAll();
	}

	@GetMapping("/listarep/{name}")
	public ResponseEntity<ListaReproducción> show(@PathVariable String name) {
		ListaReproducción listaEncontrada = listaReproduccionService.findbyName(name);
		if(listaEncontrada==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.ok(listaEncontrada);
	}

	@PostMapping("/listarep")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<ListaReproducción> create(@RequestBody ListaReproducción listaReproduccion) {
		if(listaReproduccion.getDescripcion().isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		ListaReproducción listaGuardada = listaReproduccionService.save(listaReproduccion);
		return ResponseEntity.status(HttpStatus.CREATED).body(listaGuardada);
		
	}

	@PutMapping("/listarep/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<ListaReproducción> update(@RequestBody ListaReproducción listareproduccion, @PathVariable Long id) {
		ListaReproducción listaActual = listaReproduccionService.findbyId(id);
		if(listaActual==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		if(listareproduccion.getName()!=null && !listareproduccion.getName().isEmpty()) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
		listaActual.setDescripcion(listareproduccion.getDescripcion());
		ListaReproducción listaGuardada = listaReproduccionService.save(listaActual);
		return ResponseEntity.ok(listaGuardada);
	}

	@DeleteMapping("/listarep/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		ListaReproducción listaEncontrada = listaReproduccionService.findbyId(id);
		if(listaEncontrada==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		listaReproduccionService.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}


}
