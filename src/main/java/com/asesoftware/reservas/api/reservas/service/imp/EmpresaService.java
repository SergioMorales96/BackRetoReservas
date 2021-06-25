package com.asesoftware.reservas.api.reservas.service.imp;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.asesoftware.reservas.api.reservas.dto.ResponseDTO;
import com.asesoftware.reservas.api.reservas.entity.EmpresaEntity;
import com.asesoftware.reservas.api.reservas.mapper.IEmpresaMapper;
import com.asesoftware.reservas.api.reservas.repository.IEmpresaRepository;
import com.asesoftware.reservas.api.reservas.service.IEmpresaService;

@Service
public class EmpresaService implements IEmpresaService{

	private static final Logger logger = LoggerFactory.getLogger(EmpresaService.class);
	
	@Autowired
	private IEmpresaRepository empresaRepositorio;
	
	@Autowired
	private IEmpresaMapper empresaMapper;
	
	@Override
	public ResponseDTO empresaPorId(String nit) {
		
		logger.info("empresaPorId: {}", nit);

		Optional <EmpresaEntity> empresaEntity = empresaRepositorio.findById(nit);
		
		if(empresaEntity.isPresent()) {
			return new ResponseDTO(empresaMapper.entityToDto(empresaEntity.get()), true, "OK", HttpStatus.OK);
		}else {
			return new ResponseDTO(null, false, "No hay resultados", HttpStatus.OK);
		}
		
	}

}
