package com.asesoftware.reservas.api.reservas.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.asesoftware.reservas.api.reservas.dto.ResponseDTO;
import com.asesoftware.reservas.api.reservas.dto.SalaDTO;
import com.asesoftware.reservas.api.reservas.service.ISalaService;


@RestController
@RequestMapping(path = "/api/v1/sala")
public class SalaController {
	
	private static final Logger logger = LoggerFactory.getLogger(SalaController.class);
	
	//listar todas las salas
	@Autowired
	private ISalaService salaService;
	
	@GetMapping(path = "/todas")
	public ResponseDTO listarTodoSalas() {
		logger.info("ListarTodoSalas");
		
		return salaService.listarTodoSalas();
	}
	//listar una sala
	@GetMapping(path = "sala/{id}")
	public ResponseDTO obtenerSalaPorId(@PathVariable Integer id) {
		logger.info("obtenerSalaPorId: {}",id);
		return salaService.obtenerSalaPorId(id);
	}
	
	// crear sala
	/*
	@PostMapping(path = "/crear", consumes = "application/json",produces = "application/json")
	public ResponseDTO createUser(@RequestBody SalaDTO entity) {
		
		return salaService.createUser(entity); 
	}
	*/
}
