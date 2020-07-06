package com.uca.capas.parcial.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.parcial.domain.Libro;
import com.uca.capas.parcial.domain.Categoria;
import com.uca.capas.parcial.service.CategoriaService;
import com.uca.capas.parcial.service.LibroService;

@Controller
@Service
public class MainController {
	
	@Autowired
	private LibroService book;
	@Autowired
	private CategoriaService cate;
	
	@RequestMapping("/index")
	public ModelAndView index(@ModelAttribute Libro libro) {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping("/categoria")
	public ModelAndView categoria(@ModelAttribute Categoria categoria) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("categoria", categoria);
		mav.setViewName("categoria");
		return mav;
	}
	
	@RequestMapping("/ingresarCategoria")
	public ModelAndView ingresarCategoria(@ModelAttribute Categoria categoria) {
		ModelAndView mav = new ModelAndView();
		try {
			cate.save(categoria);
		}catch(Exception e) {
			e.printStackTrace();
		}
		String variable= "Categoria ingresada con exito";
		mav.addObject("variable", variable);
		
		mav.addObject("categoria", categoria);
		mav.setViewName("index");
		return mav;
	}
	
	
	@RequestMapping("/libro")
	public ModelAndView libro(@ModelAttribute Libro libro) {
		ModelAndView mav = new ModelAndView();
		

		List<Categoria> categoriaLista = null;
		categoriaLista=cate.findAll();
		mav.addObject("categoriaLista",categoriaLista);
		
		
		
		mav.addObject("libro", libro);
		mav.setViewName("libro");
		return mav;
	}
	
	
	@RequestMapping("/ingresarLibro")
	public ModelAndView ingresar(@ModelAttribute Libro libro) {
		ModelAndView mav = new ModelAndView();
		try {
			
            Date date = new Date(System.currentTimeMillis());
            libro.setF_ingreso(date);
		    
			book.save(libro);
		}catch(Exception e) {
			e.printStackTrace();
		}
		

		
		String variable= "Libro ingresada con exito";
		mav.addObject("variable", variable);
		
		mav.addObject("libro", libro);
		mav.setViewName("index");
		return mav;
	}
	
	

	
	@RequestMapping("/mostrar")
	public ModelAndView mostrar() {
		ModelAndView mav = new ModelAndView();
		
		List<Libro> libroLista = null;
		
		try {
			libroLista=book.findAll();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		mav.addObject("libroLista", libroLista);
		mav.setViewName("mostrar");
		return mav;
	}
}
