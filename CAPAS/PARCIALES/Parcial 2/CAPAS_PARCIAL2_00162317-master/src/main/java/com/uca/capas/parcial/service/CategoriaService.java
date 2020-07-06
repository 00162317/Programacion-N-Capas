package com.uca.capas.parcial.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.parcial.domain.*;

public interface CategoriaService {

	public List<Categoria> findAll() throws DataAccessException;
	
	public void save(Categoria c)  throws DataAccessException;
}
