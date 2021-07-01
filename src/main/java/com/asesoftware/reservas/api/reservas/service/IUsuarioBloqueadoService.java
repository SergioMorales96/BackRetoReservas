package com.asesoftware.reservas.api.reservas.service;



import com.asesoftware.reservas.api.reservas.dto.ResponseDTO;
import com.asesoftware.reservas.api.reservas.dto.UsuarioBloqueadoDTO;

public interface IUsuarioBloqueadoService {
	
	public ResponseDTO consultarTodosLosUsuariosBloqueados();
	public ResponseDTO consultarUsuarioBloqueadoPorId(String correo);
	public ResponseDTO actualizarUsuarioBloqueado(UsuarioBloqueadoDTO usuarioBloqueadoDTO);
}
