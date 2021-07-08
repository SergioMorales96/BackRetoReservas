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

import com.asesoftware.reservas.api.reservas.dto.EmpresaDTO;
import com.asesoftware.reservas.api.reservas.dto.ResponseDTO;
import com.asesoftware.reservas.api.reservas.service.IEmpresaService;

@RestController
@RequestMapping(path = "/api/v1/empresa")
@CrossOrigin(origins = "*")
public class EmpresaController {
	
	private static final Logger logger = LoggerFactory.getLogger(EmpresaController.class);
	
	@Autowired
	private IEmpresaService empresaService;
	
	@GetMapping(path = "/{nit}")
	public ResponseDTO empresaPorId(@PathVariable String nit) {
		
		logger.info("empresaPorId: {}", nit);
		
		return empresaService.empresaPorId(nit);
	}
	
	
	@GetMapping(path = "/todas")
	public ResponseDTO consultarTodas() {
		logger.info("consultarTodas()");
		return empresaService.consultarTodas();
	}
	
	@PostMapping(path = "/actualizar" , consumes = "application/json",produces = "application/json" )
	public ResponseDTO actualizarEmpresa(@RequestBody EmpresaDTO empresaDTO){
		logger.info("actualizar {}",empresaDTO);
		return empresaService.actualizarEmpresa(empresaDTO);
	}
	
	@PostMapping(path = "/crear" , consumes = "application/json",produces = "application/json" )
	public ResponseDTO crearEmpresa(@RequestBody EmpresaDTO empresaDTO){
		logger.info("crearEmpresa {}",empresaDTO);
		return empresaService.actualizarEmpresa(empresaDTO);
	}
	
	@GetMapping(path = "/eliminar/{nit}")
	public ResponseDTO eliminarEmpresa(@PathVariable String nit) {
		logger.info("consultarTodas() {}",nit);
		return empresaService.eliminarEmpresa(nit);
	}
	

}
