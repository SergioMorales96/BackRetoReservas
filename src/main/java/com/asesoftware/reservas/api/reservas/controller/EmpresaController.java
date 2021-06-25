package com.asesoftware.reservas.api.reservas.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asesoftware.reservas.api.reservas.dto.ResponseDTO;
import com.asesoftware.reservas.api.reservas.service.IEmpresaService;

@RestController
@RequestMapping(path = "/api/v1/empresa")
public class EmpresaController {
	
	private static final Logger logger = LoggerFactory.getLogger(EmpresaController.class);
	
	@Autowired
	private IEmpresaService empresaService;
	
	@GetMapping(path = "/{nit}")
	public ResponseDTO empresaPorId(@PathVariable String nit) {
		
		logger.info("empresaPorId: {}", nit);
		
		return empresaService.empresaPorId(nit);
	}

}
