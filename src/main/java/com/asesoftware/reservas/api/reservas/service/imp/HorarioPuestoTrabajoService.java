package com.asesoftware.reservas.api.reservas.service.imp;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.asesoftware.reservas.api.reservas.entity.HorarioPuestoTrabajoEntity;
import com.asesoftware.reservas.api.reservas.dto.HorarioPuestoTrabajoDTO;
import com.asesoftware.reservas.api.reservas.dto.ResponseDTO;
import com.asesoftware.reservas.api.reservas.mapper.IHorarioPuestoTrabajoMapper;
import com.asesoftware.reservas.api.reservas.repository.IHorarioPuestoTrabajoRepository;
import com.asesoftware.reservas.api.reservas.service.IHorarioPuestoTrabajoService;
@Service
public class HorarioPuestoTrabajoService implements IHorarioPuestoTrabajoService{
	private static final Logger logger = LoggerFactory.getLogger(HorarioPuestoTrabajoService.class);
	@Autowired
	private IHorarioPuestoTrabajoRepository horarioPuestoTrabajoRepositorio;
	
	@Autowired
	private IHorarioPuestoTrabajoMapper horarioPuestoTrabajoMapper;
	
	@Override
	public ResponseDTO horarioPorId(String nit) {
		
		return null;
	}

	@Override
	public ResponseDTO consultarTodos() {
		logger.info("consultarTodos()");
		List<HorarioPuestoTrabajoEntity> listHorarioPuestoTrabajo = horarioPuestoTrabajoRepositorio.findAll();
		logger.info("consultarTodos() {}",listHorarioPuestoTrabajo);
		return new ResponseDTO(horarioPuestoTrabajoMapper.entitysToDtos(listHorarioPuestoTrabajo), true, "Ok", HttpStatus.OK);
	}

	@Override
	public ResponseDTO actualizarHorarioPuestoTrabajo(HorarioPuestoTrabajoDTO empresaDTO) {
		
		return null;
	}


	@Override
	public ResponseDTO borrarHorarioPorId(String idHorario) {

		return null;
	}
}
