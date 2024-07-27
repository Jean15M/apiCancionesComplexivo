package com.ista.usuario.services;

import java.util.List;

import com.ista.usuario.entity.Cancion;

public interface CancionService {
	
	public List<Cancion> findAll();

	public Cancion save(Cancion cancion);

	public Cancion findbyId(Long id);

	public void delete(Long id);

}
