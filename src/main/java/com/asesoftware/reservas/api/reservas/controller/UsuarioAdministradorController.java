package com.asesoftware.reservas.api.reservas.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asesoftware.reservas.api.reservas.dto.ResponseDTO;
import com.asesoftware.reservas.api.reservas.entity.UsuarioAdministradorEntity;
import com.asesoftware.reservas.api.reservas.service.IUsuarioAdministradorService;
import com.asesoftware.reservas.api.reservas.service.imp.EmpresaService;
import com.asesoftware.reservas.api.reservas.service.imp.UsuarioAdministradorService;

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
	
	@PostMapping(path ="/crear",consumes = "application/json", produces = "application/json")
	public ResponseDTO crearAdministrador(@RequestBody UsuarioAdministradorEntity admin) {
		logger.info("crear nuevo usuario");
		return usuarioAdminService.crearUsuario(admin);
	}
	
	@PostMapping(path ="/editar",consumes = "application/json", produces = "application/json")
	public ResponseDTO editarAdministrador(@RequestBody UsuarioAdministradorEntity admin) {
		logger.info("editar usuario");
		return usuarioAdminService.editarUsuario(admin);
	}

	@GetMapping(path = "/eliminar/{idAdministrador}")
	public void borrarAdministrador(@PathVariable Integer idAdministrador) {
		logger.info("eliminar usuarioPorId:{}",idAdministrador);
		usuarioAdminService.eliminarUsuario(idAdministrador);
	}
	
	@GetMapping(path = "/email/{email}")
	public ResponseDTO usuarioAdministradorPorEmail(@PathVariable String email) {
		
		return usuarioAdminService.usuarioAdministradorPorEmail(email);
	}
}
