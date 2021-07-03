package com.asesoftware.reservas.api.reservas.service.imp;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


import com.asesoftware.reservas.api.reservas.dto.ResponseDTO;
import com.asesoftware.reservas.api.reservas.dto.UsuarioBloqueadoDTO;
import com.asesoftware.reservas.api.reservas.entity.UsuarioBloqueadoEntity;
import com.asesoftware.reservas.api.reservas.mapper.IUsuarioBloqueadoMapper;
import com.asesoftware.reservas.api.reservas.repository.IUsuarioBloqueadoRepository;
import com.asesoftware.reservas.api.reservas.service.IUsuarioBloqueadoService;
import static com.asesoftware.reservas.api.reservas.utils.Constantes.OK;
import static com.asesoftware.reservas.api.reservas.utils.Constantes.ERROR_GENERICO;


@Service
public class UsuarioBloqueadoService implements IUsuarioBloqueadoService{

	private static final Logger logger = LoggerFactory.getLogger(UsuarioBloqueadoService.class);


	@Autowired
	private IUsuarioBloqueadoRepository usuarioBloqueadoRepository;


	@Autowired
	private IUsuarioBloqueadoMapper usuarioBloqueadoMapper;

	/** Consultar todos los usuarios bloqueados* Consultar los usuarios registrados como bloqueados en la base de datos* 
	 * @author ajgutierrez / Empresa* 
	 * @version 0.1, 2021/07/01
	 */
	@Override
	public ResponseDTO consultarTodosLosUsuariosBloqueados() {

		List<UsuarioBloqueadoEntity> answ = this.usuarioBloqueadoRepository.findAll();
		logger.info("consultarTodosLosUsuariosBloqueados()");
		if(!answ.isEmpty()) {
			return new ResponseDTO(this.usuarioBloqueadoMapper.entitysToDtos(answ), true, OK, HttpStatus.OK);
		}else {
			return new ResponseDTO(null, false, ERROR_GENERICO, HttpStatus.OK);
		}



	}
	
	
	/** Consultar usuario bloqueado por id* Consultar el usuario por su id registrado como bloqueado en la base de datos* 
	 * @author ajgutierrez / Empresa* 
	 * @version 0.1, 2021/07/01
	 */
	@Override
	public ResponseDTO consultarUsuarioBloqueadoPorId(String correo) {

		logger.info("consultarUsuarioBloqueadoPorId()");
		List<UsuarioBloqueadoEntity> answ = this.usuarioBloqueadoRepository.findByEmail(correo);

		if(!answ.isEmpty()) {
			return new ResponseDTO(this.usuarioBloqueadoMapper.entitysToDtos(answ), true, "Ok", HttpStatus.OK);
		}else {
			return new ResponseDTO(null, false, "No Ok", HttpStatus.OK);
		}
	}

	
	/** Crear un nuevo usuario bloqueado* Registra el usuario especificado en la base de datos como bloqueado* 
	 * @author ajgutierrez / Empresa* 
	 * @version 0.1, 2021/07/01
	 */
	@Override
	public ResponseDTO crearUsuarioBloqueado(UsuarioBloqueadoDTO dto) {
		logger.info("crearUsuarioBloqueado()");
		try {
			UsuarioBloqueadoEntity answ = this.usuarioBloqueadoRepository.save(this.usuarioBloqueadoMapper.dtoToEntity(dto));
			logger.info("Usuario Creado");
			return new ResponseDTO(this.usuarioBloqueadoMapper.entityToDto(answ), true, "Ok", HttpStatus.OK);
		} catch (Exception e) {
			logger.info("Usuario no creado");
			return new ResponseDTO(null, false, "Usuario no creado", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	/** Actualizar un usuario bloqueado* Actualizar los datos de un usuario bloqueado en la base de datos* 
	 * @author pvalderrama / Empresa* 
	 * @version 0.1, 2021/07/01
	 */
	@Override
	public ResponseDTO actualizarUsuarioBloqueado(UsuarioBloqueadoDTO usuarioBloqueadoDTO) {

		logger.info("actualizarUsuarioBloqueado");

		UsuarioBloqueadoEntity usuarioBloqueadoEntity = usuarioBloqueadoMapper.dtoToEntity(usuarioBloqueadoDTO);
		try {
			usuarioBloqueadoRepository.save(usuarioBloqueadoEntity);

			logger.info("usuario bloqueado actualizado");
			return new ResponseDTO(usuarioBloqueadoMapper.entityToDto(usuarioBloqueadoEntity), true, "usuario bloqueado actualizado correctamente", HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseDTO(null, false, "usuario bloqueado no actualizado", HttpStatus.INTERNAL_SERVER_ERROR);
		}



	}
	
	/** Eliminar usuario bloqueado* Elimina un usuario bloqueado de la base de datos dado su id* 
	 * @author pvalderrama / Empresa* 
	 * @version 0.1, 2021/07/01
	 */

	@Override
	public ResponseDTO eliminarUsuarioBloqueado(Integer id) {
		logger.info("eliminarUsuarioBloqueado");
		try {
			usuarioBloqueadoRepository.deleteById(id);
			return new ResponseDTO(null, true, "usuario bloqueado eliminado", HttpStatus.OK);
		}catch(Exception e){
			logger.error("Error {}",e.getMessage());
			return new ResponseDTO(null, false, "usuario bloqueado no existe", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
	
	/** Consultar todos los usuarios bloqueados en una sucursal* Consultar los usuarios registrados como bloqueados en una sucursal en la base de datos* 
	 * @author ajgutierrez / Empresa* 
	 * @version 0.1, 2021/07/01
	 */
	@Override
	public ResponseDTO consultarUsuariosBloqueadosPorSucursal(Integer id) {
		logger.info("consultarUsuariosBloqueadosPorSucursal, id sucursal: {}", id);
		List<UsuarioBloqueadoEntity> answ = this.usuarioBloqueadoRepository.findBySucursalEntityIdSucursal(id);
		
		if(!answ.isEmpty()) {
			return new ResponseDTO(this.usuarioBloqueadoMapper.entitysToDtos(answ), true, OK, HttpStatus.OK);
		}else {
			return new ResponseDTO(null, false, ERROR_GENERICO, HttpStatus.OK);
		}
		
		
	}



}
