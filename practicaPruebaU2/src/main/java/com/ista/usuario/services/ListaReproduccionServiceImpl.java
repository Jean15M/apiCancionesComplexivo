package com.ista.usuario.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ista.usuario.dao.ListaReproduccionDao;
import com.ista.usuario.entity.ListaReproducción;

@Service
public class ListaReproduccionServiceImpl implements ListaReproduccionService {
	
	@Autowired
	private ListaReproduccionDao listaReproduccionDao;

	@Override
	@Transactional(readOnly = true)
	public List<ListaReproducción> findAll() {
		return (List<ListaReproducción>) listaReproduccionDao.findAll();
	}

	@Override
	@Transactional
	public ListaReproducción save(ListaReproducción listaReproduccion) {
		return listaReproduccionDao.save(listaReproduccion);
	}

	

	@Override
	@Transactional
	public void delete(Long id) {
		listaReproduccionDao.deleteById(id);
		
	}

	@Override
	@Transactional(readOnly = true)
	public ListaReproducción findbyName(String name) {
		// TODO Auto-generated method stub
		return listaReproduccionDao.findByName(name);
	}

	@Override
	@Transactional(readOnly = true)
	public ListaReproducción findbyId(Long id) {
		// TODO Auto-generated method stub
		return listaReproduccionDao.findById(id).orElse(null);
	}
	
	

}
