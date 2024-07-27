package com.ista.usuario.dao;

import org.springframework.data.repository.CrudRepository;

import com.ista.usuario.entity.Cancion;

public interface CancionDao extends CrudRepository<Cancion, Long> {

}
