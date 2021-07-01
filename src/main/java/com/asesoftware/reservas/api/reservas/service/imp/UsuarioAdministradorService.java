package com.asesoftware.reservas.api.reservas.service.imp;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.asesoftware.reservas.api.reservas.dto.ResponseDTO;
import com.asesoftware.reservas.api.reservas.entity.UsuarioAdministradorEntity;
import com.asesoftware.reservas.api.reservas.mapper.IUsuarioAdministradorMapper;
import com.asesoftware.reservas.api.reservas.repository.IAdministradorRepository;
import com.asesoftware.reservas.api.reservas.service.IUsuarioAdministradorService;

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

	@Override
	public ResponseDTO crearUsuario(UsuarioAdministradorEntity userAdmin) {
		logger.info("crear usuario");
		UsuarioAdministradorEntity usuarioAdministardor = administradorRepository.save(userAdmin);
		logger.info("crear usuario: {}", usuarioAdministardor);
		return new ResponseDTO(usuarioAdministardor, true, "Usuario creado", HttpStatus.OK);
	}

	@Override
	public ResponseDTO editarUsuario(UsuarioAdministradorEntity userAdmin) {
		logger.info("editar usuario");
		UsuarioAdministradorEntity usuarioAdministardor = administradorRepository.save(userAdmin);
		logger.info("editar usuario: {}", usuarioAdministardor);
		return new ResponseDTO(usuarioAdministardor, true, "Usuario modificado", HttpStatus.OK);
	}

	@Override
	public void eliminarUsuario(Integer idAdministrador) {
		logger.info("eliminar usuario");
		administradorRepository.deleteById(idAdministrador);
		logger.info("eliminado usuario con id: {}",idAdministrador);
	}

}
