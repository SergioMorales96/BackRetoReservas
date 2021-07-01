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
	
	@Autowired
	private ISalaService salaService;

	@GetMapping(path = "/todas")
	public ResponseDTO listarTodosSalas() {
		logger.info("ListarTodoSalas");
		return salaService.listarTodosSalas();
	}
	@GetMapping(path = "{id}")
	public ResponseDTO obtenerSalaPorId(@PathVariable Integer id) {
		logger.info("obtenerSalaPorId: {}",id);
		return salaService.obtenerSalaPorId(id);
	}
	@PostMapping(path = "/crear", consumes = "application/json",produces = "application/json")
	public ResponseDTO crearSala(@RequestBody SalaDTO entity) {
		return salaService.crearSala(entity); 
	}
	
	public ResponseDTO actualizarSala(){
		return null;
	}
	
	public ResponseDTO eliminarSala() {
		return null;
	}
	
}
