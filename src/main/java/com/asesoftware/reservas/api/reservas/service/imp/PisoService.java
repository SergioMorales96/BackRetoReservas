package com.asesoftware.reservas.api.reservas.service.imp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.asesoftware.reservas.api.reservas.dto.PisoDTO;
import com.asesoftware.reservas.api.reservas.dto.ResponseDTO;
import com.asesoftware.reservas.api.reservas.mapper.IPisoMapper;
import com.asesoftware.reservas.api.reservas.repository.IPisoRepository;
import com.asesoftware.reservas.api.reservas.service.IPisoService;

@Service
public class PisoService implements IPisoService {

	@Autowired
	private IPisoRepository pisoRepository;
	
	@Autowired
	private IPisoMapper pisoMapper;
	
	@Override
	public ResponseDTO pisoPorIdSucursal(Integer idSucursal) {
		
		List<PisoDTO> listPisoSucursal = pisoMapper.entitysToDtos(pisoRepository.queryPisoPorSucursal(idSucursal));

		return new ResponseDTO(listPisoSucursal, true, "ok", HttpStatus.OK);
	}

}
