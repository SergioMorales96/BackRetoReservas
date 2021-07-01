package com.asesoftware.reservas.api.reservas.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.asesoftware.reservas.api.reservas.dto.ResponseDTO;
import com.asesoftware.reservas.api.reservas.dto.UsuarioAdministradorDTO;
import com.asesoftware.reservas.api.reservas.mapper.IUsuarioAdministradorMapper;
import com.asesoftware.reservas.api.reservas.repository.IUsuarioAdministradorRepository;

@Service
public class UsuarioAdministradorService implements IUsuarioAdministradorService{
	
	private static final Logger logger = LoggerFactory.getLogger(UsuarioAdministradorService.class);
	
	@Autowired
	private IUsuarioAdministradorRepository usuarioAdminRepository;
	
	@Autowired
	private IUsuarioAdministradorMapper usuarioAdminMapper;

	@Override
	public ResponseDTO adminPorSucursal(Integer idSucursal) {
		
		logger.info("ingreso al método adminPorSurcursal()");
		
		List<UsuarioAdministradorDTO> listUsuarioAdministradorSucursal = usuarioAdminMapper.entitysToDtos(usuarioAdminRepository.queryAdminPorSucursal(idSucursal));
			
		logger.info("Se realizó busqueda de administradores de la sucursal {}", idSucursal);
		
		return new ResponseDTO(listUsuarioAdministradorSucursal, true, "Consulta con éxito", HttpStatus.OK);
			
	}

}
