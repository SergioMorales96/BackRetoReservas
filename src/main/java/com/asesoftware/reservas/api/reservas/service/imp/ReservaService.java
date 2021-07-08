package com.asesoftware.reservas.api.reservas.service.imp;

import static com.asesoftware.reservas.api.reservas.utils.Constantes.OK;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.asesoftware.reservas.api.reservas.dto.ReservasPTDiaSPDTO;
import com.asesoftware.reservas.api.reservas.dto.ResponseDTO;
import com.asesoftware.reservas.api.reservas.repository.ParqueaderoBicicletaEMRepository;
import com.asesoftware.reservas.api.reservas.repository.ReservaEMRepository;
import com.asesoftware.reservas.api.reservas.service.IReservaService;

@Service
public class ReservaService implements IReservaService{

	private static final Logger logger = LoggerFactory.getLogger(ReservaService.class);
	
	@Autowired
	ReservaEMRepository reservasPorDiaRepository;
	
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
	

}
