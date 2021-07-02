package com.asesoftware.reservas.api.reservas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.asesoftware.reservas.api.reservas.dto.ResponseDTO;
import com.asesoftware.reservas.api.reservas.dto.SucursalDTO;
import com.asesoftware.reservas.api.reservas.service.ISucursalService;

@RestController
@RequestMapping(path = "/api/v1/sucursales")
public class SucursalController {

	@Autowired
	private ISucursalService sucursalService;


//	@GetMapping(path = "/all")
//	public ResponseDTO getAll(){
//
//		return sucursalService.getAll();
//	}


	// Listar Sucursal por ID

	@GetMapping(path = "/sucursales/{id}")
	public ResponseDTO getSucursalById(@PathVariable Integer id) {

		return sucursalService.getSucursalById(id);
	}

	@GetMapping(path = "/sucursales")
	public ResponseDTO getSucursalParametroById(@RequestParam Integer id) {

		return sucursalService.getSucursalById(id);
	}


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
