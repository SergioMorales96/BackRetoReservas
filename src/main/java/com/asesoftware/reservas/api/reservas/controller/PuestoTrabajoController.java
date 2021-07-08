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

import com.asesoftware.reservas.api.reservas.dto.PuestoTrabajoDTO;
import com.asesoftware.reservas.api.reservas.dto.ResponseDTO;
import com.asesoftware.reservas.api.reservas.service.IPuestoTrabajoService;


@RestController
@RequestMapping(path="/api/v1/puestoTrabajo")
@CrossOrigin(origins = "*")
public class PuestoTrabajoController {

	private static final Logger logger = LoggerFactory.getLogger(PuestoTrabajoController.class);

	@Autowired
	private IPuestoTrabajoService puestoTrabajoService;

	/**
	 * Metodo encargado de buscar todos los puestos de trabajo
	 * @author: kpinilla
	 * @version: 01/07/2021
	 */
	@GetMapping(path = "/todas")
	public ResponseDTO consultarTodas() {
		logger.info("consultarTodas()");
		return puestoTrabajoService.consultarTodas();
	}
	/**
	 * Metodo encargado de buscar puestos de trabajo por ID
	 * @author: kpinilla
	 * @version: 01/07/2021
	 */
	@GetMapping(path = "/buscarPorId/{idPuestoTrabajo}")

	public ResponseDTO puestoTrabajoPorId(@PathVariable Integer idPuestoTrabajo) {

		logger.info("puestoTrabajoPorId: {}", idPuestoTrabajo);

		return puestoTrabajoService.puestoTrabajoPorId(idPuestoTrabajo);

	}
	/**
	 * Metodo encargado de crear puesto de trabajo
	 * @author: drlopez
	 * @version: 01/07/2021
	 */
	@PostMapping(path = "/crear",consumes = "application/json",produces = "application/json")
	public ResponseDTO crearPuestoTrabajo(@RequestBody PuestoTrabajoDTO puestoTrabajoDTO) {
		logger.info("crearPuestoTrabajo: {}", puestoTrabajoDTO);
		return puestoTrabajoService.crearPuestoTrabajo(puestoTrabajoDTO);

	}
	/**
	 * Metodo encargado de actualizar puesto de trabajo
	 * @author: drlopez
	 * @version: 01/07/2021
	 */
	@PostMapping(path = "/actualizar",consumes = "application/json",produces = "application/json")
	public ResponseDTO actualizarPuestoTrabajo(@RequestBody PuestoTrabajoDTO puestoTrabajoDTO) {
		logger.info("actualizarPuestoDeTrabajo: {}", puestoTrabajoDTO);

		return puestoTrabajoService.actualizarPuestoTrabajo(puestoTrabajoDTO);

	}
	/**
	 * Metodo encargado de eliminar puesto de trabajo
	 * @author: kpinilla
	 * @version: 01/07/2021
	 */
	@GetMapping(path = "/borrar/{idPuestoTrabajo}")
	public ResponseDTO borrarPuestoTrabajo(@PathVariable Integer idPuestoTrabajo) {

		logger.info("Puesto de trabajo a eliminar {}",idPuestoTrabajo);

		return puestoTrabajoService.borrarPuestoTrabajo(idPuestoTrabajo);
	}


}
