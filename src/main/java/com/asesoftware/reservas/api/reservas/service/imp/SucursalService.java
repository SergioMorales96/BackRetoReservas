package com.asesoftware.reservas.api.reservas.service.imp;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.asesoftware.reservas.api.reservas.dto.ResponseDTO;
import com.asesoftware.reservas.api.reservas.dto.SucursalDTO;
import com.asesoftware.reservas.api.reservas.entity.SucursalEntity;
import com.asesoftware.reservas.api.reservas.mapper.ISucursalMapper;
import com.asesoftware.reservas.api.reservas.repository.ISucursalRepository;
import com.asesoftware.reservas.api.reservas.service.ISucursalService;
import static com.asesoftware.reservas.api.reservas.utils.Constantes.OK;
import static com.asesoftware.reservas.api.reservas.utils.Constantes.ERROR_GENERICO;

@Service
public class SucursalService implements ISucursalService{

	private static final Logger logger = LoggerFactory.getLogger(SucursalService.class);

	@Autowired
	private ISucursalRepository sucursalRepository;

	@Autowired
	private ISucursalMapper mapperSucursal;

	/**
	 * Método Listar Sucursales
	 * @author acmoya
	 * @version 0.1, 2021/07/01
	 */

	@Override
	public ResponseDTO getAll() {

		return new ResponseDTO( mapperSucursal.listEntityToDto( sucursalRepository.findAll()), true, OK, HttpStatus.OK);
	}	

	/**
	 * Método Listar Sucursal por ID
	 * @author smmorales
	 * @version 0.1, 2021/07/01
	 */

	@Override
	public ResponseDTO getSucursalById(Integer id) {

		Optional<SucursalEntity> optional = sucursalRepository.findById(id);

		if (optional.isPresent()) {
			logger.info("La sucursal {} fue encontrada",id);
			return new ResponseDTO(optional.get(), true, OK, HttpStatus.OK);
		}else {
			logger.info("La sucursal {} no fue encontrada",id);
			return  new ResponseDTO(null, false, ERROR_GENERICO, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Método Crear Sucursal
	 * @author smmorales
	 * @version 0.1, 2021/07/01
	 */

	@Override
	public ResponseDTO crearSucursal(SucursalDTO sucursalDTO) {
		try {
			SucursalEntity sucursalEntity = mapperSucursal.dtoToEntity(sucursalDTO);
			sucursalRepository.save(sucursalEntity);
			logger.info("La sucursal {} se creo", sucursalDTO);
			return new ResponseDTO(mapperSucursal.entityToDto(sucursalEntity), true, OK, HttpStatus.OK);
		}catch (Exception e) {
			logger.error("Error en crear {}",e.getMessage());
			return new ResponseDTO(null, false, ERROR_GENERICO, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	/**
	 * Método Editar Sucursal
	 * @author smmorales
	 * @version 0.1, 2021/07/01
	 */

	@Override
	public ResponseDTO editarSucursal(SucursalDTO sucursalDTO) {
		try {
			SucursalEntity sucursalEntity = mapperSucursal.dtoToEntity(sucursalDTO);
			sucursalRepository.save(sucursalEntity);
			logger.info("La sucursal {} se actualizo", sucursalDTO);
			return new ResponseDTO(mapperSucursal.entityToDto(sucursalEntity), true, OK, HttpStatus.OK);
		}catch(Exception e) {
			logger.error("Error en editar {}",e.getMessage());
			return new ResponseDTO(null, false, ERROR_GENERICO, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	/**
	 * Método Eliminar Sucursal
	 * @author acmoya
	 * @version 0.1, 2021/07/01
	 */

	@Override
	public ResponseDTO eliminarSucursal(Integer id) {

		logger.info("ingreso al metodo deleteSucursal");
		try {
			sucursalRepository.deleteById(id);
			logger.info("La sucursal {} se elimino",id);
			return  new ResponseDTO(null, true, OK, HttpStatus.OK); 
		}catch (Exception e) {
			logger.error("Error  en eliminar{}",e.getMessage());
			return  new ResponseDTO(null, false, ERROR_GENERICO, HttpStatus.INTERNAL_SERVER_ERROR); 
		}

	}

	/**
	 * Método consultar Sucursal por Empresa
	 * @author jcanizales
	 * @version 0.1, 2021/07/06
	 */

	@Override
	public ResponseDTO consultarSucursalxEmpresa(String nit) {
		logger.info("ingreso al metodo consultarSucursalxEmpresa");

		List<SucursalEntity> listSucursalEntities = sucursalRepository.findByEmpresaEntityNit(nit);


		return new ResponseDTO(mapperSucursal.listEntityToDto(listSucursalEntities), true, OK, HttpStatus.OK);

	}
}
