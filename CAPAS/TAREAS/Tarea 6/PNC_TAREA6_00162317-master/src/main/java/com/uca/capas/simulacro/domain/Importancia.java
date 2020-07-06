package com.uca.capas.simulacro.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.SequenceGenerator;

@Entity
@Table(schema="public",name="importancia")
public class Importancia {
	
	@Id
	@GeneratedValue(generator="importancia_c_importancia_seq",strategy=GenerationType.IDENTITY)
	//@SequenceGenerator(name="importancia_c_importancia_seq",sequenceName="simulacro.importancia_c_importancia_seq",allocationSize=1)
	@Column(name="c_importancia")
	private Integer c_importancia;
	@Column(name="nombre")
	private String nombre;
	
	@OneToMany(mappedBy="importancia",fetch=FetchType.LAZY)
	private List<Contribuyente> contribuyente;
	
	public List<Contribuyente> getContribuyente() {
		return contribuyente;
	}

	public void setContribuyente(List<Contribuyente> contribuyente) {
		this.contribuyente = contribuyente;
	}

	public Importancia() {
		
	}

	public Integer getC_importancia() {
		return c_importancia;
	}

	public void setC_importancia(Integer c_importancia) {
		this.c_importancia = c_importancia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}
