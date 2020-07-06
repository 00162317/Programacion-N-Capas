package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.domain.Usuario;

@Controller
public class MainController {
	
	private String nombre = "rob", pass = "hola";
	
	@GetMapping("/login")
	public String enviarLogin(Usuario usuario) {
		
		return "login";
		
	}
	
	//Usuario: rob
	//Contraseña: hola
	@PostMapping("/validacion")
	public String procesarLogin(Usuario usuario){
		if((usuario.getNombre().equals(nombre))&&(usuario.getContra().equals(pass))) {
			return "MostrarMensajeV";
		}
		else {
			return "MostrarMensajeF";
		}
	}
	
	/*
	@PostMapping(value="/validacion")
	public String procesarLogin(@RequestParam(value="nombre") String var1,
			@RequestParam(value="contra") String var2) {
		
	
		if((var1.equals(nombre))&&(var2.equals(pass))) {
			return "MostrarMensajeV";
		}
		
		return "MostrarMensajeF";
	}*/
}
