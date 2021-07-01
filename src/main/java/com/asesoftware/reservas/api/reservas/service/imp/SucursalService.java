package com.asesoftware.reservas.api.reservas.service.imp;

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

	@Autowired
	private ISucursalRepository sucursalRepository;

	@Autowired
	private ISucursalMapper mapperSucursal;


	@Override
	public ResponseDTO createSucursal(SucursalDTO sucursalDTO) {
		try {
			SucursalEntity sucursalEntity = mapperSucursal.dtoToEntity(sucursalDTO);
			sucursalRepository.save(sucursalEntity);
			return new ResponseDTO(mapperSucursal.entityToDto(sucursalEntity), true, "ok", HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseDTO(null, false, "No se puede crear la sucursal", HttpStatus.OK);
		}

	}

	@Override
	public ResponseDTO updateSucursal(SucursalDTO sucursalDTO) {
		SucursalEntity sucursalEntity = mapperSucursal.dtoToEntity(sucursalDTO);
		sucursalRepository.save(sucursalEntity);
		return new ResponseDTO(mapperSucursal.entityToDto(sucursalEntity), true, "ok", HttpStatus.OK);
	}


}
