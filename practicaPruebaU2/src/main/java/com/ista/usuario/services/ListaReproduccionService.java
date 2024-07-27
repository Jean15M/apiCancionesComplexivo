package com.ista.usuario.services;

import java.util.List;

import com.ista.usuario.entity.ListaReproducción;


public interface ListaReproduccionService {
	
	public List<ListaReproducción> findAll();

	public ListaReproducción save(ListaReproducción listaReproduccion);

	public ListaReproducción findbyName(String name);
	
	public ListaReproducción findbyId(Long id);

	public void delete(Long id);


}
