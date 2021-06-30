package com.asesoftware.reservas.api.reservas.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asesoftware.reservas.api.reservas.dto.ResponseDTO;
import com.asesoftware.reservas.api.reservas.service.IHorarioPuestoTrabajoService;

@RestController
@RequestMapping(path = "/api/v1/HorarioPuestoTrabajo")
public class HorarioPuestoTrabajoController {

	private static final Logger logger = LoggerFactory.getLogger(HorarioPuestoTrabajoController.class);

	@Autowired
	private IHorarioPuestoTrabajoService horarioPuestoTrabajoService;

	@GetMapping(path = "/todos")
	public ResponseDTO consultarTodos() {
		logger.info("consultarTodos()");
		return horarioPuestoTrabajoService.consultarTodos();
	}

	/**
	 * CONSULTAR POR ID Controlador que presta el servicio de consultar registro por
	 * id
	 * 
	 * @author jrondon
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping(path = "/horario/{id}")
	public ResponseDTO getUsuarioById(@PathVariable Integer id) {
		return horarioPuestoTrabajoService.consultarHorarioPorId(id);
	}

}
