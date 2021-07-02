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
import static com.asesoftware.reservas.api.reservas.utils.Constantes.ERROR_GENERICO;
import static com.asesoftware.reservas.api.reservas.utils.Constantes.OK;

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
			return new ResponseDTO(salaMapper.entitysToDtos(salaEntity),true,OK,HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseDTO(null,false,ERROR_GENERICO, HttpStatus.OK);
		}
	}

	@Override
	public ResponseDTO obtenerSalaPorId(Integer id) {
		logger.info("obtenerSalaPorId: {}",id);
		
		Optional<SalaEntity> salaEntity = salaRepository.findById(id);
		
		if (salaEntity.isPresent()) {
			return new ResponseDTO(salaMapper.entityToDto(salaEntity.get()),true,OK,HttpStatus.OK);
		} else {
			return new ResponseDTO(null,false,ERROR_GENERICO,HttpStatus.OK);
		}
	}

	@Override
	public ResponseDTO crearSala(SalaDTO salaDTO) {
		logger.info("crearSala: {}", salaDTO);
		try {
			SalaEntity salaEntity = salaMapper.dtoToEntity(salaDTO);

			salaRepository.save(salaEntity);

			return new ResponseDTO(salaMapper.entityToDto(salaEntity), true, OK, HttpStatus.OK); 
		}catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseDTO(null, false,ERROR_GENERICO, HttpStatus.INTERNAL_SERVER_ERROR); 
		}
	}
	
	/**
	* Metodo para editar una sala
	* @author fpena
	* @version 0.1, 2021/07/02
	*/
	@Override
	public ResponseDTO actualizarSala(SalaDTO salaDTO) {
		
		logger.info("actualizarSala: {}", salaDTO);
		
		try {
			
			SalaEntity salaEntity = salaMapper.dtoToEntity(salaDTO);
			
			salaRepository.save(salaEntity);
			
			return new ResponseDTO(salaMapper.entityToDto(salaEntity), true, OK, HttpStatus.OK);
			
		}catch(Exception e) {
			
			logger.error(e.getMessage());
			
			return new ResponseDTO(null, false, ERROR_GENERICO, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}

	}

	
	/**
	* Metodo para eliminar una sala
	* @author fpena
	* @version 0.1, 2021/07/02
	*/
	@Override
	public ResponseDTO eliminarSala(Integer idSala) {
		logger.info("eliminarSala: {} ", idSala);
		
		try {
			
			salaRepository.deleteById(idSala);
			
			logger.info("La sala {} se elimino", idSala);
			
			return new ResponseDTO(null,true,OK, HttpStatus.OK);
			
		}catch(Exception e){
			
			logger.error(e.getMessage());
			
			return new ResponseDTO(null,false,ERROR_GENERICO, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
