package com.uca.capas.parcial.domain;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(schema="public",name="cat_libro")
public class Libro {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="c_libro")
	private Integer c_libro;
	
	@NotEmpty(message="No puede ir vacio este campo")
	@Size(min=1,max=500, message="Por favor, escriba bien los campos")
	@Column(name="s_titulo")
	private String s_titulo;
	
	@NotEmpty(message="No puede ir vacio este campo")
	@Size(min=1,max=150, message="Por favor, escriba bien los campos")
	@Column(name="s_autor")
	private String s_autor;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="c_categoria")
	private Categoria categoria;
	
	@Transient
	private Integer c_categoria;
	
	@Column(name="f_ingreso")
	private Date f_ingreso;

	@Column(name="b_estado")
	private Boolean b_estado;
	
	@Column(name="s_isbn")
	@NotEmpty(message="No puede ir vacio este campo")
	@Size(min=1,max=10, message="Por favor, escriba bien los campos")
	private String s_isbn;
	
	public String getS_isbn() {
		return s_isbn;
	}


	public void setS_isbn(String s_isbn) {
		this.s_isbn = s_isbn;
	}


	public Boolean getB_estado() {
		return b_estado;
	}


	public void setB_estado(Boolean b_estado) {
		this.b_estado = b_estado;
	}


	public Libro() {
		
		
	}


	public Integer getC_libro() {
		return c_libro;
	}


	public void setC_libro(Integer c_libro) {
		this.c_libro = c_libro;
	}


	public String getS_titulo() {
		return s_titulo;
	}


	public void setS_titulo(String s_titulo) {
		this.s_titulo = s_titulo;
	}


	public String getS_autor() {
		return s_autor;
	}


	public void setS_autor(String s_autor) {
		this.s_autor = s_autor;
	}


	public Categoria getCategoria() {
		return categoria;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}


	public Integer getC_categoria() {
		return c_categoria;
	}


	public void setC_categoria(Integer c_categoria) {
		this.c_categoria = c_categoria;
	}


    public Date getF_ingreso() {
		return f_ingreso;
	}
    
    public String getF_ingresoDelegate() throws ParseException {
        if(this.f_ingreso == null) {
            return "";
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh.mm aa");
            return sdf.format(getF_ingreso());
        }

    }
    
	
	public void setF_ingreso(Date f_ingreso) {
		this.f_ingreso = f_ingreso;
	}
	
	
	public String getDelegateEstado() {
		return b_estado ? "Activo":"Inactivo";
	}
	
	
}
