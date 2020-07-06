package com.uca.capas.simulacro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uca.capas.simulacro.dao.ContribuyenteDAO;
import com.uca.capas.simulacro.domain.Contribuyente;

@Service
public class ContribuyenteServiceImpl implements ContribuyenteService{
	
	
	@Autowired
	ContribuyenteDAO contribuyenteDAO;

	@Override
	public List<Contribuyente> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		return contribuyenteDAO.findAll();
	}

	@Override
	public void save(Contribuyente c) throws DataAccessException {
		// TODO Auto-generated method stub
		contribuyenteDAO.save(c);
		
	}

}
