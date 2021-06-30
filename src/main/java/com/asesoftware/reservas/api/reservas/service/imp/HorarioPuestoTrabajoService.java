package com.asesoftware.reservas.api.reservas.service.imp;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.asesoftware.reservas.api.reservas.dto.HorarioPuestoTrabajoDTO;
import com.asesoftware.reservas.api.reservas.dto.ResponseDTO;
import com.asesoftware.reservas.api.reservas.entity.HorarioPuestoTrabajoEntity;
import com.asesoftware.reservas.api.reservas.mapper.IHorarioPuestoTrabajoMapper;
import com.asesoftware.reservas.api.reservas.repository.IHorarioPuestoTrabajoRepository;
import com.asesoftware.reservas.api.reservas.service.IHorarioPuestoTrabajoService;

@Service
public class HorarioPuestoTrabajoService implements IHorarioPuestoTrabajoService {
	private static final Logger logger = LoggerFactory.getLogger(HorarioPuestoTrabajoService.class);
	@Autowired
	private IHorarioPuestoTrabajoRepository horarioPuestoTrabajoRepositorio;

	@Autowired
	private IHorarioPuestoTrabajoMapper horarioPuestoTrabajoMapper;

	/**
	 * Servicio que retorna un ResponseDTO con los datos del usuario
	 * correspondientes al id en el parametro
	 * 
	 * @author jrondon
	 * 
	 * @param idHorario: identificador del horario a consultar
	 * @return ResponseDTO: datos correspondientes al identificado
	 */
	@Override
	public ResponseDTO consultarHorarioPorId(Integer idHorario) {
		try {
			// Se realiza la consulta a la bd
			logger.info("consultarHorarioPorId: {}", idHorario);
			Optional<HorarioPuestoTrabajoEntity> opcional = horarioPuestoTrabajoRepositorio.findById(idHorario);
			// Se verifica que la consulta no sea nula
			if (opcional.isPresent()) {
				// Se exponen los datos de la consulta
				logger.info("consultarHorarioPorId: {}. contiene datos", idHorario);
				return new ResponseDTO(horarioPuestoTrabajoMapper.entityToDto(opcional.get()), true, "ok",
						HttpStatus.OK);
			} else {
				// Se expone la informacion en caso de ser nula la consulta
				logger.info("consultarHorarioPorId: {}. no contiene datos", idHorario);
				return new ResponseDTO(null, false, "fail", HttpStatus.OK);
			}
		} catch (Exception e) {
			// Se expone la informacion en caso de no poder realizar la consulta
			logger.info("consultarHorarioPorId: {}. error de consulta", idHorario);
			return new ResponseDTO(null, false, "fail", HttpStatus.OK);
		}
	}

	@Override
	public ResponseDTO consultarTodos() {
		logger.info("consultarTodos()");
		List<HorarioPuestoTrabajoEntity> listHorarioPuestoTrabajo = horarioPuestoTrabajoRepositorio.findAll();
		logger.info("consultarTodos() {}", listHorarioPuestoTrabajo);
		return new ResponseDTO(horarioPuestoTrabajoMapper.entitysToDtos(listHorarioPuestoTrabajo), true, "Ok",
				HttpStatus.OK);
	}

	@Override
	public ResponseDTO crearHorario() {
		return null;
	}

	@Override
	public ResponseDTO actualizarHorarioPuestoTrabajo(HorarioPuestoTrabajoDTO dto) {
		return null;
	}

	@Override
	public ResponseDTO borrarHorarioPorId(Integer idHorario) {
		return null;
	}
}
