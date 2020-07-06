package com.uca.capas.domain;

public class Student {
	
	private String nombre;
	private String apellido;
	private String fEntrada;
	private String carrera;
	private Boolean estado;
	
	
	public Student() {
		
	}
	
	public Student(String nombre, String apellido, String fEntrada, String carrera, Boolean estado) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.fEntrada = fEntrada;
		this.carrera = carrera;
		this.estado = estado;
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
	public String getfEntrada() {
		return fEntrada;
	}
	public void setfEntrada(String fEntrada) {
		this.fEntrada = fEntrada;
	}
	public String getCarrera() {
		return carrera;
	}
	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}
	public Boolean getEstado() {
		return estado;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	
	public String delegateEstado() {
		return estado ? "Activo":"Inactivo";
	}
	
}
