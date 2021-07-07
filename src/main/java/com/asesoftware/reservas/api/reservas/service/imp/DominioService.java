package com.asesoftware.reservas.api.reservas.service.imp;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.asesoftware.reservas.api.reservas.dto.DominioDTO;
import com.asesoftware.reservas.api.reservas.dto.ResponseDTO;
import com.asesoftware.reservas.api.reservas.entity.DominioEntity;
import com.asesoftware.reservas.api.reservas.entity.DominioPK;
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
		
		
		
		logger.info("createDominio {} ", dominioDTO);
		
		try {
			DominioEntity dominioEntity = mapperDominio.dtoToEntity(dominioDTO);
			
			dominioRepository.save(dominioEntity);
		
			return new ResponseDTO(mapperDominio.entityToDto(dominioEntity),true,"ok",HttpStatus.OK);
		}catch(Exception e){
			return new ResponseDTO(null, false, "No se puede crear el dominio", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		
	}

	@Override
	public ResponseDTO readDominio() {
		
		return new ResponseDTO(mapperDominio.entitysToDtos(dominioRepository.findAll()),true,"ok",HttpStatus.OK);
	}

	@Override
	public ResponseDTO updateDominio(DominioDTO dominioDTO) {
		
		logger.info("updateDominio {} ", dominioDTO);
				
		if(dominioRepository.findByDominioPKCodigoDominioAndDescripcion(dominioDTO.getCodigoDominio(), dominioDTO.getDescripcion()) != null) {
			
			dominioRepository.queryDominioUpdate(dominioDTO.getValorDominio(),dominioDTO.getCodigoDominio(),dominioDTO.getDescripcion());
			
			return new ResponseDTO(null,true,"ok",HttpStatus.OK);
		}else {
			return new ResponseDTO(null,false,"El dominio no se actualizar el dominio, porque no existe",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	} 

	@Override
	public ResponseDTO deleteDominio(DominioDTO dominioDTO) {
		
		logger.info("ingerso al metodo deleteDominio");
		
		if(dominioRepository.findByDominioPKCodigoDominioAndDescripcion(dominioDTO.getCodigoDominio(), dominioDTO.getDescripcion()) != null) {
			
			dominioRepository.queryDominioDelete(dominioDTO.getValorDominio(),dominioDTO.getCodigoDominio(), dominioDTO.getDescripcion());
			
			return new ResponseDTO(null,true,"El dominio se elimino correctamente",HttpStatus.OK);
		}else {
			
			return new ResponseDTO(null,false,"No se elimino ningun dominio porque no existe",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		

		
		
	}

	@Override
	public ResponseDTO readDominioByCodDomi(String codigoDominio) {
		
		
		List<DominioEntity> dominioEntity = dominioRepository.findByDominioPKCodigoDominio(codigoDominio);
		
		if (dominioEntity != null) {
			return new ResponseDTO(mapperDominio.entitysToDtos(dominioEntity),true,"Los dominios son estos",HttpStatus.OK);
		}else {
				
		
		return new ResponseDTO(mapperDominio.entitysToDtos(dominioEntity),false,"No se encontro el dominio",HttpStatus.INTERNAL_SERVER_ERROR);
	}}

	
}
