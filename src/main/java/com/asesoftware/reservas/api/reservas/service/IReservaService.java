package com.asesoftware.reservas.api.reservas.service;

import com.asesoftware.reservas.api.reservas.dto.ReservaAddDTO;
import com.asesoftware.reservas.api.reservas.dto.ResponseDTO;

public interface IReservaService {

	public ResponseDTO consultarReservaXDiaPT(String fechaString);
	public ResponseDTO consultaCalendarioSalas(Integer id, String fechaInicio, String fechaFin);
	public ResponseDTO consultaReservaUsuario(String correo, String fechaInicio, String fechaFin);
	public ResponseDTO consultaCalendarioPuestos(Integer id, String fechaInicio, String fechaFin);
	public ResponseDTO disponibilidadParqueaderoCarro(String fecha);
	public ResponseDTO disponibilidadParqueaderoBicis(String fechaString);
	public ResponseDTO disponibilidadParqueaderoMoto(String fechaString);
	public ResponseDTO consultarReservaXDiaS(String fechaString);
	public ResponseDTO validarAforoDia(String fecha, Integer idPiso);
	public ResponseDTO crearReserva(ReservaAddDTO reservaDto);
}
