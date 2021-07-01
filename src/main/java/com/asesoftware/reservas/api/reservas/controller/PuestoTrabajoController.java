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

import com.asesoftware.reservas.api.reservas.dto.PuestoTrabajoDTO;
import com.asesoftware.reservas.api.reservas.dto.ResponseDTO;
import com.asesoftware.reservas.api.reservas.service.IPuestoTrabajoService;


@RestController
@RequestMapping(path="/api/v1/puestoTrabajo")
public class PuestoTrabajoController {
	
	private static final Logger logger = LoggerFactory.getLogger(PuestoTrabajoController.class);
	
	@Autowired
	private IPuestoTrabajoService puestoTrabajoService;
	
	@GetMapping(path = "/todas")
	public ResponseDTO consultarTodas() {
		logger.info("consultarTodas()");
		return puestoTrabajoService.consultarTodas();
	}
	
	@GetMapping(path = "/buscarPorId/{idPuestoTrabajo}")

	public ResponseDTO puestoTrabajoPorId(@PathVariable Integer idPuestoTrabajo) {
		
		logger.info("puestoTrabajoPorId: {}", idPuestoTrabajo);
		
		return puestoTrabajoService.puestoTrabajoPorId(idPuestoTrabajo);
		
	}
	@PostMapping(path = "/crear",consumes = "application/json",produces = "application/json")
	public ResponseDTO crearPuestoTrabajo(@RequestBody PuestoTrabajoDTO puestoTrabajoDTO) {
		logger.info("crearPuestoTrabajo: {}", puestoTrabajoDTO);
		return puestoTrabajoService.crearPuestoTrabajo(puestoTrabajoDTO);
		
	}
	@PostMapping(path = "/actualizar",consumes = "application/json",produces = "application/json")
	public ResponseDTO actualizarPuestoTrabajo(@RequestBody PuestoTrabajoDTO puestoTrabajoDTO) {
		logger.info("actualizarPuestoDeTrabajo: {}", puestoTrabajoDTO);
		
		return puestoTrabajoService.actualizarPuestoTrabajo(puestoTrabajoDTO);
		
	}
	@GetMapping(path = "/borrar")
	public ResponseDTO borrarPuestoTrabajo(Integer idPuestoTrabajo) {
		
		logger.info("Puesto de trabajo a eliminar {}",idPuestoTrabajo);
		
		return puestoTrabajoService.borrarPuestoTrabajo(idPuestoTrabajo);
	}
	
	
}
