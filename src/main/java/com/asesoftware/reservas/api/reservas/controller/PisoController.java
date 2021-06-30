package com.asesoftware.reservas.api.reservas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asesoftware.reservas.api.reservas.dto.PisoDTO;
import com.asesoftware.reservas.api.reservas.dto.ResponseDTO;
import com.asesoftware.reservas.api.reservas.service.IPisoService;

@RestController
@RequestMapping(path = "/api/v1/piso")
public class PisoController {
	
	@Autowired
	private IPisoService pisoService;
	
	@GetMapping(path = "/todos")
	public ResponseDTO consultarTodos() {
		return pisoService.consultarTodos();
	}
	@PostMapping(path = "/crear", consumes = "application/json",produces = "application/json")
	public ResponseDTO crearPiso(@RequestBody PisoDTO dto) {
		return pisoService.crearPiso(dto);
		
	}
	
	@GetMapping(path = "/{idPiso}")
	public ResponseDTO pisoPorId(@PathVariable Integer idPiso) {
		return null;
	}

}
