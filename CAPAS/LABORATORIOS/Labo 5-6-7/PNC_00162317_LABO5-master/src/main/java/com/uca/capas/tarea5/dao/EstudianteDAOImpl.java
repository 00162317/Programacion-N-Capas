package com.uca.capas.tarea5.dao;

import com.uca.capas.tarea5.domain.Estudiante;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.capas.tarea5.dao.*;


@Repository
public class EstudianteDAOImpl implements EstudianteDAO{
	
	
	
	@PersistenceContext(unitName="tarea5")
	private EntityManager entityManager;

	@Override
	public List<Estudiante> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.ESTUDIANTE");
		
		Query query = entityManager.createNativeQuery(sb.toString(), Estudiante.class);
		List<Estudiante> resulset = query.getResultList();
		return resulset;
	}

	@Override
	@Transactional
	public void insert(Estudiante estudiante) throws DataAccessException {
		// TODO Auto-generated method stub
		entityManager.persist(estudiante);
		
	}

	@Override
	@Transactional
	public void delete(Integer cUsuario) throws DataAccessException {
		// TODO Auto-generated method stub
		
		Estudiante estudiante = entityManager.find(Estudiante.class,cUsuario);
		entityManager.remove(estudiante);
		
	}

}
