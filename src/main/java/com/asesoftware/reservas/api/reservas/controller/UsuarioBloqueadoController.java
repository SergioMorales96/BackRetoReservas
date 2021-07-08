package com.asesoftware.reservas.api.reservas.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asesoftware.reservas.api.reservas.dto.ResponseDTO;
import com.asesoftware.reservas.api.reservas.dto.UsuarioBloqueadoDTO;
import com.asesoftware.reservas.api.reservas.service.IUsuarioBloqueadoService;


@RestController
@RequestMapping(path = "/api/v1/usuarioBloqueado")
@CrossOrigin(origins = "*")
public class UsuarioBloqueadoController {
	
	private static final Logger logger = LoggerFactory.getLogger(UsuarioBloqueadoController.class);
	
	
	@Autowired
	private IUsuarioBloqueadoService usuarioBloqueadoService;
	
	
	/** Controlador consultar todos los usuarios bloqueados* Gestionar la petición de consulta todos los usuarios bloqueados* 
	 * @author ajgutierrez / Empresa* 
	 * @version 0.1, 2021/07/01
	 */
	@GetMapping(path = "/todos")
	public ResponseDTO consultarTodosLosUsuariosBloqueados() {
		logger.info("consultarTodosLosUsuariosBloqueados()");
		return this.usuarioBloqueadoService.consultarTodosLosUsuariosBloqueados();
	}
	
	/** Controlador consultar usuario bloqueado por id* Gestionar la petición de consulta usuario por id* 
	 * @author ajgutierrez / Empresa* 
	 * @version 0.1, 2021/07/01
	 */
	@GetMapping(path = "/usuarioBloqueadoPorId/{correo}")
	public ResponseDTO consultarUsuarioBloqueadoPorId(@PathVariable String correo) {
		logger.info("consultarUsuarioBloqueadoPorId() {}", correo);
		return this.usuarioBloqueadoService.consultarUsuarioBloqueadoPorId(correo);
	}
	
	
	/** Controlador crear un usuario bloqueado* Gestionar la petición de creación de un nuevo usuario bloqueado* 
	 * @author ajgutierrez / Empresa* 
	 * @version 0.1, 2021/07/01
	 */
	@PostMapping(path = "/crear", consumes = "application/json", produces = "application/json")
	public ResponseDTO crearUsuarioBloqueado(@RequestBody UsuarioBloqueadoDTO dto) {
		logger.info("Usuario recibido {}", dto);
		return this.usuarioBloqueadoService.crearUsuarioBloqueado(dto);
	}
	
	
	/** Controlador actualizar un usuario bloqueado* Gestionar la petición de actualización de un usuario bloqueado* 
	 * @author pvalderrama / Empresa* 
	 * @version 0.1, 2021/07/01
	 */
	@PostMapping(path = "/actualizar", consumes = "application/json", produces = "application/json")
	public ResponseDTO actualizarUsuarioBloqueado(@RequestBody UsuarioBloqueadoDTO entity) {
		logger.info("usuario bloqueado actualizado con los datos {}", entity);
		return usuarioBloqueadoService.actualizarUsuarioBloqueado(entity);
	}
	
	
	/** Controlador eliminar un usuario bloqueado* Gestionar la petición de eliminación de un usuario bloqueado* 
	 * @author pvalderrama / Empresa* 
	 * @version 0.1, 2021/07/01
	 */
	@GetMapping(path = "/eliminar/{id}")
	public ResponseDTO eliminarUsuarioBloqueado(@PathVariable Integer id) {
		logger.info("usuario bloqueado a eliminar con id {}",id);
		return usuarioBloqueadoService.eliminarUsuarioBloqueado(id);
	}
	
	/** Controlador consultar usuarios bloqueados por sucursal* Gestionar la petición de consulta todos los usuarios bloqueados por sucursal* 
	 * @author ajgutierrez / Empresa* 
	 * @version 0.1, 2021/07/01
	 */
	@GetMapping(path = "/porSucursal/{id}")
	public ResponseDTO consultarUsuariosBloqueadosPorSucursal(@PathVariable Integer id) {
		logger.info("consultar usuarios bloqueados por sucursal con id {}",id);
		return this.usuarioBloqueadoService.consultarUsuariosBloqueadosPorSucursal(id);
	}
}
