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

import com.asesoftware.reservas.api.reservas.dto.ResponseDTO;
import com.asesoftware.reservas.api.reservas.dto.UsuarioAdministradorDTO;
import com.asesoftware.reservas.api.reservas.service.IUsuarioAdministradorService;

@RestController
@RequestMapping(path = "/api/v1/usuarioAdministrador")
@CrossOrigin(origins = "*")
public class UsuarioAdministradorController {
	
	
	private static final Logger logger = LoggerFactory.getLogger(UsuarioAdministradorController.class);
	
	@Autowired
	private IUsuarioAdministradorService usuarioAdminService;
	
	
	/**
	* Método que llama al servicio que retorna usuario administrador por id
	* @author cvlopez
	* @version 0.1, 2021/07/01
	*/
	@GetMapping(path = "/{idAdministrador}")
	public ResponseDTO usuarioAdministradorPorId(@PathVariable Integer idAdministrador) {
		
		logger.info("UsuarioAministradorPorId:{}", idAdministrador);
		
		return usuarioAdminService.usuarioAdministradorPorId(idAdministrador);
	}
	
	/**
	* Método que llama al servicio que retorna listado con todos los administradores
	* @author cvlopez 
	* @version 0.1, 2021/07/01
	*/	
	@GetMapping(path = "/todos")
	public ResponseDTO consultarTodos() {
		logger.info("consultarTodos()");
		
		return usuarioAdminService.consultarTodos();

	}
		
	/**
	* Método encargado de consultar los usuarios administradores por sucursal
	* @author wsierra
	* @version 0.1, 2021/07/01
	*/
	@GetMapping(path = "/sucursal/{id}")
	public ResponseDTO adminPorSucursal(@PathVariable Integer id) {
		
		logger.info("adminPorSucursal {}", id);
		
		return usuarioAdminService.adminPorSucursal(id);
	}
	
	/**
	* Método que llama al servicio que crea un nuevo usuario administrador
	* @author nbarreto 
	* @version 0.1, 2021/07/01
	*/
	@PostMapping(path ="/crear",consumes = "application/json", produces = "application/json")
	public ResponseDTO crearAdministrador(@RequestBody UsuarioAdministradorDTO admin) {
		logger.info("crear nuevo usuario{}",admin);
		return usuarioAdminService.crearUsuario(admin);
	}
	
	/**
	* Método que llama al servicio que edita un usuario administrador
	* @author nbarreto 
	* @version 0.1, 2021/07/01
	*/
	@PostMapping(path ="/editar",consumes = "application/json", produces = "application/json")
	public ResponseDTO editarAdministrador(@RequestBody UsuarioAdministradorDTO admin) {
		logger.info("editar usuario");
		return usuarioAdminService.editarUsuario(admin);
	}
	
	/**
	* Método que llama al servicio que elimina un usuario administrador según id
	* @author nbarreto 
	* @version 0.1, 2021/07/01
	*/
	@GetMapping(path = "/eliminar/{idAdministrador}")
	public ResponseDTO borrarAdministrador(@PathVariable Integer idAdministrador) {
		logger.info("eliminar usuarioPorId:{}",idAdministrador);
		return usuarioAdminService.eliminarUsuario(idAdministrador);
	}
	
	/**
	* Método que llama al servicio que busca un usuario administrador por email 
	* @author cvlopez 
	* @version 0.1, 2021/07/01
	*/
	@GetMapping(path = "/email/{email}")
	public ResponseDTO usuarioAdministradorPorEmail(@PathVariable String email) {
		
		return usuarioAdminService.usuarioAdministradorPorEmail(email);
	}
}
