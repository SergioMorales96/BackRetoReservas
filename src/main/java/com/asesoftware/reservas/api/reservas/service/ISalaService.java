package com.asesoftware.reservas.api.reservas.service;

import com.asesoftware.reservas.api.reservas.dto.ResponseDTO;

import com.asesoftware.reservas.api.reservas.dto.SalaDTO;


public interface ISalaService {
	
	public ResponseDTO listarTodosSalas();
	
	public ResponseDTO obtenerSalaPorId(Integer id);
	
	public ResponseDTO crearSala(SalaDTO salaDTO);
	
	public ResponseDTO actualizarSala(SalaDTO salaDTO);
	
	public ResponseDTO eliminarSala(Integer idSala);

}
