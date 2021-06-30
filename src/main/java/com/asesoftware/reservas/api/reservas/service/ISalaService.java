package com.asesoftware.reservas.api.reservas.service;

import com.asesoftware.reservas.api.reservas.dto.ResponseDTO;

public interface ISalaService {
	
	public ResponseDTO listarTodoSalas();
	
	public ResponseDTO obtenerSalaPorId(Integer id);
}
