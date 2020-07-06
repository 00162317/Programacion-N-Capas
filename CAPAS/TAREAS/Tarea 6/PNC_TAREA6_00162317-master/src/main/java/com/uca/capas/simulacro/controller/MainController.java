package com.uca.capas.simulacro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.simulacro.dao.ContribuyenteDAO;
import com.uca.capas.simulacro.dao.ImportanciaDAO;
import com.uca.capas.simulacro.domain.Contribuyente;
import com.uca.capas.simulacro.domain.Importancia;
import com.uca.capas.simulacro.service.ContribuyenteService;
import com.uca.capas.simulacro.service.ImportanciaService;

/*--------------------------------------------BD EN POSTGRES
 * CREATE TABLE importancia(
	c_importancia serial NOT NULL PRIMARY KEY,
	nombre character varying(50)
);

INSERT INTO IMPORTANCIA VALUES(1,'Grandes');
INSERT INTO IMPORTANCIA VALUES(2,'Medianos');
INSERT INTO IMPORTANCIA VALUES(3,'Otros');

SELECT * FROM IMPORTANCIA;

CREATE TABLE contribuyente(
	c_contribuyente serial NOT NULL PRIMARY KEY,
	s_nombre character varying(50),
	s_apellido character varying(50),
	s_nit character varying(50),
	f_fecha_ingreso date,
	c_importancia serial
);

ALTER TABLE contribuyente ADD CONSTRAINT c_importancia FOREIGN KEY
(c_importancia)
REFERENCES importancia (c_importancia);

INSERT INTO contribuyente
VALUES(1,'Roberto','Hernandez','123456','12/2/2020',2);

SELECT * FROM contribuyente;

DELETE FROM CONTRIBUYENTE*/


@Controller
@Service
public class MainController {

	
	
	@Autowired
	private ImportanciaService importanciaDAO;
	
	@Autowired
	private ContribuyenteService contribuyenteDAO;
	
	@RequestMapping("/index")
	public ModelAndView index(@ModelAttribute Contribuyente contribuyente){
		ModelAndView mav = new ModelAndView();
		
		List<Importancia> importanciaLista = null;
		importanciaLista=importanciaDAO.findAll();
		mav.addObject("importanciaLista",importanciaLista);
		
		
		
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping("/ingresar")
	public ModelAndView ingresar(@ModelAttribute Contribuyente contribuyente) {
		ModelAndView mav = new ModelAndView();
		
		contribuyenteDAO.save(contribuyente);
		mav.addObject("contribuyente", contribuyente);
		mav.setViewName("respuesta");
		return mav;
	}
	
	@RequestMapping("/mostrarContribuyentes")
	public ModelAndView mostrarContribuyentes() {
		ModelAndView mav = new ModelAndView();
		
		List<Contribuyente> contribuyentes = null;
		
		try {
			contribuyentes=contribuyenteDAO.findAll();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		mav.addObject("contribuyentes",contribuyentes);
		
		mav.setViewName("mostrar");
		return mav;
	}
}
