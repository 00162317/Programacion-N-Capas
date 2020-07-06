package com.uca.capas.Tarea2.controller;


import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class MainController {

	@RequestMapping("/tarea")
	public @ResponseBody String tarea() {
		
		String nombre = "Roberto ",apellido = " Ernesto",carnet = " 00162317 ",
				carrera = " Ingenieria Informatica ",anio = " Cuarto año ";
			
		return "Nombbre: "+nombre +" Apellido: "+ apellido + " Carnet: " + carnet + " Carrera: "+ carrera + " Anio: " +anio; 
	}
	
	@RequestMapping("/parametro")
	public @ResponseBody String parametro(HttpServletRequest request) {
		Integer param = Integer.parseInt(request.getParameter("dia"));
		Integer param2 = Integer.parseInt(request.getParameter("mes"));
		Integer param3 = Integer.parseInt(request.getParameter("anio"));
		
		//Gracias Stack Overflow
		LocalDate ld = LocalDate.of(param3,param2,param);
		
		
		return "El dia es: " + ld.getDayOfWeek();

	}
}
