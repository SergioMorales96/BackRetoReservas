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
	* Controlador disponibilidadParqueaderoMoto para usar el SP PRO_DIS_PAR_MOTO
	* @author cfcruz
	* @version 0.1, 2021/07/13
	*/
	@GetMapping(path = "/disponibilidadParqueaderoMoto/{fecha}")
	public ResponseDTO disponibilidadParqueaderoMoto(@PathVariable String fecha) {

		logger.info("ingreso al metodo disponibilidadParqueaderoMoto {}", fecha);
		
		return reservaService.disponibilidadParqueaderoMoto(fecha);
	}
	
	/**
	* Controlador disponibilidadParqueaderoMoto para usar el SP PR_DIS_PAR_BICICLETA
	* @author jortizg
	* @version 0.1, 2021/07/08
	*/
	@GetMapping(path = "/disponibilidadParqueaderoBicis/{fecha}")
	public ResponseDTO disponibilidadParqueaderoBicis(@PathVariable String fecha) {

		logger.info("ingreso al metodo disponibilidadParqueaderoBicis {}", fecha);
		
		return reservaService.disponibilidadParqueaderoBicis(fecha);
	}
	
	/**
	* Controlador disponibilidadParqueaderoBicis para usar el SP PR_CON_PARQUEADEROS_CARRO
	* @author kpinilla
	* @version 0.1, 2021/07/08
	*/
	@GetMapping(path = "/disponibilidadParqueaderoCarro/{fecha}")
	public ResponseDTO disponibilidadParqueaderoCarro(@PathVariable String fecha) {

		logger.info("ingreso al metodo disponibilidadParqueaderoCarro {}", fecha);
		
		return reservaService.disponibilidadParqueaderoCarro(fecha);
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
	
	/**
	* Controlador consultaCalendarioPuestos para usar el procedimiento almacenado 
	* @author acmoya
	* @version 0.1, 12/07/2021
	*/
	@GetMapping(path = "/reservas_puesto/{id}/{fechaInicio}/{fechaFin}")
	public ResponseDTO consultaCalendarioPuestos(@PathVariable Integer id, @PathVariable String fechaInicio, @PathVariable String fechaFin) {
		
		logger.info("Ingreso al metodo consultaCalendarioPuestos() id: {} fecha inicio: {} fecha fin {}", id, fechaInicio, fechaFin);
		
		return reservaService.consultaCalendarioPuestos(id, fechaInicio, fechaFin);
	}
	/**
	* Controlador que gestiona la solicitud para consultar las reservas por día de las salas
	* @author wsierra
	* @version 0.1, 2021/07/09
	*/
	@GetMapping(path = "/reservas_sala_dia/{fecha}")
	public ResponseDTO consultaXDiaS(@PathVariable String fecha) {
		
		logger.info("consultaXDiaS() ");
		
		return reservaService.consultarReservaXDiaS(fecha);
	}
	
	@GetMapping(path = "reservas_aforo_dia/{fecha}/{idPiso}")
	public ResponseDTO consultaAforo(@PathVariable String fecha, @PathVariable Integer idPiso) {
		
		logger.info("consultaAforo() {}", fecha);
		
		return reservaService.validarAforoDia(fecha, idPiso);
	}
	
	/**
	* Controlador que gestiona la solicitud para consultar las reservas de un usuario
	* @author abarrios
	* @version 0.1, 2021/07/13
	*/
	@GetMapping(path = "/reservas_usuario/{fechaInicio}/{fechaFin}/{correo}")
	public ResponseDTO consultaReservaUsuario(@PathVariable String fechaInicio, @PathVariable String fechaFin, @PathVariable String correo) {
		
		logger.info("consultaReservaUsuario fechaInicio: {} fechaFin: {} correo {}", fechaInicio,fechaFin, correo );
		
		return reservaService.consultaReservaUsuario(fechaInicio,fechaFin, correo);
	}
	
	
	
}
