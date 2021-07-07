package com.asesoftware.reservas.api.reservas.service.imp;

import java.util.List;

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
import static com.asesoftware.reservas.api.reservas.utils.Constantes.OK;
import static com.asesoftware.reservas.api.reservas.utils.Constantes.ERROR_GENERICO;

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
		
		return new ResponseDTO(mapperDominio.entitysToDtos(dominioRepository.findAll()),true,OK,HttpStatus.OK);
	}
	
	/**
	* Metodo encargado de crear un dominios
	* @author abarrios
	* @version 0.1, 2021/07/02
	*/
	
	@Override
	public ResponseDTO createDominio(DominioDTO dominioDTO) {
		
		
		try {	
			logger.info("createDominio {} ", dominioDTO);
			
			if(dominioRepository.findByDominioPKCodigoDominioAndDescripcion(dominioDTO.getCodigoDominio(), dominioDTO.getDescripcion()) == null) {
				DominioEntity dominioEntity = mapperDominio.dtoToEntity(dominioDTO);
				dominioRepository.save(dominioEntity);
				return new ResponseDTO(mapperDominio.entityToDto(dominioEntity),true,OK,HttpStatus.OK);
			}else {
				return new ResponseDTO(null, false, ERROR_GENERICO, HttpStatus.INTERNAL_SERVER_ERROR);
			}	
		}catch(Exception e) {
			return new ResponseDTO(null, false, ERROR_GENERICO, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	* Metodo encargado de Actualizar un dominios
	* @author smanrique
	* @version 0.1, 2021/07/02
	*/

	@Override
	public ResponseDTO updateDominio(DominioDTO dominioDTO) {
		try {	
			logger.info("updateDominio {} ", dominioDTO);
					
			if(dominioRepository.findByDominioPKCodigoDominioAndDescripcion(dominioDTO.getCodigoDominio(), dominioDTO.getDescripcion()) != null) {
				
				dominioRepository.queryDominioUpdate(dominioDTO.getValorDominio(),dominioDTO.getCodigoDominio(),dominioDTO.getDescripcion());
				
				return new ResponseDTO(null,true,OK,HttpStatus.OK);
			}else {
				return new ResponseDTO(null,false,ERROR_GENERICO,HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}catch( Exception e) {
			return new ResponseDTO(null,false,ERROR_GENERICO,HttpStatus.INTERNAL_SERVER_ERROR);
	}} 

	/**
	* Metodo encargado de Eliminar un dominios
	* @author smanrique
	* @version 0.1, 2021/07/02
	*/
	
	@Override
	public ResponseDTO deleteDominio(DominioDTO dominioDTO) {
		
		try {
			logger.info("ingerso al metodo deleteDominio");
		
			if(dominioRepository.findByDominioPKCodigoDominioAndDescripcion(dominioDTO.getCodigoDominio(), dominioDTO.getDescripcion()) != null) {
			
				dominioRepository.queryDominioDelete(dominioDTO.getValorDominio(),dominioDTO.getCodigoDominio(), dominioDTO.getDescripcion());
			
				return new ResponseDTO(null,true,OK,HttpStatus.OK);
			}else {
			
				return new ResponseDTO(null,false,ERROR_GENERICO,HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}catch(Exception e) {
			return new ResponseDTO(null,false,ERROR_GENERICO,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		/**
		* Metodo encargado de buscar dominios por CODIGO_DOMINIO
		* @author abarrios
		* @version 0.1, 2021/07/02
		*/
		
		
	}

	@Override
	public ResponseDTO readDominioByCodDomi(String codigoDominio) {
		
		try {
			
			
			List<DominioEntity> dominioEntity = dominioRepository.findByDominioPKCodigoDominio(codigoDominio);
			logger.info("consultar dominio por codigo de dominio {}",codigoDominio);
			if (dominioEntity != null) {
				return new ResponseDTO(mapperDominio.entitysToDtos(dominioEntity),true,OK,HttpStatus.OK);
			}else {
				return new ResponseDTO(null,false,ERROR_GENERICO,HttpStatus.INTERNAL_SERVER_ERROR);
		}}catch (Exception e) {
			return new ResponseDTO(null,false,ERROR_GENERICO,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		}}

	

