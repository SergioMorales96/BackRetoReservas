package com.asesoftware.reservas.api.reservas.service;

import com.asesoftware.reservas.api.reservas.dto.PisoDTO;
import com.asesoftware.reservas.api.reservas.dto.ResponseDTO;

public interface IPisoService {
	
	public ResponseDTO consultarTodos();
	
	public PisoDTO consultarpisoPorId(Integer idPiso);
	
	public ResponseDTO pisoPorId(Integer idPiso);
	
	public ResponseDTO pisoPorNumeroPiso(Integer numeroPiso);
	
	public ResponseDTO crearPiso(PisoDTO pisoDTO);
	
	public ResponseDTO actualizarPiso(PisoDTO pisoDTO);
	
	public ResponseDTO eliminarPiso(Integer idPiso);
}
