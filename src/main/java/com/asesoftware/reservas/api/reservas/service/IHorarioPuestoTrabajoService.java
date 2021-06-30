package com.asesoftware.reservas.api.reservas.service;

import com.asesoftware.reservas.api.reservas.dto.HorarioPuestoTrabajoDTO;
import com.asesoftware.reservas.api.reservas.dto.ResponseDTO;

public interface IHorarioPuestoTrabajoService {
	public ResponseDTO consultarHorarioPorId(Integer idHorario);

	public ResponseDTO consultarTodos();

	public ResponseDTO crearHorario();

	public ResponseDTO actualizarHorarioPuestoTrabajo(HorarioPuestoTrabajoDTO empresaDTO);

	public ResponseDTO borrarHorarioPorId(Integer idHorario);
}
