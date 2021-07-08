package com.asesoftware.reservas.api.reservas.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asesoftware.reservas.api.reservas.dto.ResponseDTO;
import com.asesoftware.reservas.api.reservas.service.IReservaService;

@RestController
@RequestMapping(path = "/api/v1/reservas")
@CrossOrigin(origins = "*")
public class ReservaController {

	private static final Logger logger  = LoggerFactory.getLogger(ReservaController.class);
	
	@Autowired
	private IReservaService reservaService;
	
	/**
	* Controlador para acceder al método filtrar reservas por día PT - SP
	* @author jcanizales
	* @version 0.1, 2021/07/06
	*/
	
	@GetMapping(path = "/reserva_fecha/{fecha}")
	public ResponseDTO consultarReservaXDiaPT(@PathVariable String fecha) {

		logger.info("ingreso al metodo consultarReservaXDiaPT {}", fecha);
		
		return reservaService.consultarReservaXDiaPT(fecha);
	}
	
	
	/**
	* Controlador que gestiona la solicitud para consultar el calendario de una sala
	* @author ajgutierrez
	* @version 0.1, 2021/07/08
	*/
	@GetMapping(path = "/reservas_sala/{id}/{fechaInicio}/{fechaFin}")
	public ResponseDTO consultaCalendarioSalas(@PathVariable Integer id, @PathVariable String fechaInicio, @PathVariable String fechaFin) {
		
		logger.info("consultaCalendarioSalas() id: {} fecha inicio: {} fecha fin {}", id, fechaInicio, fechaFin);
		
		return reservaService.consultaCalendarioSalas(id, fechaInicio, fechaFin);
	}
	
	
}
