package com.asesoftware.reservas.api.reservas.service.imp;


import java.util.List;
import java.util.Optional;



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
	private ISalaMapper salaMapper;

	@Override
	public ResponseDTO listarTodosSalas() {
		try {
			logger.info("listarTodoSalas");
			List<SalaEntity> salaEntity = salaRepository.findAll();
			logger.info("listarTodoSalas: {}",salaEntity);
			return new ResponseDTO(salaMapper.entitysToDtos(salaEntity),true,"consulta completada",HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseDTO(null,false,"consulta no realizada", HttpStatus.OK);
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

	@Override
	public ResponseDTO crearSala(SalaDTO salaDTO) {
		try {
			SalaEntity salaEntity = salaMapper.dtoToEntity(salaDTO);

			salaRepository.save(salaEntity);

			return new ResponseDTO(salaMapper.entityToDto(salaEntity), true, "ok", HttpStatus.OK); 
		}catch (Exception e) {
			return new ResponseDTO(null, false, "No se puede crear la sala", HttpStatus.INTERNAL_SERVER_ERROR); 
		}
	}
	

	@Override
	public ResponseDTO actualizarSala(SalaDTO salaDTO) {
		
		logger.info("actualizarSala: {}", salaDTO);
		
		try {
			
			SalaEntity salaEntity = salaMapper.dtoToEntity(salaDTO);
			
			salaRepository.save(salaEntity);
			
			return new ResponseDTO(salaMapper.entityToDto(salaEntity), true, "Sala actualizada", HttpStatus.OK);
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
			return new ResponseDTO(null, false, "Sala no se pudo actualizar", HttpStatus.INTERNAL_SERVER_ERROR);
			
		}

	}

	@Override
	public ResponseDTO eliminarSala(Integer idSala) {
		logger.info("eliminarSala: {} ", idSala);
		
		try {
			
			salaRepository.deleteById(idSala);
			
			logger.info("La sala {} se elimino", idSala);
			
			return new ResponseDTO(null,true,"Sala Eliminada", HttpStatus.OK);
			
		}catch(Exception e){
			
			logger.info("Error {}", e.getMessage());
			
			return new ResponseDTO(null,false,"Sala no se pudo eliminar", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
