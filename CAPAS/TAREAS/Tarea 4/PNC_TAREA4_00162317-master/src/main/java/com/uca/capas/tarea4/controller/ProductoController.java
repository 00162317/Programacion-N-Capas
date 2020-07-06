package com.uca.capas.tarea4.controller;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import com.uca.capas.tarea4.domain.Producto;


@Controller
public class ProductoController {
	
	private List<Producto> productos = new ArrayList<Producto>();
	
	@RequestMapping("/productos")
		public ModelAndView procesar2(HttpServletRequest request,@Valid @ModelAttribute Producto producto, BindingResult result
				) throws ParseException {
		
			ModelAndView mav = new ModelAndView();
			
			
			String var1 = request.getParameter("codigo");
			String var2 = request.getParameter("nombre");
			String var3 = request.getParameter("marca");
			String var4 = request.getParameter("descripcion");
			Integer var5 = request.getIntHeader("existencias");

			
			if(result.hasErrors()) {
				
				mav.setViewName("producto/index");
				
			}
			else {
				
				productos.add(new Producto(var1,var2,var3,var4,var5,null));
				
				mav.addObject("product", new Producto());
				mav.addObject("productos", productos);
				
				mav.setViewName("producto/final");
				mav.addObject("codigo",producto.getCodigo());
				mav.addObject("nombre",producto.getNombre());
				mav.addObject("marca",producto.getMarca());
				mav.addObject("descripcion",producto.getDescripcion());
				mav.addObject("existencias",producto.getExistencias());
				mav.addObject("fechaIngreso",producto.getFechaIngreso());
			}
			
			return mav;
	}
	
	@InitBinder     
	public void initBinder(WebDataBinder binder){
	     binder.registerCustomEditor(       Date.class,     
	                         new CustomDateEditor(new SimpleDateFormat("dd/MM/yyyy"), true, 10));   
	}
}


