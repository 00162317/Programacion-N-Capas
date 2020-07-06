package com.uca.capas.tarea5.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.tarea5.EstudianteDTO.EstudianteDTO;
import com.uca.capas.tarea5.domain.Estudiante;

public interface EstudianteService {
	
	public List<Estudiante>findAll() throws DataAccessException;
	
	public void insert(Estudiante estudiante) throws DataAccessException;
	
	public void delete(Integer cUsuario) throws DataAccessException;

	public List<Estudiante> filtrarPor(String cadena) throws DataAccessException;
	
	public List<Estudiante> empiezaCon(String cadena) throws DataAccessException;
	
	public List<EstudianteDTO> dtoPrueba() throws DataAccessException;
	
	public void editar(Integer id,String nombre,String apellido,String carne,String carrera) throws DataAccessException;
}
