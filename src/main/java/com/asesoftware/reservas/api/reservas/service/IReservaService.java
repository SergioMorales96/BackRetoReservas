package com.asesoftware.reservas.api.reservas.service;

import com.asesoftware.reservas.api.reservas.dto.ResponseDTO;

public interface IReservaService {

	public ResponseDTO consultarReservaXDiaPT(String fechaString);
	public ResponseDTO consultaCalendarioSalas(Integer id, String fechaInicio, String fechaFin);
	
	
	
	public ResponseDTO disponibilidadParqueaderoBicis(String fechaString);
}
