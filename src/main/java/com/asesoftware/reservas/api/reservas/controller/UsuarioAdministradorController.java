package com.asesoftware.reservas.api.reservas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asesoftware.reservas.api.reservas.dto.ResponseDTO;
import com.asesoftware.reservas.api.reservas.service.IUsuarioAdministradorService;

@RestController
@RequestMapping(path = "api/v1/useradmin")
public class UsuarioAdministradorController {
	
	@Autowired
	private IUsuarioAdministradorService usuarioAdminService;
	
	@GetMapping(path = "sucursal/{id}")
	public ResponseDTO adminPorSucursal(@PathVariable Integer id) {
		
		return usuarioAdminService.adminPorSucursal(id);
	}

}
