package com.asesoftware.reservas.api.reservas.service.imp;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.asesoftware.reservas.api.reservas.controller.SalaController;
import com.asesoftware.reservas.api.reservas.dto.ResponseDTO;
import com.asesoftware.reservas.api.reservas.entity.SalaEntity;
import com.asesoftware.reservas.api.reservas.mapper.ISalaMapper;
import com.asesoftware.reservas.api.reservas.repository.ISalaRepository;
import com.asesoftware.reservas.api.reservas.service.ISalaService;

@Service
public class SalaService implements ISalaService{
	
	private static final Logger logger = LoggerFactory.getLogger(SalaController.class);
	
	@Autowired
	private ISalaMapper salaMapper;
	
	@Autowired
	private ISalaRepository salaRepository;
	
	@Override
	public ResponseDTO listarTodoSalas() {
		try {
			logger.info("listarTodoSalas");
			List<SalaEntity> salaEntity = salaRepository.findAll();
			logger.info("listarTodoSalas: {}",salaEntity);
			return new ResponseDTO(salaMapper.entitysToDtos(salaEntity),true,"consulta completada",HttpStatus.OK);
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
			
	}

	@Override
	public ResponseDTO obtenerSalaPorId(Integer id) {
		logger.info("obtenerSalaPorId: {}",id);
		
		Optional<SalaEntity> salaEntity = salaRepository.findById(id);
		
		if (salaEntity.isPresent()) {
			return new ResponseDTO(salaMapper.entityToDto(salaEntity.get()),true,"sala encontrada",HttpStatus.OK);
		} else {
			return new ResponseDTO(null,false,"sala no encontrada",HttpStatus.OK);
		}
	}

	
	
}
