package com.asesoftware.reservas.api.reservas.service;



import com.asesoftware.reservas.api.reservas.dto.HorarioPuestoTrabajoDTO;
import com.asesoftware.reservas.api.reservas.dto.ResponseDTO;

public interface IHorarioPuestoTrabajoService {
	public ResponseDTO horarioPorId(String idHorario);
	public ResponseDTO consultarTodos();
	public ResponseDTO actualizarHorarioPuestoTrabajo(HorarioPuestoTrabajoDTO empresaDTO);
	public ResponseDTO borrarHorarioPorId(String idHorario);
	
}
