package com.uca.capas.tarea5.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(schema="public",name="estudiante")
public class Estudiante {
	
	@Id
	@Column(name="c_usuario")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer cUsuario;
	//@NotEmpty(message="No puede ir vacio este campo")
	@Column(name="nombre")
	private String nombre;
	//@NotEmpty(message="No puede ir vacio este campo")
	@Column(name="apellido")
	private String apellido;
	//@NotEmpty(message="No puede ir vacio este campo")
	@Column(name="carne")
	private String carne;
	//@NotEmpty(message="No puede ir vacio este campo")
	@Column(name="carrera")
	private String carrera;
	
	public Estudiante() {
		
	}

	public Integer getcUsuario() {
		return cUsuario;
	}
	public void setcUsuario(Integer cUsuario) {
		this.cUsuario = cUsuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCarne() {
		return carne;
	}
	public void setCarne(String carne) {
		this.carne = carne;
	}
	public String getCarrera() {
		return carrera;
	}
	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}
	
	

}
