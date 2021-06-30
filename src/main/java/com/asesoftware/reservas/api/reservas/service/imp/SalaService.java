package com.asesoftware.reservas.api.reservas.service.imp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.asesoftware.reservas.api.reservas.dto.ResponseDTO;
import com.asesoftware.reservas.api.reservas.dto.SalaDTO;
import com.asesoftware.reservas.api.reservas.entity.SalaEntity;
import com.asesoftware.reservas.api.reservas.mapper.ISalaMapper;
import com.asesoftware.reservas.api.reservas.repository.ISalaRepository;
import com.asesoftware.reservas.api.reservas.service.ISalaService;

@Service
public class SalaService implements ISalaService{

	private static final Logger logger = LoggerFactory.getLogger(SalaService.class);
	
	@Autowired
	private ISalaRepository salaRepository;
	
	@Autowired
	private ISalaMapper mapperSala;
	
	@Override
	public ResponseDTO eliminarSala(Integer idSala) {
		
		logger.info("eliminarSala: {} ", idSala);
		
		try {
			
			salaRepository.deleteById(idSala);
			
			logger.info("La sala {} se elimino", idSala);
			
			return new ResponseDTO(null,true,"Sala Eliminada", HttpStatus.OK);
			
		}catch(Exception e){
			
			logger.info("Error {}", e.getMessage());
			
			return new ResponseDTO(null,false,"Sala no se pudo eliminar", HttpStatus.OK);
		}
	}

	@Override
	public ResponseDTO actualizarSala(SalaDTO salaDTO) {
		
		logger.info("actualizarSala: {}", salaDTO);
		
		try {
			
			SalaEntity salaEntity = mapperSala.dtoToEntity(salaDTO);
			
			salaRepository.save(salaEntity);
			
			return new ResponseDTO(mapperSala.entityToDto(salaEntity), true, "Sala actualizada", HttpStatus.OK);
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
			return new ResponseDTO(null, false, "Sala no se pudo actualizar", HttpStatus.OK);
			
		}
	}

}
