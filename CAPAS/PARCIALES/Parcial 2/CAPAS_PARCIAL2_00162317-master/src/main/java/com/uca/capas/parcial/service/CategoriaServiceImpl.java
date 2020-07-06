package com.uca.capas.parcial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uca.capas.parcial.dao.CategoriaDAO;
import com.uca.capas.parcial.domain.Categoria;

@Service
public class CategoriaServiceImpl implements CategoriaService {
	
	@Autowired
	CategoriaDAO categoriaDAO;

	@Override
	public List<Categoria> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		return categoriaDAO.findAll();
	}

	@Override
	public void save(Categoria c) throws DataAccessException {
		// TODO Auto-generated method stub
		categoriaDAO.save(c);
	}

}
