package com.capas.TareaTres.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.capas.TareaTres.domain.Product;


@Controller
public class ProductController {
	
	private List<Product> productos = new ArrayList<Product>();
	
	@GetMapping("/compraProducto")
	public ModelAndView compraProducto() {
		ModelAndView mav = new ModelAndView();
		
		productos.add(new Product(0,"GTA5",60));
		productos.add(new Product(1,"MINECRAFT",20));
		productos.add(new Product(2,"FIFA",10));
		productos.add(new Product(3,"COD",8));
		productos.add(new Product(4,"GRAN TURISMO",20));
		
		mav.setViewName("select");
		mav.addObject("product", new Product());
		mav.addObject("producto", productos);
		
		return mav;
	}
		
	
	@PostMapping("/validar")
	public ModelAndView validar(Product product, @RequestParam(value="cantidad") String var1) {
		
		ModelAndView mav = new ModelAndView();
		
		int numero = Integer.parseInt(var1);
		
		if(productos.get(product.getId()).getCantidad() == numero ) {
			mav.setViewName("compra");
			mav.addObject("productos", this.productos.get(product.getId()));
			return mav;
		}
		else {
			mav.setViewName("error");
			mav.addObject("productos", this.productos.get(product.getId()));
			return mav;	
		}
	}
	
	
	
	
	/*@PostMapping("/validar")
	//@ResponseBody
	public String validar(Product product, @RequestParam(value="cantidad") String var1) {
		
		int numero = Integer.parseInt(var1);
		
		if(productos.get(product.getId()).getCantidad() == numero ) {
			return "El producto "+productos.get(product.getId()).getNombre()+" se puede adquirir";
		}
		else {
			return "El producto "+productos.get(product.getId()).getNombre()+" NO se puede adquirir";
		}
		//return productos.get(product.getId()).getNombre();
	}*/
}
