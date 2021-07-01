package com.asesoftware.reservas.api.reservas.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asesoftware.reservas.api.reservas.dto.HorarioPuestoTrabajoDTO;
import com.asesoftware.reservas.api.reservas.dto.ResponseDTO;
import com.asesoftware.reservas.api.reservas.service.IHorarioPuestoTrabajoService;

@RestController
@RequestMapping(path = "/api/v1/HorarioPuestoTrabajo")
public class HorarioPuestoTrabajoController {

	private static final Logger logger = LoggerFactory.getLogger(HorarioPuestoTrabajoController.class);

	@Autowired
	private IHorarioPuestoTrabajoService horarioPuestoTrabajoService;

	/**
	 * Método que genera el endpoint y llama al servicio, para consultar todos los
	 * registros de la tabla HorarioPeustoTrabajo.
	 * 
	 * @author jlucero
	 * @param
	 * @return ResponseDTO
	 */
	@GetMapping(path = "/todos")
	public ResponseDTO consultarTodos() {
		logger.info("Ingresó al metodo consultarTodos()");
		return horarioPuestoTrabajoService.consultarTodos();
	}

	/**
	 * Método que genera el endpoint y llama al servicio, le pasa el
	 * HorarioPuestoTrabajoDTO para crear un nuevo.
	 * 
	 * @author jlucero
	 * @param HorarioPuestoTrabajoDTO
	 * @return ResponseDTO
	 */

	@PostMapping(path = "/crear", consumes = "application/json", produces = "application/json")
	public ResponseDTO crearHorario(@RequestBody HorarioPuestoTrabajoDTO horarioPuestoTrabajoDTO) {
		// Logger que informa que la aplicación entró al método crearHorario()
		logger.info(" Ingresó al metodo crearHorario()");

		return horarioPuestoTrabajoService.crearHorario(horarioPuestoTrabajoDTO);
	}

	/**
	 * Método que genera el endpoint y llama al servicio, le pasa el id del
	 * HorarioPuestoTrabajoDTO para eliminarlo.
	 * 
	 * @author jlucero
	 * @param id
	 * @return ResponseDTO
	 */
	@GetMapping(path = "eliminar/{id}")
	public ResponseDTO eliminarPorId(@PathVariable Integer id) {
		logger.info("Ingreso al metodo eliminarHorarioPuestoTrabajo ");

		logger.info("HorarioPuestoTrabajo a eliminar {}", id);

		return horarioPuestoTrabajoService.borrarHorarioPorId(id);
	}

	/**
	 * CONSULTAR POR ID: Controlador que presta el servicio de consultar registro
	 * por id
	 * 
	 * @author jrondon
	 * 
	 * @param id: identificador del horario a consultar
	 * @return ResponseDTO: datos correstondientes al identificador que se expondran
	 *         en la consulta
	 */
	@GetMapping(path = "/horario/{id}")
	public ResponseDTO getHorarioPorId(@PathVariable Integer id) {
		logger.info("Ingreso al metodo getHorarioPorId() ");

		logger.info("HorarioPuestoTrabajo a consultar {}", id);
		return horarioPuestoTrabajoService.consultarHorarioPorId(id);
	}

	/**
	 * EDITAR HORARIO: Controlador que presta el servicio de editar registro
	 * 
	 * @author jrondon
	 * 
	 * @param dto: registro con datos a actualizar proveniente de la consulta
	 *             externa
	 * @return ResponseDTO: datos actualizados provenientes del servicio
	 */
	@PostMapping(path = "/editar", consumes = "application/json", produces = "application/json")
	public ResponseDTO editarHorario(@RequestBody HorarioPuestoTrabajoDTO dto) {
		logger.info("Ingreso al metodo editarHorario() ");

		return horarioPuestoTrabajoService.actualizarHorarioPuestoTrabajo(dto);
	}

}
