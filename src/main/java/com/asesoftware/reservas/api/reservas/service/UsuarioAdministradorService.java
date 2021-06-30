package com.asesoftware.reservas.api.reservas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.asesoftware.reservas.api.reservas.dto.ResponseDTO;
import com.asesoftware.reservas.api.reservas.dto.UsuarioAdministradorDTO;
import com.asesoftware.reservas.api.reservas.mapper.IUsuarioAdministradorMapper;
import com.asesoftware.reservas.api.reservas.repository.IUsuarioAdministradorRepository;

@Service
public class UsuarioAdministradorService implements IUsuarioAdministradorService{
	
	@Autowired
	private IUsuarioAdministradorRepository usuarioAdminRepository;
	
	@Autowired
	private IUsuarioAdministradorMapper usuarioAdminMapper;

	@Override
	public ResponseDTO adminPorSucursal(Integer idSucursal) {
		
		List<UsuarioAdministradorDTO> listUsuarioAdministradorSucursal = usuarioAdminMapper.entitysToDtos(usuarioAdminRepository.queryAdminPorSucursal(idSucursal));
			
		return new ResponseDTO(listUsuarioAdministradorSucursal, true, "Ok", HttpStatus.OK);
			
	}

}
