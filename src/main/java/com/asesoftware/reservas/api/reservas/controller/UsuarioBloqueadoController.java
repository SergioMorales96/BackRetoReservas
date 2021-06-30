package com.asesoftware.reservas.api.reservas.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asesoftware.reservas.api.reservas.dto.ResponseDTO;
import com.asesoftware.reservas.api.reservas.service.IUsuarioBloqueadoService;


@RestController
@RequestMapping(path = "/api/v1/usuarioBloqueado")
public class UsuarioBloqueadoController {
	
	private static final Logger logger = LoggerFactory.getLogger(UsuarioBloqueadoController.class);
	
	
	@Autowired
	private IUsuarioBloqueadoService usuarioBloqueadoService;
	
	
	@GetMapping(path = "/todos")
	public ResponseDTO consultarTodosLosUsuariosBloqueados() {
		logger.info("consultarTodosLosUsuariosBloqueados()");
		return this.usuarioBloqueadoService.consultarTodosLosUsuariosBloqueados();
	}
	
	
	@GetMapping(path = "/usuarioBloqueadoPorId/{correo}")
	public ResponseDTO consultarUsuarioBloqueadoPorId(@PathVariable String correo) {
		logger.info("consultarUsuarioBloqueadoPorId()");
		return this.usuarioBloqueadoService.consultarUsuarioBloqueadoPorId(correo);
	}
}
