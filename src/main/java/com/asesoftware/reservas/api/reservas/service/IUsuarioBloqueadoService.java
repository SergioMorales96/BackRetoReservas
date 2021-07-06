package com.asesoftware.reservas.api.reservas.service;



import com.asesoftware.reservas.api.reservas.dto.ResponseDTO;
import com.asesoftware.reservas.api.reservas.dto.UsuarioBloqueadoDTO;

public interface IUsuarioBloqueadoService {
	
	public ResponseDTO consultarTodosLosUsuariosBloqueados();
	public ResponseDTO consultarUsuarioBloqueadoPorId(String correo);
	public ResponseDTO crearUsuarioBloqueado(UsuarioBloqueadoDTO dto);
	public ResponseDTO actualizarUsuarioBloqueado(UsuarioBloqueadoDTO usuarioBloqueadoDTO);
	public ResponseDTO eliminarUsuarioBloqueado(Integer id);
	public ResponseDTO consultarUsuariosBloqueadosPorSucursal(Integer id);
}
