package com.uca.capas.tarea5.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.tarea5.EstudianteDTO.EstudianteDTO;
import com.uca.capas.tarea5.dao.EstudianteDAO;
import com.uca.capas.tarea5.domain.Estudiante;
import com.uca.capas.tarea5.service.EstudianteService;

@Controller
@Service
public class MainController {

	@Autowired
	private EstudianteService estudianteDAO;

	Estudiante e = new Estudiante();

	@RequestMapping("/index")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		return mav;
	}

	@RequestMapping("/respuesta1")
	public ModelAndView respuesta1() {
		ModelAndView mav = new ModelAndView();

		List<Estudiante> estudiantes = null;
		try {
			estudiantes = estudianteDAO.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}

		mav.addObject("estudiantes", estudiantes);

		System.out.print(e.getNombre());
		mav.setViewName("respuesta1");
		return mav;
	}

	@RequestMapping("/respuesta2")
	public ModelAndView respuesta2(@ModelAttribute Estudiante estudiante) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("respuesta2");
		return mav;
	}

	@RequestMapping("/ingresar")
	public ModelAndView ingresar(@ModelAttribute Estudiante estudiante) {
		ModelAndView mav = new ModelAndView();
		estudianteDAO.insert(estudiante);
		mav.addObject("estudiante", estudiante);
		mav.setViewName("respuesta2");
		return mav;
	}

	// -----------------------------------------------------------------------
	// --------------- LABORATORIO 6

	@RequestMapping("/respuesta3")
	public ModelAndView respuesta3(@ModelAttribute Estudiante estudiante) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("respuesta3");
		return mav;
	}

	@RequestMapping(value = "/eliminar", method = RequestMethod.POST)
	public ModelAndView eliminar(@ModelAttribute Estudiante estudiante, @RequestParam(value = "c_usuario") int id) {
		ModelAndView mav = new ModelAndView();
		List<Estudiante> estudiantes = null;

		try {
			estudianteDAO.delete(id);
//			estudiantes=estudianteDAO.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}

		mav.addObject("estudiantes", estudiantes);
		mav.setViewName("respuesta3");
		return mav;
	}
	// -----------------------------------------------------------------------
	// --------------- LABORATORIO 7

	@RequestMapping("/respuesta4")
	public ModelAndView respuesta4(@ModelAttribute Estudiante estudiante) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("respuesta4");
		return mav;
	}

	@RequestMapping(value = "/filtrar")
	public ModelAndView filtrar(@ModelAttribute Estudiante estudiante, @RequestParam(value = "nombre") String cadena) {
		ModelAndView mav = new ModelAndView();
		List<Estudiante> estudiantes = null;

		try {
			estudiantes = estudianteDAO.findAll();
			estudiantes = estudianteDAO.filtrarPor(cadena);
			// estudiantes=estudianteDAO.empiezaCon(cadena);
		} catch (Exception e) {
			e.printStackTrace();
		}

		mav.addObject("estudiantes", estudiantes);
		mav.setViewName("respuesta4");
		return mav;
	}

	@RequestMapping("/mostrarDTO")
	public ModelAndView mostrarDTO(@ModelAttribute Estudiante estudiante) {
		ModelAndView mav = new ModelAndView();
		List<EstudianteDTO> estudiantes = null;

		try {
			estudiantes = estudianteDAO.dtoPrueba();
		} catch (Exception e) {
			e.printStackTrace();
		}

		mav.addObject("estudiantes", estudiantes);
		mav.setViewName("muestraDTO");
		return mav;
	}

	@RequestMapping("/respuesta5")
	public ModelAndView respuesta5(@ModelAttribute Estudiante estudiante) {
		ModelAndView mav = new ModelAndView();
		
		List<Estudiante> estudiantes = null;
		
		try {
			estudiantes = estudianteDAO.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}

		mav.addObject("estudiantes", estudiantes);
		mav.setViewName("respuesta5");
		return mav;
	}

	@RequestMapping("/editar")
	public ModelAndView editar(@ModelAttribute Estudiante estudiante, @RequestParam(value = "c_usuario") int id,
			@RequestParam(value = "nombre") String nombre, @RequestParam(value = "apellido") String apellido,
			@RequestParam(value = "carne") String carne, @RequestParam(value = "carrera") String carrera) {
		ModelAndView mav = new ModelAndView();

		List<Estudiante> estudiantes = null;

		try {
			estudianteDAO.editar(id, nombre, apellido, carne, carrera);
			estudiantes = estudianteDAO.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}

		mav.addObject("estudiantes", estudiantes);
		
		mav.setViewName("respuesta5");
		return mav;
	}

}
