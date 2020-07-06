package com.uca.capas.tarea5.repositories;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.uca.capas.tarea5.domain.*;

import java.util.List;

public interface EstudianteRepo extends JpaRepository<Estudiante, Integer> {
	
	
	public List<Estudiante> findByNombre(String cadena) throws DataAccessException;
	
	public List<Estudiante> findByApellido(String cadena) throws DataAccessException;
	
	
	
	@Query(nativeQuery=true,value="select * from public.ESTUDIANTE")
	public List<Estudiante> mostrarTodos() throws DataAccessException;
	
	
	@Query(nativeQuery=true,value="select * from public.ESTUDIANTE where nombre = :cadena")
	public List<Estudiante> mostrarPorNombre(String cadena) throws DataAccessException;
	
	
	@Query(nativeQuery=true,value="select nombre, apellido from public.ESTUDIANTE")
	public List<Object[]> pruebaDTO() throws DataAccessException;
	
	
	@Query(nativeQuery=true,value="update public.ESTUDIANTE set nombre = :nombre1, apellido = :apellido1, "
			+ "carne = :carne1, carrera = :carrera1 where c_usuario = :c_usuario1")
	public void editar(String nombre1, String apellido1, String carne1, String carrera1,Integer c_usuario1) throws DataAccessException;
}
