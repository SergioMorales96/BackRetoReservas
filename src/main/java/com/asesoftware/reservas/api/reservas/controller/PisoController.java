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

import com.asesoftware.reservas.api.reservas.dto.PisoDTO;
import com.asesoftware.reservas.api.reservas.dto.ResponseDTO;
import com.asesoftware.reservas.api.reservas.service.IPisoService;

@RestController
@RequestMapping(path = "/api/v1/piso")
@CrossOrigin(origins = "*")
public class PisoController {
	
	private static final Logger logger = LoggerFactory.getLogger(PisoController.class);
	
	@Autowired
	private IPisoService pisoService;

	@GetMapping(path = "/todos")
	public ResponseDTO consultarTodos() {
		logger.info("consultar Todos()");
		return pisoService.consultarTodos();
	}
	@PostMapping(path = "/crear", consumes = "application/json",produces = "application/json")
	public ResponseDTO crearPiso(@RequestBody PisoDTO dto) {
		logger.info("crear piso {}", dto);
		return pisoService.crearPiso(dto);
		
	}
	@PostMapping(path = "/actualizar" , consumes = "application/json" , produces = "application/json")
	public ResponseDTO actualizarPiso(@RequestBody PisoDTO dto) {
		logger.info("actualizar piso {}",dto);
		return pisoService.actualizarPiso(dto);
	}
	@GetMapping(path = "/eliminar/{idPiso}")
	public ResponseDTO eliminarPiso(@PathVariable Integer idPiso) {
		logger.info("piso a eliminar {}", idPiso);
		return pisoService.eliminarPiso(idPiso);
	}
	
	@GetMapping(path = "/consultar/{idPiso}")
	public ResponseDTO pisoPorId(@PathVariable Integer idPiso) {
		logger.info("consultar piso dto{}", idPiso);
		return pisoService.pisoPorId(idPiso);
	}
	
	@GetMapping(path = "/numero/{numPiso}")
	public ResponseDTO numeroDePiso(@PathVariable Integer numPiso) {
		logger.info("consultar piso por numero {}", numPiso);
		return pisoService.pisoPorNumeroPiso(numPiso);	
	}

	@GetMapping(path = "sucursal/{id}")
	public ResponseDTO pisoporIdSucursal(@PathVariable Integer id){
		
		return pisoService.pisoPorIdSucursal(id);
	}
}
