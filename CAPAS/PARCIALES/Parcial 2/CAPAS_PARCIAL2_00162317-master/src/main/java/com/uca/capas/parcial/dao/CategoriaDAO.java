package com.uca.capas.parcial.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.parcial.domain.Categoria;
import com.uca.capas.parcial.domain.Libro;

public interface CategoriaDAO {
	
	public List<Categoria> findAll() throws DataAccessException;
	
	public void save(Categoria c)  throws DataAccessException;
}
