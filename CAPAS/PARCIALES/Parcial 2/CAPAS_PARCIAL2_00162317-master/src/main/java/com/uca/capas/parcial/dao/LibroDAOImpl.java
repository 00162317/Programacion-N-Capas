package com.uca.capas.parcial.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uca.capas.parcial.domain.Libro;

@Repository
public class LibroDAOImpl implements LibroDAO{
	
	@PersistenceContext(unitName="parcial")
	EntityManager entityManager;

	@Override
	public List<Libro> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		
		sb.append("select * from public.cat_libro");
		
		Query query = entityManager.createNativeQuery(sb.toString(), Libro.class);
		
		List<Libro> res = query.getResultList();
		
		return res;
	}

	@Override
	@Transactional
	public void save(Libro c) throws DataAccessException {
		// TODO Auto-generated method stub
		entityManager.persist(c);
	}

}
