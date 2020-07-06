package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Usuario;

@Controller
//@RequestMapping
public class MainController {
	
	@GetMapping("/agregarUsuario")
	public String enviarForm(Usuario usuario) {
		
		
		return "agregarUsuario";
	}
	
	@PostMapping("/agregarUsuario")
	public String procesarForm(Usuario usuario) {
		return "mostrarMensaje";
	}

}
