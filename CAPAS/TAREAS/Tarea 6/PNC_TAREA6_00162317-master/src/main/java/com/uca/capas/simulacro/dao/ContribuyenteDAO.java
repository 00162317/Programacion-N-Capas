package com.uca.capas.simulacro.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.simulacro.domain.Contribuyente;

public interface ContribuyenteDAO {
	
	public List<Contribuyente> findAll() throws DataAccessException;
	
	public void save(Contribuyente c)  throws DataAccessException;
}
