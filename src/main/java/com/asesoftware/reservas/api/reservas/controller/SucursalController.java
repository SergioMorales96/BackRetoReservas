package com.asesoftware.reservas.api.reservas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.asesoftware.reservas.api.reservas.dto.ResponseDTO;
import com.asesoftware.reservas.api.reservas.dto.SucursalDTO;
import com.asesoftware.reservas.api.reservas.service.ISucursalService;

@RestController
@RequestMapping(path = "/api/v1/sucursales")
public class SucursalController {
	
	@Autowired
	private ISucursalService sucursalService;
	
	
		// Crear Sucursal
	
		@PostMapping(path = "/crear", consumes = "application/json", produces = "application/json")
		public ResponseDTO createSucursal(@RequestBody SucursalDTO entity) {
						
			return sucursalService.createSucursal(entity);
		}
		
		// Editar Sucursal
		
		@PostMapping(path = "/editar", consumes = "application/json", produces = "application/json")
		public ResponseDTO editarSucursal(@RequestBody SucursalDTO entity) {
						
			return sucursalService.updateSucursal(entity);
		}

}
