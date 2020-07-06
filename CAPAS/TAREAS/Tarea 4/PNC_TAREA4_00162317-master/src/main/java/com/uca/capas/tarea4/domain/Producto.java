package com.uca.capas.tarea4.domain;


import java.util.Date;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class Producto {
	
	@NotNull(message="")
	@Size(min=12,max=12, message="Por favor, escriba bien los campos")
	private String codigo;
	
	@NotNull(message="")
	@Size(min=1,max=100, message="Por favor, escriba bien los campos")
	private String nombre;
	
	@NotNull(message="")
	@Size(min=1,max=100, message="Por favor, escriba bien los campos")
	private String marca;
	
	@NotNull(message="")
	@Size(min=1,max=500, message="Por favor, escriba bien los campos")
	private String descripcion;
	
	
	@NotNull(message="")
	@Digits(integer=10, fraction=0, message="Por favor, escriba bien los campos")
	private Integer existencias;
	
	
	@NotNull(message="")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaIngreso;
	
	public Producto() {
		
	}
	
	
	
	public Producto(
			@NotNull(message = "") @Min(1) @Max(value = 12, message = "Por favor, escriba bien los campos") String codigo,
			@NotNull(message = "") @Size(min = 1, max = 500, message = "Por favor, escriba bien los campos") String nombre,
			@NotNull(message = "") @Size(min = 1, max = 500, message = "Por favor, escriba bien los campos") String marca,
			@NotNull(message = "") @Size(min = 1, max = 500, message = "Por favor, escriba bien los campos") String descripcion,
			@NotNull(message = "") @Min(value = 0, message = "Por favor, escriba bien los campos") Integer existencias,
			@NotNull(message = "") Date fechaIngreso) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.marca = marca;
		this.descripcion = descripcion;
		this.existencias = existencias;
		this.fechaIngreso = fechaIngreso;
	}



	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getExistencias() {
		return existencias;
	}

	public void setExistencias(Integer existencias) {
		this.existencias = existencias;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}


}
