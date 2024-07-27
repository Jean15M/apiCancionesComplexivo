package com.ista.usuario.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ista.usuario.dao.CancionDao;
import com.ista.usuario.entity.Cancion;

@Service
public class CancionServiceImpl implements CancionService {

	@Autowired
	private CancionDao cancionDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Cancion> findAll() {
		// TODO Auto-generated method stub
		return (List<Cancion>) cancionDao.findAll();
	}

	@Override
	@Transactional
	public Cancion save(Cancion cancion) {
		// TODO Auto-generated method stub
		return cancionDao.save(cancion);
	}

	@Override
	@Transactional(readOnly = true)
	public Cancion findbyId(Long id) {
		// TODO Auto-generated method stub
		return cancionDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		cancionDao.deleteById(id);
		
	}

}
