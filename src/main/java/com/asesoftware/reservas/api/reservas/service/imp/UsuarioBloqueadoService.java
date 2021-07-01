package com.asesoftware.reservas.api.reservas.service.imp;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


import com.asesoftware.reservas.api.reservas.dto.ResponseDTO;
import com.asesoftware.reservas.api.reservas.dto.UsuarioBloqueadoDTO;
import com.asesoftware.reservas.api.reservas.entity.UsuarioBloqueadoEntity;
import com.asesoftware.reservas.api.reservas.mapper.IUsuarioBloqueadoMapper;
import com.asesoftware.reservas.api.reservas.repository.IUsuarioBloqueadoRepository;
import com.asesoftware.reservas.api.reservas.service.IUsuarioBloqueadoService;


@Service
public class UsuarioBloqueadoService implements IUsuarioBloqueadoService{
	
	private static final Logger logger = LoggerFactory.getLogger(UsuarioBloqueadoService.class);
	
	
	@Autowired
	private IUsuarioBloqueadoRepository usuarioBloqueadoRepository;
	
	
	@Autowired
	private IUsuarioBloqueadoMapper usuarioBloqueadoMapper;
	
	@Override
	public ResponseDTO consultarTodosLosUsuariosBloqueados() {
		
		List<UsuarioBloqueadoEntity> answ = this.usuarioBloqueadoRepository.findAll();
		logger.info("consultarTodosLosUsuariosBloqueados()");
		if(!answ.isEmpty()) {
			return new ResponseDTO(this.usuarioBloqueadoMapper.entitysToDtos(answ), true, "Ok", HttpStatus.OK);
		}else {
			return new ResponseDTO(null, false, "No Ok", HttpStatus.OK);
		}
		
		
		
	}

	@Override
	public ResponseDTO consultarUsuarioBloqueadoPorId(String correo) {
		
		logger.info("consultarUsuarioBloqueadoPorId()");
		List<UsuarioBloqueadoEntity> answ = this.usuarioBloqueadoRepository.findByEmail(correo);
		
		if(!answ.isEmpty()) {
			return new ResponseDTO(this.usuarioBloqueadoMapper.entitysToDtos(answ), true, "Ok", HttpStatus.OK);
		}else {
			return new ResponseDTO(null, false, "No Ok", HttpStatus.OK);
		}
	}
	
	
	@Override
	public ResponseDTO crearUsuarioBloqueado(UsuarioBloqueadoDTO dto) {
		logger.info("crearUsuarioBloqueado()");
		try {
			UsuarioBloqueadoEntity answ = this.usuarioBloqueadoRepository.save(this.usuarioBloqueadoMapper.dtoToEntity(dto));
			logger.info("Usuario Creado");
			return new ResponseDTO(this.usuarioBloqueadoMapper.entityToDto(answ), true, "Ok", HttpStatus.OK);
		} catch (Exception e) {
			logger.info("Usuario no creado");
			return new ResponseDTO(null, false, "Usuario no creado", HttpStatus.OK);
		}
	}

	@Override
	public ResponseDTO actualizarUsuarioBloqueado(UsuarioBloqueadoDTO usuarioBloqueadoDTO) {
		
		logger.info("actualizarUsuarioBloqueado");
		
		UsuarioBloqueadoEntity usuarioBloqueadoEntity = usuarioBloqueadoMapper.dtoToEntity(usuarioBloqueadoDTO);
		
		usuarioBloqueadoRepository.save(usuarioBloqueadoEntity);
		
		logger.info("usuario bloqueado actualizado");
		
		return new ResponseDTO(usuarioBloqueadoMapper.entityToDto(usuarioBloqueadoEntity), true, "usuario bloqueado actualizado correctamente", HttpStatus.OK);
	}

	@Override
	public ResponseDTO eliminarUsuarioBloqueado(Integer id) {
		logger.info("eliminarUsuarioBloqueado");
		 try {
			 usuarioBloqueadoRepository.deleteById(id);
			 return new ResponseDTO(null, true, "usuario bloqueado eliminado", HttpStatus.OK);
		 }catch(Exception e){
			 logger.error("Error {}",e.getMessage());
			 return new ResponseDTO(null, false, "usuario bloqueado no existe", HttpStatus.OK);
		 }
	}

	

}
