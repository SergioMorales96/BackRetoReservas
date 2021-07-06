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
	
	
	
	/**
	* Metodo encargado de consultar todos los dominios
	* @author abarrios
	* @version 0.1, 2021/07/02
	*/
	
	@Override
	public ResponseDTO readDominio() {
		
		return new ResponseDTO(mapperDominio.entitysToDtos(dominioRepository.findAll()),true,"ok",HttpStatus.OK);
	}
	
	/**
	* Metodo encargado de crear un dominios
	* @author abarrios
	* @version 0.1, 2021/07/02
	*/
	
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

	/**
	* Metodo encargado de Actualizar un dominios
	* @author smanrique
	* @version 0.1, 2021/07/02
	*/

	@Override
	public ResponseDTO updateDominio(DominioDTO dominioDTO) {
		
		logger.info("updateDominio {} ", dominioDTO);
		
		
		try {
			dominioRepository.queryDominioUpdate(dominioDTO.getValorDominio(),dominioDTO.getCodigoDominio(),dominioDTO.getDescripcion());
			
			return new ResponseDTO(null,true,"ok",HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseDTO(null,false,"El dominio no se actualizar el dominio",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

	/**
	* Metodo encargado de Eliminar un dominios
	* @author smanrique
	* @version 0.1, 2021/07/02
	*/
	
	@Override
	public ResponseDTO deleteDominio(DominioDTO dominioDTO) {
		
		logger.info("ingerso al metodo deleteDominio");
		
		try {
			dominioRepository.queryDominioDelete(dominioDTO.getValorDominio(),dominioDTO.getCodigoDominio(), dominioDTO.getDescripcion());
			
			return new ResponseDTO(null,true,"El dominio se elimino correctamente",HttpStatus.OK);
		}catch(Exception e) {
			logger.error("Error {}",e.getMessage());
			return new ResponseDTO(null,false,"El dominio no se puede eliminar",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		

		
		
	}
	
}
