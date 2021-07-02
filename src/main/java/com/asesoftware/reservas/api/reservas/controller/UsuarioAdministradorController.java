package com.asesoftware.reservas.api.reservas.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asesoftware.reservas.api.reservas.dto.ResponseDTO;
import com.asesoftware.reservas.api.reservas.service.IUsuarioAdministradorService;



@RestController
@RequestMapping(path = "/api/v1/usuarioAdministrador")
public class UsuarioAdministradorController {
	
	
	private static final Logger logger = LoggerFactory.getLogger(UsuarioAdministradorController.class);
	
	@Autowired
	private IUsuarioAdministradorService usuarioAdminService;
	
	@GetMapping(path = "/{idAdministrador}")
	public ResponseDTO usuarioAdministradorPorId(@PathVariable Integer idAdministrador) {
		
		logger.info("UsuarioAministradorPorId:{}", idAdministrador);
		
		return usuarioAdminService.usuarioAdministradorPorId(idAdministrador);
	}
	
	@GetMapping(path = "/todos")
	public ResponseDTO consultarTodos() {
		logger.info("consultarTodos()");
		
		return usuarioAdminService.consultarTodos();
		
	}

}
