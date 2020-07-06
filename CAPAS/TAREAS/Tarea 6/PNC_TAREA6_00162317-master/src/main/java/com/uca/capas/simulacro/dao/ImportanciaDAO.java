package com.uca.capas.simulacro.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.simulacro.domain.Importancia;


public interface ImportanciaDAO {
	
	public List<Importancia> findAll() throws DataAccessException;
}
