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
import static com.asesoftware.reservas.api.reservas.utils.Constantes.ERROR_GENERICO;
import static com.asesoftware.reservas.api.reservas.utils.Constantes.OK;

@Service
public class UsuarioAdministradorService implements IUsuarioAdministradorService{
	
	private static final Logger logger = LoggerFactory.getLogger(UsuarioAdministradorService.class);
	
	@Autowired
	private IAdministradorRepository administradorRepository;
	
	@Autowired
	private IUsuarioAdministradorMapper usuarioAdminMapper;

	/**
	* Método que retorna DTO del usuario administrador por su id
	* @author cvlopez 
	* @version 0.1, 2021/07/01
	*/
	@Override
	public ResponseDTO usuarioAdministradorPorId(Integer idAdministrador) {
		
		logger.info("usuarioAministradorPorId: {}", idAdministrador);
		
		Optional<UsuarioAdministradorEntity>  usuarioAdministradorEntity = administradorRepository.findById(idAdministrador);
		
		if(usuarioAdministradorEntity.isPresent()) {
			
			return new ResponseDTO(usuarioAdminMapper.entityToDto(usuarioAdministradorEntity.get()), true, OK , HttpStatus.OK);
		}else {
			
			return new ResponseDTO(null, false, ERROR_GENERICO,HttpStatus.OK);
		}
		
	}

	/**
	* Método que retorna listado de DTOs con todos los usuarios administradores
	* @author cvlopez 
	* @version 0.1, 2021/07/01
	*/	
	@Override
	public ResponseDTO consultarTodos() {
		
		logger.info("consultarTodos()");
		
		List<UsuarioAdministradorEntity> listUsuarioAdministrador = administradorRepository.findAll();
		
		logger.info("consultarTodas() {}", listUsuarioAdministrador);
		
		return new ResponseDTO(usuarioAdminMapper.entitysToDtos(listUsuarioAdministrador), true, OK, HttpStatus.OK);
	}

	/**
	* Método que crea un nuevo usuario administrador
	* @author nbarreto 
	* @version 0.1, 2021/07/01
	*/
	@Override
	public ResponseDTO crearUsuario(UsuarioAdministradorDTO userAdmin) {

		if(!consultarUsuarioAdminEmailDTO(userAdmin.getEmail()).isEmpty()) {
			return new ResponseDTO(null, false, ERROR_GENERICO, HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			try {
				UsuarioAdministradorEntity usuarioAdministardor = administradorRepository.save(usuarioAdminMapper.dtoToEntity(userAdmin));
				logger.info("crear usuario: {}", usuarioAdministardor);
				return new ResponseDTO(usuarioAdminMapper.entityToDto(usuarioAdministardor), true, OK, HttpStatus.OK);
			}
			catch(Exception e) {
				logger.error("No se ha podido crear el administrador");
				return new ResponseDTO(null, false, ERROR_GENERICO, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}


	}

	/**
	* Método que edita un usuario administrador
	* @author nbarreto 
	* @version 0.1, 2021/07/01
	*/
	@Override
	public ResponseDTO editarUsuario(UsuarioAdministradorDTO userAdmin) {
		try {
		UsuarioAdministradorEntity usuarioAdministardor = administradorRepository.save(usuarioAdminMapper.dtoToEntity(userAdmin));
		logger.info("editar administrador: {}", usuarioAdministardor);
		return new ResponseDTO(usuarioAdminMapper.entityToDto(usuarioAdministardor), true, OK, HttpStatus.OK);
		}
		catch(Exception e) {
			logger.error("No se ha podido cambiar el usuario administrador");
			return new ResponseDTO(null, true, ERROR_GENERICO, HttpStatus.OK);
		}
	}

	/**
	* Método que elimina un usuario administrador según su id
	* @author nbarreto 
	* @version 0.1, 2021/07/01
	*/
	@Override
	public ResponseDTO eliminarUsuario(Integer idAdministrador) {
		try {
			administradorRepository.deleteById(idAdministrador);
			logger.info("eliminado usuario con id: {}",idAdministrador);
			return new ResponseDTO(null, true, OK, HttpStatus.OK);
		}
		catch (Exception e) {
			logger.error("No se ha podido eliminar el usuario con id {}",idAdministrador);
			return new ResponseDTO(null, false, ERROR_GENERICO, HttpStatus.OK);
		}
	}

	/**
	* Método que busca un usuario administrador por email 
	* @author cvlopez 
	* @version 0.1, 2021/07/01
	*/
	@Override
	public ResponseDTO usuarioAdministradorPorEmail(String email) {		
		
		return new ResponseDTO(consultarUsuarioAdminEmailDTO(email), true, OK, HttpStatus.OK);
		
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

	@Override
	public List<UsuarioAdministradorDTO> consultarUsuarioAdminEmailDTO(String email) {
		
		return usuarioAdminMapper.entitysToDtos(administradorRepository.queryUsuarioAdminPorEmail(email));
	}

}
