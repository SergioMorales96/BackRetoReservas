package com.asesoftware.reservas.api.reservas.service;

import com.asesoftware.reservas.api.reservas.dto.ResponseDTO;
import com.asesoftware.reservas.api.reservas.entity.UsuarioAdministradorEntity;

public interface IUsuarioAdministradorService {
	
	
	public ResponseDTO usuarioAdministradorPorId(Integer idAdministrador);
	public ResponseDTO consultarTodos();
	public ResponseDTO crearUsuario(UsuarioAdministradorEntity userAdmin);
	public ResponseDTO editarUsuario(UsuarioAdministradorEntity userAdmin);
	public void eliminarUsuario(Integer idAdministrador);
	public ResponseDTO usuarioAdministradorPorEmail(String email);

}
