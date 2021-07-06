package com.asesoftware.reservas.api.reservas.service;

import com.asesoftware.reservas.api.reservas.dto.ResponseDTO;
import com.asesoftware.reservas.api.reservas.dto.UsuarioAdministradorDTO;

public interface IUsuarioAdministradorService {
	
	
	public ResponseDTO usuarioAdministradorPorId(Integer idAdministrador);
	public ResponseDTO consultarTodos();
	public ResponseDTO adminPorSucursal(Integer idSucursal);
	public ResponseDTO crearUsuario(UsuarioAdministradorDTO userAdmin);
	public ResponseDTO editarUsuario(UsuarioAdministradorDTO userAdmin);
	public ResponseDTO eliminarUsuario(Integer idAdministrador);
	public ResponseDTO usuarioAdministradorPorEmail(String email);

}
