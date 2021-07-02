package com.asesoftware.reservas.api.reservas.service.imp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.asesoftware.reservas.api.reservas.dto.DominioDTO;
import com.asesoftware.reservas.api.reservas.dto.ResponseDTO;
import com.asesoftware.reservas.api.reservas.entity.DominioEntity;
import com.asesoftware.reservas.api.reservas.mapper.IDominioMapper;
import com.asesoftware.reservas.api.reservas.repository.IDominioRepository;
import com.asesoftware.reservas.api.reservas.service.IDominioService;


@Service
public class DominioService implements IDominioService {
	
	private static final Logger logger = LoggerFactory.getLogger(DominioService.class);
	
	
	@Autowired
	private IDominioRepository dominioRepository;
	
	@Autowired
	private IDominioMapper mapperDominio;
	
	
	
	
	@Override
	public ResponseDTO createDominio(DominioDTO dominioDTO) {
		
		try {
			DominioEntity dominioEntity = mapperDominio.dtoToEntity(dominioDTO);
			
			dominioRepository.save(dominioEntity);
		
			return new ResponseDTO(mapperDominio.entityToDto(dominioEntity),true,"ok",HttpStatus.OK);
		}catch(Exception e){
			return new ResponseDTO(null, false, "No se puede crear el dominio", HttpStatus.OK);
		}
		
		
		
	}

	@Override
	public ResponseDTO readDominio() {
		
		return new ResponseDTO(mapperDominio.entitysToDtos(dominioRepository.findAll()),true,"ok",HttpStatus.OK);
	}

	@Override
	public ResponseDTO updateDominio(DominioDTO dominioDTO) {
		
		logger.info("updateDominio {} ", dominioDTO);
		
		dominioRepository.queryDominioActualizar(dominioDTO.getValorDomino(),dominioDTO.getCodigoDominio(),dominioDTO.getDescripcion());
				
		return new ResponseDTO(null,true,"ok",HttpStatus.OK);
	}

	@Override
	public ResponseDTO deleteDominio(String dominioPK) {
		
		logger.info("ingerso al metodo deleteDominio");
		
		return null;
	}
	
}
