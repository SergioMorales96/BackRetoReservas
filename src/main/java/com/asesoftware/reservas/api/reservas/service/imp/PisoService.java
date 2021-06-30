package com.asesoftware.reservas.api.reservas.service.imp;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.asesoftware.reservas.api.reservas.controller.EmpresaController;
import com.asesoftware.reservas.api.reservas.dto.PisoDTO;
import com.asesoftware.reservas.api.reservas.dto.ResponseDTO;
import com.asesoftware.reservas.api.reservas.entity.PisoEntity;
import com.asesoftware.reservas.api.reservas.mapper.IPisoMapper;
import com.asesoftware.reservas.api.reservas.repository.IPisoRepository;
import com.asesoftware.reservas.api.reservas.service.IPisoService;

@Service
public class PisoService implements IPisoService{
	
	private static final Logger logger = LoggerFactory.getLogger(EmpresaController.class);
	
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
		return null;
	}

	@Override
	public ResponseDTO pisoPorNumeroPiso(Integer numeroPiso) {
		return null;
	}

	@Override
	public ResponseDTO crearPiso(PisoDTO pisoDTO) {
		try {
			PisoEntity pisoEntity = pisoMapper.dtoToEntity(pisoDTO);
			pisoRespository.save(pisoEntity);
			logger.info("crearPiso() {}",pisoDTO);
			return new ResponseDTO(pisoMapper.entityToDto(pisoEntity), true,"OK",HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseDTO(null,false,"No se puede crear piso",HttpStatus.OK);
		}
	}

	@Override
	public ResponseDTO actualizarPiso(PisoDTO pisoDTO) {
		return null;
	}

	@Override
	public ResponseDTO eliminarPiso(Integer idPiso) {
		try {
			logger.info("eliminarPiso {}", idPiso);
			pisoRespository.deleteById(idPiso);			
			return new ResponseDTO(null,true,"Piso eliminado",HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseDTO(null,false,"El piso no se puede eliminar",HttpStatus.OK);
		}
	}
}
