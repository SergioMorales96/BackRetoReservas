package com.asesoftware.reservas.api.reservas.service;

import com.asesoftware.reservas.api.reservas.dto.PuestoTrabajoDTO;
import com.asesoftware.reservas.api.reservas.dto.ResponseDTO;

public interface IPuestoTrabajoService {
	
	public ResponseDTO consultarTodas();
	
	public ResponseDTO PuestoTrabajoById(Integer idPuestoTrabajo);
	
	public ResponseDTO crearPuestoTrabajo(PuestoTrabajoDTO puestoTrabajoDTO);
	
	public ResponseDTO actualizarPuestoTrabajo(PuestoTrabajoDTO puestoTrabajoDTO);
	
	public ResponseDTO borrarPuestoTrabajo(Integer idPuestoTrabajo);

}
