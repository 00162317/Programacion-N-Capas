package com.uca.capas.parcial.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.parcial.domain.*;

public interface LibroService {
	
	public List<Libro> findAll() throws DataAccessException;
	
	public void save(Libro c)  throws DataAccessException;
	

}
