package com.uca.capas.parcial.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.parcial.domain.Libro;

public interface LibroDAO {

	public List<Libro> findAll() throws DataAccessException;
	
	public void save(Libro c)  throws DataAccessException;
	
}
