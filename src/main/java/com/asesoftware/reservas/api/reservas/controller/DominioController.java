package com.asesoftware.reservas.api.reservas.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asesoftware.reservas.api.reservas.dto.DominioDTO;
import com.asesoftware.reservas.api.reservas.dto.ResponseDTO;
import com.asesoftware.reservas.api.reservas.service.IDominioService;



@RestController
@RequestMapping(path="/api/v1/dominio")
public class DominioController {
	
	private static final Logger logger  = LoggerFactory.getLogger(DominioController.class);
	
	@Autowired
	private IDominioService dominioService;
	
	//listar todo
	@GetMapping(path="/all")
	public ResponseDTO readDominio() {
	
	return dominioService.readDominio();
	}
	
	//crear
	@PostMapping(path="/create", consumes="application/json", produces="application/json")
	public ResponseDTO createDominio(@RequestBody DominioDTO entity) {
		
		return dominioService.createDominio(entity);
	}
	
	
	
	//actualizar
	@PostMapping(path="/update", consumes="application/json", produces="application/json")
	public ResponseDTO updateDominio(@RequestBody DominioDTO entity) {
		
		return dominioService.updateDominio(entity);
	}
	
	
	//eliminar
}
