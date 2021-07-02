package com.asesoftware.reservas.api.reservas.service.imp;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.asesoftware.reservas.api.reservas.dto.ResponseDTO;
import com.asesoftware.reservas.api.reservas.dto.SucursalDTO;
import com.asesoftware.reservas.api.reservas.entity.SucursalEntity;
import com.asesoftware.reservas.api.reservas.mapper.ISucursalMapper;
import com.asesoftware.reservas.api.reservas.repository.ISucursalRepository;
import com.asesoftware.reservas.api.reservas.service.ISucursalService;

@Service
public class SucursalService implements ISucursalService{
	
	private static final Logger logger = LoggerFactory.getLogger(SucursalService.class);


	@Autowired
	private ISucursalRepository sucursalRepository;

	@Autowired
	private ISucursalMapper mapperSucursal;
	
	//Listar todas las sucursales
	@Override
	public ResponseDTO getAll() {

		return new ResponseDTO( mapperSucursal.listEntityToDto( sucursalRepository.findAll()), true, "ok", HttpStatus.OK);
	}	

	// Listar Sucursal por ID
	
	@Override
	public ResponseDTO getSucursalById(Integer id) {
		
		Optional<SucursalEntity> optional = sucursalRepository.findById(id);

		if (optional.isPresent()) {
			logger.info("La sucursal {} fue encontrada",id);
			return new ResponseDTO(optional.get(), true, "ok", HttpStatus.OK);
		}else {
			logger.info("La sucursal {} no fue encontrada",id);
			return  new ResponseDTO(null, false, "Sucursal no encontrada", HttpStatus.OK);
		}
	}


	// Crear Sucursal

	@Override
	public ResponseDTO createSucursal(SucursalDTO sucursalDTO) {
		try {
			SucursalEntity sucursalEntity = mapperSucursal.dtoToEntity(sucursalDTO);
			sucursalRepository.save(sucursalEntity);
			logger.info("La sucursal {} se creo", sucursalDTO);
			return new ResponseDTO(mapperSucursal.entityToDto(sucursalEntity), true, "ok", HttpStatus.OK);
		}catch (Exception e) {
			logger.error("Error {}",e.getMessage());
			return new ResponseDTO(null, false, "No se puede crear la sucursal", HttpStatus.OK);
		}

	}

	// Editar Sucursal

	@Override
	public ResponseDTO updateSucursal(SucursalDTO sucursalDTO) {
		try {
			SucursalEntity sucursalEntity = mapperSucursal.dtoToEntity(sucursalDTO);
			sucursalRepository.save(sucursalEntity);
			logger.info("La sucursal {} se actualizo", sucursalDTO);
			return new ResponseDTO(mapperSucursal.entityToDto(sucursalEntity), true, "ok", HttpStatus.OK);
		}catch(Exception e) {
			logger.error("Error {}",e.getMessage());
			return new ResponseDTO(null, false, "No se puede editar la sucursal", HttpStatus.OK);
		}

	}
	
	
	// Eliminar Sucursal
	@Override
	public ResponseDTO deleteSucursal(Integer id) {

		logger.info("ingreso al metodo deleteSucursal");
		try {
			sucursalRepository.deleteById(id);
			logger.info("La sucursal {} se elimino",id);
			return  new ResponseDTO(null, true, "Sucursal eliminada", HttpStatus.OK); 
		}catch (Exception e) {
			logger.error("Error {}",e.getMessage());
			return  new ResponseDTO(null, false, "La sucursal no se puede eliminar", HttpStatus.OK); 
		}


	}
	
	
	


}
