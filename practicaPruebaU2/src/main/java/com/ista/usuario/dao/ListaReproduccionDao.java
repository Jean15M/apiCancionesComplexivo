package com.ista.usuario.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ista.usuario.entity.ListaReproducción;

public interface ListaReproduccionDao extends CrudRepository<ListaReproducción, Long> {
	ListaReproducción findByName(String name);
}
