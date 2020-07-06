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

@Repository
@Transactional
@Service
public class ContribuyenteDAOImpl implements ContribuyenteDAO {
	
	@PersistenceContext(unitName="simulacro")
	EntityManager entityManager;

	@Override
	public List<Contribuyente> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		
		sb.append("select * from public.contribuyente");
		
		Contribuyente contri = new Contribuyente();
		
		System.out.print(contri.getS_nombre());
		
		Query query = entityManager.createNativeQuery(sb.toString(), Contribuyente.class);
		
		List<Contribuyente> res = query.getResultList();
		
		
		return res;
	}

	@Override
	@Transactional
	public void save(Contribuyente c) throws DataAccessException {
		// TODO Auto-generated method stub
			entityManager.persist(c);
		
	}

}
