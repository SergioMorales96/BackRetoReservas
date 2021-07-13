package com.asesoftware.reservas.api.reservas.service.imp;

import static com.asesoftware.reservas.api.reservas.utils.Constantes.OK;
import static com.asesoftware.reservas.api.reservas.utils.Constantes.ERROR_GENERICO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.asesoftware.reservas.api.reservas.dto.CalendarioPuestoDTO;
import com.asesoftware.reservas.api.reservas.dto.CalendarioSalaDTO;
import com.asesoftware.reservas.api.reservas.dto.ReservasPTDiaSPDTO;
import com.asesoftware.reservas.api.reservas.dto.ResponseDTO;

import com.asesoftware.reservas.api.reservas.repository.CalendarioSalaRepository;
import com.asesoftware.reservas.api.reservas.repository.CalendarioPuestoRepository;


import com.asesoftware.reservas.api.reservas.repository.ParqueaderoBicicletaEMRepository;
import com.asesoftware.reservas.api.reservas.repository.ReservaEMRepository;
import com.asesoftware.reservas.api.reservas.service.IReservaService;

@Service
public class ReservaService implements IReservaService{

	private static final Logger logger = LoggerFactory.getLogger(ReservaService.class);
	
	@Autowired
	ReservaEMRepository reservasPorDiaRepository;
	
	@Autowired
	CalendarioSalaRepository calendarioSalaRepository;
	
	@Autowired
	CalendarioPuestoRepository calendarioPuestoRepository; 
	
	@Autowired
	private ParqueaderoBicicletaEMRepository parqueaderoBicicletaEMRepository;
	
	/**
	* Método Consultar reservas por día PT
	* @author jcanizales
	* @version 0.1, 2021/07/06
	*/
	
	@Override
	public ResponseDTO consultarReservaXDiaPT(String fechaString) {
		
		SimpleDateFormat fechaFormat = new SimpleDateFormat("dd-MM-yyyy");
		
		Date fecha;
		try {
			fecha = fechaFormat.parse(fechaString);
			logger.info("ingreso al metodo consultarReservaXDiaPT de service {}", fecha);
			
			List<ReservasPTDiaSPDTO> listaReservasXDia = reservasPorDiaRepository.getReservaPTDia(fecha);
			return new ResponseDTO(listaReservasXDia, true, OK, HttpStatus.OK);
		} catch (ParseException e) {
			return new ResponseDTO(null, false, OK, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	* Servicio disponibilidadParqueaderoBicis para usar el SP PR_DIS_PAR_BICICLETA
	* @author jortizg
	* @version 0.1, 2021/07/08
	*/
	@Override
	public ResponseDTO disponibilidadParqueaderoBicis(String fechaString) {

		SimpleDateFormat fechaFormat = new SimpleDateFormat("dd-MM-yyyy");
		
		Date fecha;
		try {
			fecha = fechaFormat.parse(fechaString);
			logger.info("ingreso al metodo disponibilidadParqueaderoBicis de service {}", fecha);
			
			Integer parqueaderosDisponibles = parqueaderoBicicletaEMRepository.getDisponibilidadParqueaderoBicis(fecha);
			
			logger.info("salida del metodo disponibilidadParqueaderoBicis de service {}", parqueaderosDisponibles);
			
			if (parqueaderosDisponibles <= 0) {
				return new ResponseDTO(null, false, OK, HttpStatus.INTERNAL_SERVER_ERROR);
			} else {
				return new ResponseDTO(parqueaderosDisponibles, true, OK, HttpStatus.OK);
			}
			
		} catch (ParseException e) {
			return new ResponseDTO(null, false, OK, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

	/**
	* Consulta el calendario de una sala por medio de un procedimiento almacenado en el rango de las fechas especificadas
	* @author ajgutierrez
	* @version 0.1, 2021/07/08
	*/
	@Override
	public ResponseDTO consultaCalendarioSalas(Integer id, String fechaInicio, String fechaFin) {
		
		SimpleDateFormat fechaFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date fechaIn;
		Date fechaF;
		try {
			fechaIn = fechaFormat.parse(fechaInicio);
			fechaF = fechaFormat.parse(fechaFin);
			logger.info("consultaCalendarioSalas()");
			List<CalendarioSalaDTO> answ = calendarioSalaRepository.getCalendarioSala(id, fechaIn, fechaF);
			return new ResponseDTO(answ, true, OK, HttpStatus.OK);
			
		} catch (Exception e) {

			return new ResponseDTO(null, false, ERROR_GENERICO, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	/**
	* Servicio que consulta el calendario de un puesto de trabajo 
	* @author acmoya
	* @version 0.1, 12/07/2021
	*/
	@Override
	public ResponseDTO consultaCalendarioPuestos(Integer id, String fechaInicio, String fechaFin) {
		
		SimpleDateFormat fechaFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date fechaIn;
		Date fechaF;
		try {
			fechaIn = fechaFormat.parse(fechaInicio);
			fechaF = fechaFormat.parse(fechaFin);
			logger.info("Ingreso al metodo consultaCalendarioPuestos()");
			List<CalendarioPuestoDTO> answ = calendarioPuestoRepository.getCalendarioPuesto(id, fechaIn, fechaF);
			return new ResponseDTO(answ, true, OK, HttpStatus.OK);
			
		} catch (Exception e) {

			return new ResponseDTO(null, false, ERROR_GENERICO, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

}
