package com.asesoftware.reservas.api.reservas.service.imp;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.asesoftware.reservas.api.reservas.controller.UsuarioBloqueadoController;
import com.asesoftware.reservas.api.reservas.dto.ResponseDTO;
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

}
