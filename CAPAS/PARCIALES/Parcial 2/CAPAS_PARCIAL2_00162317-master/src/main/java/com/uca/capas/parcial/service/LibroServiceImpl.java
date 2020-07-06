package com.uca.capas.parcial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uca.capas.parcial.dao.LibroDAO;
import com.uca.capas.parcial.domain.Libro;

@Service
public class LibroServiceImpl implements LibroService {

	@Autowired
	LibroDAO libroDAO;
	
	@Override
	public List<Libro> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		return libroDAO.findAll();
	}

	@Override
	public void save(Libro c) throws DataAccessException {
		// TODO Auto-generated method stub
		libroDAO.save(c);
		
	}

}
