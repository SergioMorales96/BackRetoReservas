package com.asesoftware.reservas.api.reservas.service.imp;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.asesoftware.reservas.api.reservas.dto.ResponseDTO;
import com.asesoftware.reservas.api.reservas.dto.UsuarioAdministradorDTO;
import com.asesoftware.reservas.api.reservas.entity.UsuarioAdministradorEntity;
import com.asesoftware.reservas.api.reservas.mapper.IUsuarioAdministradorMapper;
import com.asesoftware.reservas.api.reservas.repository.IAdministradorRepository;
import com.asesoftware.reservas.api.reservas.service.IUsuarioAdministradorService;
import static com.asesoftware.reservas.api.reservas.utils.Constantes.OK;

@Service
public class UsuarioAdministradorService implements IUsuarioAdministradorService{
	
	private static final Logger logger = LoggerFactory.getLogger(UsuarioAdministradorService.class);
	
	@Autowired
	private IAdministradorRepository administradorRepository;
	
	@Autowired
	private IUsuarioAdministradorMapper usuarioAdminMapper;

	@Override
	public ResponseDTO usuarioAdministradorPorId(Integer idAdministrador) {
		
		logger.info("usuarioAministradorPorId: {}", idAdministrador);
		
		Optional<UsuarioAdministradorEntity>  usuarioAdministradorEntity = administradorRepository.findById(idAdministrador);
		
		if(usuarioAdministradorEntity.isPresent()) {
			
			return new ResponseDTO(usuarioAdminMapper.entityToDto(usuarioAdministradorEntity.get()), true, "OK", HttpStatus.OK);
		}else {
			
			return new ResponseDTO(null, false, "Usuario no encontrado",HttpStatus.OK);
		}
		

	}

	@Override
	public ResponseDTO consultarTodos() {
		
		logger.info("consultarTodos()");
		
		List<UsuarioAdministradorEntity> listUsuarioAdministrador = administradorRepository.findAll();
		
		logger.info("consultarTodas() {}", listUsuarioAdministrador);
		
		return new ResponseDTO(usuarioAdminMapper.entitysToDtos(listUsuarioAdministrador), true, "OK", HttpStatus.OK);
	}
	
	/**
	* Método encargado de consultar los usuarios administradores por sucursal
	* @author wsierra
	* @version 0.1, 2021/07/01
	*/
	@Override
	public ResponseDTO adminPorSucursal(Integer idSucursal) {
		
		logger.info("adminPorSucursal {}", idSucursal);
		List<UsuarioAdministradorDTO> listUsuarioAdministradorSucursal = usuarioAdminMapper.entitysToDtos(administradorRepository.queryAdminPorSucursal(idSucursal));
			
		return new ResponseDTO(listUsuarioAdministradorSucursal, true, OK, HttpStatus.OK);
			
	}

}
