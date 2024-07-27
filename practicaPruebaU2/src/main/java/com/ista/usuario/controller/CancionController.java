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

import com.ista.usuario.entity.Cancion;
import com.ista.usuario.entity.ListaReproducción;
import com.ista.usuario.services.CancionService;
import com.ista.usuario.services.ListaReproduccionService;


@RestController
@RequestMapping("/api")
public class CancionController {
	
	@Autowired
	private CancionService cancionService;
	
	@Autowired
	private ListaReproduccionService listaRepService;
	
	@GetMapping("/cancion")
	public List<Cancion> index() {
		return cancionService.findAll();
	}

	@GetMapping("/cancion/{id}")
	public Cancion show(@PathVariable Long id) {
		return cancionService.findbyId(id);
	}

	@PostMapping("/cancion")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Cancion> create(@RequestBody Cancion cancion) {
		Long id = cancion.getId_lista();
		ListaReproducción listaActual = listaRepService.findbyId(id);
		if(listaActual==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		Cancion cancionSave = cancionService.save(cancion);
		return ResponseEntity.status(HttpStatus.CREATED).body(cancionSave);
	}

	@PutMapping("/cancion/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Cancion update(@RequestBody Cancion cancion, @PathVariable Long id) {
		Cancion cancionActual = cancionService.findbyId(id);
		cancionActual.setTitle(cancion.getTitle());
		cancionActual.setAlbum(cancion.getAlbum());
		cancionActual.setArtist(cancion.getArtist());
		cancionActual.setYear(cancion.getYear());
		return cancionService.save(cancionActual);
	}

	@DeleteMapping("/cancion/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		cancionService.delete(id);
	}

}
