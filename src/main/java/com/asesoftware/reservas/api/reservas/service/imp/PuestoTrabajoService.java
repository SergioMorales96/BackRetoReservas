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

@Service
public class PuestoTrabajoService implements IPuestoTrabajoService{
	
	@Autowired
	private IPuestoTrabajoRepository puestoTrabajoRepositorio;
	
	@Autowired
	private IPuestoTrabajoMapper puestoTrabajoMapper;
	
	private static final Logger logger = LoggerFactory.getLogger(PuestoTrabajoService.class);

	@Override
	public ResponseDTO consultarTodas() {
		
		logger.info("consultarTodas()");
		List<PuestoTrabajoEntity> lisPuestoTrabajo = puestoTrabajoRepositorio.findAll();
		logger.info("consultarTodas() {}", lisPuestoTrabajo);
		return new ResponseDTO(puestoTrabajoMapper.entitysToDtos(lisPuestoTrabajo), true, "Ok", HttpStatus.OK);
	}

	@Override
	public ResponseDTO PuestoTrabajoPorId(Integer idPuestoTrabajo) {
		
		Optional <PuestoTrabajoEntity> puestoTrabajoEntity = puestoTrabajoRepositorio.findById(idPuestoTrabajo);
		
		if(puestoTrabajoEntity.isPresent()) {
			return new ResponseDTO(puestoTrabajoMapper.entityToDto(puestoTrabajoEntity.get()), true, "OK", HttpStatus.OK);
		}else {
			return new ResponseDTO(null, false, "Empresa no disponible", HttpStatus.OK);
		}
	}

	@Override
	public ResponseDTO crearPuestoTrabajo(PuestoTrabajoDTO puestoTrabajoDTO) {

		return null;
	}

	@Override
	public ResponseDTO actualizarPuestoTrabajo(PuestoTrabajoDTO puestoTrabajoDTO) {

		return null;
	}

	@Override
	public ResponseDTO borrarPuestoTrabajo(Integer idPuestoTrabajo) {

		logger.info("ingreso al metodo deleteUser");
		
		try {
			puestoTrabajoRepositorio.deleteById(idPuestoTrabajo);
			
			logger.info("el usuario {} se elimino",idPuestoTrabajo);
			
			return  new ResponseDTO(null, true, "usuario eliminado", HttpStatus.OK); 
		}catch (Exception e) {
			
			logger.error("Error {}",e.getMessage());
			
			return  new ResponseDTO(null, false, "el usuario no se puede eliminar", HttpStatus.OK); 
		}
	}

}
