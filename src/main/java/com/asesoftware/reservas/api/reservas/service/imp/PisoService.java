package com.asesoftware.reservas.api.reservas.service.imp;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import static com.asesoftware.reservas.api.reservas.utils.Constantes.OK;
import static com.asesoftware.reservas.api.reservas.utils.Constantes.ERROR_GENERICO;

import com.asesoftware.reservas.api.reservas.dto.PisoDTO;
import com.asesoftware.reservas.api.reservas.dto.ResponseDTO;
import com.asesoftware.reservas.api.reservas.entity.PisoEntity;
import com.asesoftware.reservas.api.reservas.mapper.IPisoMapper;
import com.asesoftware.reservas.api.reservas.repository.IPisoRepository;
import com.asesoftware.reservas.api.reservas.service.IPisoService;
import static com.asesoftware.reservas.api.reservas.utils.Constantes.ERROR_GENERICO;
import static com.asesoftware.reservas.api.reservas.utils.Constantes.OK;

@Service
public class PisoService implements IPisoService{
	
	private static final Logger logger = LoggerFactory.getLogger(PisoService.class);
	
	@Autowired
	private IPisoRepository pisoRepository;
	
	@Autowired
	private IPisoMapper pisoMapper;

	/**
	* Implemantacion de metodo Consultar todos los pisos
	* @author lhernandez 
	* @version 0.1, 2021/06/29
	*/
	@Override
	public ResponseDTO consultarTodos() {
		logger.info("consultarTodos()");
		List<PisoEntity> lisPiso = pisoRepository.findAll();
		logger.info("consultarTodos() {}", lisPiso);
		return new ResponseDTO(pisoMapper.entitysToDtos(lisPiso),true,"OK",HttpStatus.OK);
	}
	/**
	* Implemantacion de metodo Consultar piso por id
	* @author lhernandez 
	* @version 0.1, 2021/06/30
	*/
	@Override
	public PisoDTO consultarpisoPorId(Integer idPiso) {
		Optional<PisoEntity> optional = pisoRepository.findById(idPiso);
		if(optional.isPresent()) {
			logger.info("consultarPisoPorId() {}",idPiso);
			return pisoMapper.entityToDto(optional.get());
		} else {
		return null;
	   }
     }
	
		/**
		* Implemantacion de metodo Consultar piso por id que retorna un dto
		* @author cfcruz 
		* @version 0.1, 2021/07/01
		*/
	
		@Override
		public ResponseDTO pisoPorId(Integer idPiso) {
			Optional<PisoEntity> pisoEntity = pisoRepository.findById(idPiso);
			if(pisoEntity.isPresent()) {
				logger.info("se encontro el piso por id");
				return  new ResponseDTO(pisoEntity, true,OK, HttpStatus.OK);
			}else{
				logger.info("No se encontro el piso por id");
				return  new ResponseDTO(null, false, ERROR_GENERICO, HttpStatus.OK);
			}
		}
		
		/**
		* Implemantacion de metodo Consultar piso por numero de piso
		* @author cfcruz 
		* @version 0.1, 2021/07/01
		*/
	
		@Override
		public ResponseDTO pisoPorNumeroPiso(Integer numeroPiso) {
			List<PisoEntity> pisoEntity = pisoRepository.queryPorPiso(numeroPiso);
			if(pisoEntity.isEmpty()) {
				logger.error("El piso no existe");
				return new ResponseDTO(null,false,OK, HttpStatus.OK);
				
			}else {
				logger.info("se encontro el piso");
				return new ResponseDTO(pisoEntity, true,ERROR_GENERICO, HttpStatus.OK);				
			}		
			
		}
		
		/**
		* Implemantacion de metodo Crear piso
		* @author lhernandez 
		* @version 0.1, 2021/06/29
		*/
	
		@Override
		public ResponseDTO crearPiso(PisoDTO pisoDTO) {
			try {
				PisoEntity pisoEntity = pisoMapper.dtoToEntity(pisoDTO);
				pisoRepository.save(pisoEntity);
				logger.info("crearPiso() {}",pisoDTO);
				return new ResponseDTO(pisoMapper.entityToDto(pisoEntity), true,OK,HttpStatus.OK);
			} catch (Exception e) {
				logger.error(e.getMessage());
				return new ResponseDTO(null,false,ERROR_GENERICO,HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		/**
		* Implemantacion de metodo Actualizar piso
		* @author cfcruz 
		* @version 0.1, 2021/07/01
		*/
		@Override
		public ResponseDTO actualizarPiso(PisoDTO pisoDTO) {
			try {
				logger.info("actualizando piso {}",pisoDTO);
				PisoEntity pisoEntity = pisoMapper.dtoToEntity(pisoDTO);
				pisoRepository.save(pisoEntity);
				return new ResponseDTO(pisoMapper.entityToDto(pisoEntity), true,OK, HttpStatus.OK);
			}catch (Exception e) {
				logger.error(e.getMessage());
				return new ResponseDTO(null,false,ERROR_GENERICO,HttpStatus.INTERNAL_SERVER_ERROR);			
			}		
		}
		
		/**
		* Implemantacion de metodo Eliminar por piso
		* @author lhernandez 
		* @version 0.1, 2021/06/29
		*/
		@Override
		public ResponseDTO eliminarPiso(Integer idPiso) {
			try {
				logger.info("eliminarPiso {}", idPiso);
				pisoRepository.deleteById(idPiso);			
				return new ResponseDTO(null,true,OK,HttpStatus.OK);
			} catch (Exception e) {
				logger.error(e.getMessage());
				return new ResponseDTO(null,false,ERROR_GENERICO,HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		/**
		 * Metodo para listar pisos por sucursal
		 * @author jelopez
		 * @version 0.2, 2021/07/02
		 */
		@Override
		public ResponseDTO pisoPorIdSucursal(Integer idSucursal) {
			
			logger.info("pisoPorIdSucursal: {}", idSucursal);
			
			try {
				List<PisoDTO> listPisoSucursal = pisoMapper.entitysToDtos(pisoRepository.queryPisoPorSucursal(idSucursal));

				return new ResponseDTO(listPisoSucursal, true, OK, HttpStatus.OK);
			}catch(Exception e) {
				return new ResponseDTO(null, true, ERROR_GENERICO, HttpStatus.OK);
			}
		}
	}
