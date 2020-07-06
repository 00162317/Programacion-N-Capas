package com.uca.capas.tarea5.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.tarea5.dao.EstudianteDAO;
import com.uca.capas.tarea5.domain.Estudiante;
import com.uca.capas.tarea5.repositories.EstudianteRepo;
import com.uca.capas.tarea5.EstudianteDTO.*;


@Service
public class EstudianteServiceImpl implements EstudianteService {

	
	@Autowired
	EstudianteRepo estudianteRepo;
	//EstudianteDAO estudiantedao;
	
	@Override
	public List<Estudiante> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		//return estudianteRepo.findAll();
		return estudianteRepo.mostrarTodos();
	}

	@Override
	public void insert(Estudiante estudiante) throws DataAccessException {
		// TODO Auto-generated method stub
			estudianteRepo.save(estudiante); //Tambien funciona para editar
			
	}

	@Override
	public void delete(Integer cUsuario) throws DataAccessException {
		// TODO Auto-generated method stub
		//estudiantedao.delete(cUsuario);
		estudianteRepo.deleteById(cUsuario);
	}

	@Override
	public List<Estudiante> filtrarPor(String cadena) throws DataAccessException {
		// TODO Auto-generated method stub
		//estudiantedao.delete(cUsuario);
		//return estudianteRepo.findByNombre(cadena);
		return estudianteRepo.mostrarPorNombre(cadena);
	}
	
	@Override
	public List<Estudiante> empiezaCon(String cadena) throws DataAccessException {
		// TODO Auto-generated method stub
		//estudiantedao.delete(cUsuario);
		return estudianteRepo.findByApellido(cadena);
	}
	
	@Override
	public List<EstudianteDTO> dtoPrueba() throws DataAccessException {
		List<EstudianteDTO> estudiantes = estudianteRepo.pruebaDTO().stream().map(obj->{
			EstudianteDTO e = new EstudianteDTO();
			e.setNombre(obj[0].toString());
			e.setApellido(obj[1].toString());
			return e;
		}).collect(Collectors.toList());
		return estudiantes;
	}

	@Override
	public void editar(Integer id,String nombre,String apellido,String carne,String carrera) throws DataAccessException {
		// TODO Auto-generated method stub
		Estudiante estudiante = estudianteRepo.getOne(id);
		
		estudiante.setNombre(nombre);
		estudiante.setApellido(apellido);
		estudiante.setCarne(carne);
		estudiante.setCarrera(carrera);
		
		estudianteRepo.save(estudiante);
		
	}
}
