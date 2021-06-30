package com.asesoftware.reservas.api.reservas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asesoftware.reservas.api.reservas.dto.ResponseDTO;
import com.asesoftware.reservas.api.reservas.service.IPisoService;

@RestController
@RequestMapping(path = "/api/v1/piso")
public class PisoController {
	
	@Autowired
	private IPisoService pisoService;
	
	@GetMapping(path = "sucursal/{id}")
	public ResponseDTO pisoporIdSucursal(@PathVariable Integer id){
		
		return pisoService.pisoPorIdSucursal(id);
	}
}
