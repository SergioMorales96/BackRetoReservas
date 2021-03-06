package com.asesoftware.reservas.api.reservas.service.imp;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.asesoftware.reservas.api.reservas.dto.EmpresaDTO;
import com.asesoftware.reservas.api.reservas.dto.ResponseDTO;
import com.asesoftware.reservas.api.reservas.entity.EmpresaEntity;
import com.asesoftware.reservas.api.reservas.mapper.IEmpresaMapper;
import com.asesoftware.reservas.api.reservas.repository.IEmpresaRepository;
import com.asesoftware.reservas.api.reservas.service.IEmpresaService;
import static com.asesoftware.reservas.api.reservas.utils.Constantes.ERROR_GENERICO;
import static com.asesoftware.reservas.api.reservas.utils.Constantes.OK;


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

			return new ResponseDTO(empresaMapper.entityToDto(empresaEntity.get()), true, OK, HttpStatus.OK);
		}else {

			return new ResponseDTO(null, false, ERROR_GENERICO, HttpStatus.OK);
		}

	}

	@Override
	public ResponseDTO consultarTodas() {

		logger.info("consultarTodas()");

		List<EmpresaEntity> lisEmpresa = empresaRepositorio.findAll();

		logger.info("consultarTodas() {}",lisEmpresa);

		return new ResponseDTO(empresaMapper.entitysToDtos(lisEmpresa), true, OK, HttpStatus.OK);
	}

	@Override
	public ResponseDTO actualizarEmpresa(EmpresaDTO empresaDTO) {

		logger.info("actualizarEmpresa {}",empresaDTO);

		try {

			empresaRepositorio.save(empresaMapper.dtoToEntity(empresaDTO));
			return new ResponseDTO(empresaDTO, true, OK, HttpStatus.OK);

		}catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseDTO(null, false, ERROR_GENERICO, HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}

	@Override
	public ResponseDTO crearEmpresa(EmpresaDTO empresaDTO) {

		logger.info("crearEmpresa {}",empresaDTO);

		try {

			empresaRepositorio.save(empresaMapper.dtoToEntity(empresaDTO));
			empresaRepositorio.flush();

			return new ResponseDTO(empresaDTO, true, OK, HttpStatus.OK);

		}catch (Exception e) {	

			logger.error(e.getMessage());
			return new ResponseDTO(null, false, ERROR_GENERICO, HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

	@Override
	public ResponseDTO eliminarEmpresa(String nit) {
		
		logger.info("eliminarEmpresa {}",nit);
		try {

			empresaRepositorio.deleteById(nit);	
			return new ResponseDTO(null, true, OK, HttpStatus.OK);
			
		}catch (Exception e) {	

			logger.error(e.getMessage());
			return new ResponseDTO(null, false, ERROR_GENERICO, HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

}
