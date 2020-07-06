package com.uca.capas.simulacro.service;


import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.simulacro.domain.Importancia;

public interface ImportanciaService {
	
	public List<Importancia> findAll() throws DataAccessException;

}
