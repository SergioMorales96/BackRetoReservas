package com.asesoftware.reservas.api.reservas.service.imp;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.asesoftware.reservas.api.reservas.dto.PisoDTO;
import com.asesoftware.reservas.api.reservas.dto.ResponseDTO;
import com.asesoftware.reservas.api.reservas.entity.PisoEntity;
import com.asesoftware.reservas.api.reservas.mapper.IPisoMapper;
import com.asesoftware.reservas.api.reservas.repository.IPisoRepository;
import com.asesoftware.reservas.api.reservas.service.IPisoService;
import static com.asesoftware.reservas.api.reservas.utils.Constantes.ERROR_GENERICO;
import static com.asesoftware.reservas.api.reservas.utils.Constantes.OK;;

@Service
public class PisoService implements IPisoService{
	
	private static final Logger logger = LoggerFactory.getLogger(PisoService.class);
	
	@Autowired
	private IPisoRepository pisoRespository;
	
	@Autowired
	private IPisoMapper pisoMapper;

	@Override
	public ResponseDTO consultarTodos() {
		logger.info("consultarTodos()");
		List<PisoEntity> lisPiso = pisoRespository.findAll();
		logger.info("consultarTodos() {}", lisPiso);
		return new ResponseDTO(pisoMapper.entitysToDtos(lisPiso),true,"OK",HttpStatus.OK);
	}

	@Override
	public PisoDTO consultarpisoPorId(Integer idPiso) {
		Optional<PisoEntity> optional = pisoRespository.findById(idPiso);
		if(optional.isPresent()) {
			logger.info("consultarPisoPorId() {}",idPiso);
			return pisoMapper.entityToDto(optional.get());
		} else {
		return null;
	}
}

	@Override
	public ResponseDTO pisoPorId(Integer idPiso) {
		Optional<PisoEntity> pisoEntity = pisoRespository.findById(idPiso);
		if(pisoEntity.isPresent()) {
			logger.info("se encontro el piso por id");
			return  new ResponseDTO(pisoEntity, true,OK, HttpStatus.OK);
		}else{
			logger.info("No se encontro el piso por id");
			return  new ResponseDTO(null, false, ERROR_GENERICO, HttpStatus.OK);
		}
	}

	@Override
	public ResponseDTO pisoPorNumeroPiso(Integer numeroPiso) {
		List<PisoEntity> pisoEntity = pisoRespository.queryPorPiso(numeroPiso);
		if(pisoEntity.isEmpty()) {
			logger.error("El piso no existe");
			return new ResponseDTO(null,false,OK, HttpStatus.OK);
			
		}else {
			logger.info("se encontro el piso");
			return new ResponseDTO(pisoEntity, true,ERROR_GENERICO, HttpStatus.OK);
			
		}
		
		
	}

	@Override
	public ResponseDTO crearPiso(PisoDTO pisoDTO) {
		try {
			PisoEntity pisoEntity = pisoMapper.dtoToEntity(pisoDTO);
			pisoRespository.save(pisoEntity);
			logger.info("crearPiso() {}",pisoDTO);
			return new ResponseDTO(pisoMapper.entityToDto(pisoEntity), true,OK,HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseDTO(null,false,ERROR_GENERICO,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
    
	@Override
	public ResponseDTO actualizarPiso(PisoDTO pisoDTO) {
		try {
			logger.info("actualizando piso {}",pisoDTO);
			PisoEntity pisoEntity = pisoMapper.dtoToEntity(pisoDTO);
			pisoRespository.save(pisoEntity);
			return new ResponseDTO(pisoMapper.entityToDto(pisoEntity), true,OK, HttpStatus.OK);
		}catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseDTO(null,false,ERROR_GENERICO,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
	}
	/**
	* Frase corta descriptiva
	* @author Nombre Apellido 
	* @version 0.1, 2004/05/30
	*/
	@Override
	public ResponseDTO eliminarPiso(Integer idPiso) {
		try {
			logger.info("eliminarPiso {}", idPiso);
			pisoRespository.deleteById(idPiso);			
			return new ResponseDTO(null,true,OK,HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseDTO(null,false,ERROR_GENERICO,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
