package com.asesoftware.reservas.api.reservas.service;

import com.asesoftware.reservas.api.reservas.dto.HorarioPuestoTrabajoDTO;
import com.asesoftware.reservas.api.reservas.dto.ResponseDTO;

/**
 * @author jlucero
 * @param id, horarioPuestoTrabajoDTO, horarioPuestoTrabajoDTO
 * @return ResponseDTO Interface que declara los métodos principales que se van
 *         a implemetar para la entidad HorarioPuestoTrabajo.
 */
public interface IHorarioPuestoTrabajoService {
	public ResponseDTO consultarHorarioPorId(Integer idHorario);

	public ResponseDTO consultarTodos();

	public ResponseDTO crearHorario(HorarioPuestoTrabajoDTO horarioPuestoTrabajoDTO);

	public ResponseDTO actualizarHorarioPuestoTrabajo(HorarioPuestoTrabajoDTO horarioPuestoTrabajoDTO);

	public ResponseDTO borrarHorarioPorId(Integer idHorario);
}
