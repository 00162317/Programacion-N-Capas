package com.uca.capas.tarea4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping("/producto")
	public String index() {
		return "producto/index";
	}

}
