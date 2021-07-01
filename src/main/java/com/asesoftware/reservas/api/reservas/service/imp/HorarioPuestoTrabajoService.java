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
				return new ResponseDTO(null, false, "no contiene datos", HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			// Se expone la informacion en caso de no poder realizar la consulta
			logger.info("consultarHorarioPorId: {}. error de consulta. {}", idHorario, e.getMessage());
			return new ResponseDTO(null, false, "error de consulta", HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * Método consultan todos los horarios de la tabla y retorna todos los elementos
	 * de la tabla através del mapper.
	 * 
	 * @author jlucero
	 * @param
	 * @return ResponseDTO
	 */
	@Override
	public ResponseDTO consultarTodos() {
		// Se crea el Logger que indica que entró al método consultarTodos() y se
		logger.info("consultarTodos()");
		List<HorarioPuestoTrabajoEntity> listHorarioPuestoTrabajo = horarioPuestoTrabajoRepositorio.findAll();
		logger.info("consultarTodos() {}", listHorarioPuestoTrabajo);
		return new ResponseDTO(horarioPuestoTrabajoMapper.entitysToDtos(listHorarioPuestoTrabajo), true, "Ok",
				HttpStatus.OK);
	}

	/**
	 * Método que Crea un nuevo registro para la tabla HorarioPuestoTrabajo a través
	 * del mapper.
	 * 
	 * @author jlucero
	 * @param HorarioPuestoTrabajoDTO
	 * @return ResponseDTO
	 */
	@Override
	public ResponseDTO crearHorario(HorarioPuestoTrabajoDTO horarioPuestoTrabajoDTO) {
		// Se genera el Logger que indica que ingresó al método
		// crearHorarioPuestoTrabajo y se
		logger.info("Ingresó al método crearHorarioPuestoTrabajo()");
		try {
			HorarioPuestoTrabajoEntity horarioPuestoTrabajoEntity = horarioPuestoTrabajoMapper
					.dtoToEntity(horarioPuestoTrabajoDTO);
			horarioPuestoTrabajoRepositorio.save(horarioPuestoTrabajoEntity);

			logger.info("Se creó el HorarioPuestoTrabajo {}", horarioPuestoTrabajoDTO.getIdHorario());
			return new ResponseDTO(horarioPuestoTrabajoMapper.entityToDto(horarioPuestoTrabajoEntity), true,
					"HorarioPuestoTrabajo Creado", HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Error {}", e.getMessage());
			return new ResponseDTO(null, false, "No se puede crear el HorarioPuestoTrabajo", HttpStatus.OK);
		}
	}

	/**
	 * Servicio que retorna un ResponseDTO con los datos del usuario actualizado
	 * 
	 * @author jrondon
	 * 
	 * @param dto: datos del usuario actualizados provenientes del controlador
	 * @return ResponseDTO: datos el usuario actualizado provenientes de la bd
	 */
	@Override
	public ResponseDTO actualizarHorarioPuestoTrabajo(HorarioPuestoTrabajoDTO dto) {
		try {
			logger.info("generando actualizacionHorarioPuestoTrabajo: {}", dto);
			return new ResponseDTO(
					horarioPuestoTrabajoMapper.entityToDto(
							horarioPuestoTrabajoRepositorio.save(horarioPuestoTrabajoMapper.dtoToEntity(dto))),
					true, "ok", HttpStatus.OK);
		} catch (Exception e) {
			logger.info("error actualizacionHorarioPuestoTrabajo: {}. {}", dto, e.getMessage());
			return new ResponseDTO(null, false, "error de actualizacion", HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * Método que elimina el HorarioPuestoTrabajoDTO a partir del id através del
	 * mapper.
	 * 
	 * @author jlucero
	 * @param id
	 * @return ResponseDTO
	 */
	@Override
	public ResponseDTO borrarHorarioPorId(Integer idHorario) {
		// Se genera el Logger que indica que ingresó al método consultarTodos() y se
		// Elimina registro específico para la tabla HorarioPuestoTrabajo
		logger.info("consultarTodos()");
		try {
			horarioPuestoTrabajoRepositorio.deleteById(idHorario);
			logger.info("El HorarioPuestoTrabajo {} se eliminó");
			return new ResponseDTO(null, true, "HorarioPuestoTrabajo Eliminado", HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Error {}", e.getMessage());
			return new ResponseDTO(null, false, "No se puede eliminar el HorarioPuestoTrabajo", HttpStatus.OK);
		}
	}
}
