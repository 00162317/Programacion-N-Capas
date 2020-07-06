package com.uca.capas.simulacro.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uca.capas.simulacro.domain.Contribuyente;
import com.uca.capas.simulacro.domain.Importancia;

@Repository
@Transactional
@Service
public class ImportanciaDAOImpl implements ImportanciaDAO {
	
	
	@PersistenceContext(unitName="simulacro")
	EntityManager entityManager;

	@Override
	public List<Importancia> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		
		sb.append("select * from public.importancia");
		
		Query query = entityManager.createNativeQuery(sb.toString(), Importancia.class);
		
		List<Importancia> res = query.getResultList();
		
		return res;
	}

}
