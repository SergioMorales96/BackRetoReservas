package com.asesoftware.reservas.api.reservas.service.imp;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.asesoftware.reservas.api.reservas.dto.PuestoTrabajoDTO;
import com.asesoftware.reservas.api.reservas.dto.ResponseDTO;
import com.asesoftware.reservas.api.reservas.entity.PuestoTrabajoEntity;
import com.asesoftware.reservas.api.reservas.mapper.IPuestoTrabajoMapper;
import com.asesoftware.reservas.api.reservas.repository.IPuestoTrabajoRepository;
import com.asesoftware.reservas.api.reservas.service.IPuestoTrabajoService;

import static com.asesoftware.reservas.api.reservas.utils.Constantes.OK;
import static com.asesoftware.reservas.api.reservas.utils.Constantes.ERROR_GENERICO;;

@Service
public class PuestoTrabajoService implements IPuestoTrabajoService{

	@Autowired
	private IPuestoTrabajoRepository puestoTrabajoRepositorio;

	@Autowired
	private IPuestoTrabajoMapper puestoTrabajoMapper;

	private static final Logger logger = LoggerFactory.getLogger(PuestoTrabajoService.class);

	/**
	 * Metodo encargado de buscar todos los puestos de trabajo
	 * @author: kpinilla
	 * @version: 01/07/2021
	 */
	@Override
	public ResponseDTO consultarTodas() {

		try {
			logger.info("consultarTodas()");
			List<PuestoTrabajoEntity> lisPuestoTrabajo = puestoTrabajoRepositorio.findAll();
			logger.info("ConsultarTodosPuestos: {}",lisPuestoTrabajo );
			return new ResponseDTO(puestoTrabajoMapper.entitysToDtos(lisPuestoTrabajo ),true,OK,HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseDTO(null,false,ERROR_GENERICO, HttpStatus.OK);
		}
	}
	/**
	 * Metodo encargado de buscar puestos de trabajo por ID
	 * @author: kpinilla
	 * @version: 01/07/2021
	 */
	@Override
	public ResponseDTO puestoTrabajoPorId(Integer idPuestoTrabajo) {

		logger.info("ingreso al metodo puestoTrabajoPorId {} ",idPuestoTrabajo );
		Optional <PuestoTrabajoEntity> puestoTrabajoEntity = puestoTrabajoRepositorio.findById(idPuestoTrabajo);

		if(puestoTrabajoEntity.isPresent()) {
			return new ResponseDTO(puestoTrabajoMapper.entityToDto(puestoTrabajoEntity.get()), true, OK, HttpStatus.OK);
		}else {
			return new ResponseDTO(null, false, ERROR_GENERICO, HttpStatus.OK);
		}
	}
	/**
	 * Metodo encargado de crear puesto de trabajo
	 * @author: drlopez
	 * @version: 01/07/2021
	 */
	@Override
	public ResponseDTO crearPuestoTrabajo(PuestoTrabajoDTO puestoTrabajoDTO) {

		logger.info("ingreso al metodo crearPuestoTrabajo {} ",puestoTrabajoDTO );

		try {
			PuestoTrabajoEntity puestoTrabajoEntity = puestoTrabajoMapper.dtoToEntity(puestoTrabajoDTO);
			puestoTrabajoRepositorio.save(puestoTrabajoEntity);
			logger.info("se creo PuestoTrabajo {} ",puestoTrabajoDTO );

			return new ResponseDTO(puestoTrabajoMapper.entityToDto(puestoTrabajoEntity),true, OK, HttpStatus.OK);
		}catch (Exception e) {
			logger.error("Error crear {}",e.getMessage());
			return new ResponseDTO(null, false, ERROR_GENERICO, HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
	/**
	 * Metodo encargado de actualizar puesto de trabajo
	 * @author: drlopez
	 * @version: 01/07/2021
	 */
	@Override
	public ResponseDTO actualizarPuestoTrabajo(PuestoTrabajoDTO puestoTrabajoDTO) {

		logger.info("ingreso al metodo actualizarPuestoTrabajo  ");

		try {
			puestoTrabajoRepositorio.save(puestoTrabajoMapper.dtoToEntity(puestoTrabajoDTO));
			logger.info("se actualiza PuestoTrabajo {} ",puestoTrabajoDTO );
			return new ResponseDTO(puestoTrabajoDTO,true, OK, HttpStatus.OK);
		}catch (Exception e) {
			logger.error("Error {}",e.getMessage());
			return new ResponseDTO(null, false, ERROR_GENERICO, HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

	/**
	 * Metodo encargado de eliminar puesto de trabajo
	 * @author: kpinilla
	 * @version: 01/07/2021
	 */
	@Override
	public ResponseDTO borrarPuestoTrabajo(Integer idPuestoTrabajo) {

		logger.info("ingreso al metodo borrarPuestoTrabajo ");

		try {
			puestoTrabajoRepositorio.deleteById(idPuestoTrabajo);

			logger.info("El puesto de trabajo {} se elimino",idPuestoTrabajo);

			return  new ResponseDTO(null, true, OK, HttpStatus.OK); 
		}catch (Exception e) {

			logger.error("Error {}",e.getMessage());

			return  new ResponseDTO(null, false, ERROR_GENERICO, HttpStatus.OK); 
		}
	}

}
