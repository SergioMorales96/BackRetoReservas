package com.asesoftware.reservas.api.reservas.service.imp;

import static com.asesoftware.reservas.api.reservas.utils.Constantes.OK;

import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.asesoftware.reservas.api.reservas.dto.ReservasPTDiaSPDTO;
import com.asesoftware.reservas.api.reservas.dto.ResponseDTO;
import com.asesoftware.reservas.api.reservas.repository.ReservasPorDiaRepository;
import com.asesoftware.reservas.api.reservas.service.IReservaService;

public class ReservaService implements IReservaService{

	ReservasPorDiaRepository reservasPorDiaRepository;
	
	/**
	* Método Consultar reservas por día PT
	* @author jcanizales
	* @version 0.1, 2021/07/06
	*/
	
	@Override
	public ResponseDTO consultarReservaXDiaPT(Date fecha) {
		
		List<ReservasPTDiaSPDTO> listaReservasXDia = reservasPorDiaRepository.getReservaPTDia(fecha);
		return new ResponseDTO(listaReservasXDia, true, OK, HttpStatus.OK);
	}

}
