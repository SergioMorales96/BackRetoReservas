package com.asesoftware.reservas.api.reservas.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asesoftware.reservas.api.reservas.dto.ResponseDTO;
import com.asesoftware.reservas.api.reservas.service.IReservaService;

@RestController
@RequestMapping(path = "/api/v1/reservas")
public class ReservaController {

	private static final Logger logger  = LoggerFactory.getLogger(ReservaController.class);
	
	private IReservaService reservaService;
	
	/**
	* Controlador para acceder al método filtrar reservas por día PT - SP
	* @author jcanizales
	* @version 0.1, 2021/07/06
	*/
	
	@GetMapping(path = "/reserva_fecha/{fecha}")
	public ResponseDTO consultarReservaXDiaPT(@PathVariable Date fecha) {

		logger.info("ingreso al metodo consultarReservaXDiaPT {}", fecha);
		
		return reservaService.consultarReservaXDiaPT(fecha);
	}
	
	
	
	
}
