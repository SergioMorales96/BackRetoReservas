package com.asesoftware.reservas.api.reservas.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.asesoftware.reservas.api.reservas.dto.PisoDTO;
import com.asesoftware.reservas.api.reservas.dto.ResponseDTO;
import com.asesoftware.reservas.api.reservas.entity.PisoEntity;
import com.asesoftware.reservas.api.reservas.mapper.IPisoMapper;
import com.asesoftware.reservas.api.reservas.repository.IPisoRepository;
import com.asesoftware.reservas.api.reservas.service.IPisoService;

@Service
public class PisoService implements IPisoService{
	
	@Autowired
	private IPisoRepository pisoRespository;
	
	@Autowired
	private IPisoMapper pisoMapper;

	@Override
	public ResponseDTO consultarTodos() {
		List<PisoEntity> lisPiso = pisoRespository.findAll();
		return new ResponseDTO(pisoMapper.entitysToDtos(lisPiso),true,"OK",HttpStatus.OK);
	}

	@Override
	public PisoDTO consultarpisoPorId(Integer idPiso) {
		return null;
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
			return new ResponseDTO(pisoMapper.entityToDto(pisoEntity), true,"OK",HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseDTO(null,false,"No se puede crear piso",HttpStatus.OK);
		}
	}

	@Override
	public ResponseDTO actualizarPiso(PisoDTO pisoDTO) {
		return null;
	}

	@Override
	public ResponseDTO eliminarPiso(Integer idPiso) {
		return null;
	}


}
