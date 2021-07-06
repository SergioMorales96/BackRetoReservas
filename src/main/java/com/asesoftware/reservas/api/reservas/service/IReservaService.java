package com.asesoftware.reservas.api.reservas.service;

import java.util.Date;

import com.asesoftware.reservas.api.reservas.dto.ResponseDTO;

public interface IReservaService {

	public ResponseDTO consultarReservaXDiaPT(Date fecha);
	
}
