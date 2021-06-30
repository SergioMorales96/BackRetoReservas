package com.asesoftware.reservas.api.reservas.service;



import com.asesoftware.reservas.api.reservas.dto.ResponseDTO;

public interface IUsuarioBloqueadoService {
	
	public ResponseDTO consultarTodosLosUsuariosBloqueados();
	public ResponseDTO consultarUsuarioBloqueadoPorId(String correo);
}
