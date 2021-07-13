package com.asesoftware.reservas.api.reservas.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asesoftware.reservas.api.reservas.dto.DominioDTO;
import com.asesoftware.reservas.api.reservas.dto.ResponseDTO;
import com.asesoftware.reservas.api.reservas.service.IDominioService;



@RestController
@RequestMapping(path="/api/v1/dominio")
@CrossOrigin(origins ="*")
public class DominioController {
	
	private static final Logger logger  = LoggerFactory.getLogger(DominioController.class);
	
	@Autowired
	private IDominioService dominioService;
	
	/**
	* Metodo encargado de consultar todos los dominios
	* @author abarrios
	* @version 0.1, 2021/07/02
	*/
	@GetMapping(path="/all")
	public ResponseDTO readDominio() {
	
		logger.info("ingreso al metodo buscar todos los dominios ");
		
		
	return dominioService.readDominio();
	}
	
	/**
	* Metodo encargado de crear un dominios
	* @author abarrios
	* @version 0.1, 2021/07/02
	*/
	@PostMapping(path="/create", consumes="application/json", produces="application/json")
	public ResponseDTO createDominio(@RequestBody DominioDTO entity) {
		
		logger.info("ingreso al metodo crear dominio ");
		
		return dominioService.createDominio(entity);
	}
	
	/**
	* Metodo encargado de Actualizar un dominios
	* @author smanrique
	* @version 0.1, 2021/07/02
	*/
	@PostMapping(path="/update", consumes="application/json", produces="application/json")
	public ResponseDTO updateDominio(@RequestBody DominioDTO entity) {
		
		logger.info("ingreso al metodo editar dominio ");
		
		
		return dominioService.updateDominio(entity);
	}
	

	/**
	* Metodo encargado de Eliminar un dominios
	* @author smanrique
	* @version 0.1, 2021/07/02
	*/
	@PostMapping(path="/delete", consumes="application/json", produces="application/json")
	public ResponseDTO deleteDominio(@RequestBody DominioDTO entity) {
		
		logger.info("ingreso al metodo eliminar dominio ");
		
		return dominioService.deleteDominio(entity);
	}
	
	
	@GetMapping(path = "/dominio/{codigoDominio}")
	public ResponseDTO readDominioByCodDomi(@PathVariable String codigoDominio) {
		
		return dominioService.readDominioByCodDomi(codigoDominio);
	}
}
