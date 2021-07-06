package com.asesoftware.reservas.api.reservas.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.asesoftware.reservas.api.reservas.dto.ResponseDTO;
import com.asesoftware.reservas.api.reservas.dto.SucursalDTO;
import com.asesoftware.reservas.api.reservas.service.ISucursalService;

@RestController
@RequestMapping(path = "/api/v1/sucursales")
public class SucursalController {
	
	private static final Logger logger  = LoggerFactory.getLogger(SucursalController.class);

	@Autowired
	private ISucursalService sucursalService;

	/**
	* Controlador para acceder al método Listar Sucursales
	* @author acmoya
	* @version 0.1, 2021/07/01
	*/
	
	@GetMapping(path = "/all")
	public ResponseDTO getAll(){
		
		logger.info("ingreso al metodo getAll");

		return sucursalService.getAll();
	}

	/**
	* Controlador para acceder al método Listar Sucursal por ID
	* @author smmorales
	* @version 0.1, 2021/07/01
	*/

	@GetMapping(path = "/sucursales/{id}")
	public ResponseDTO getSucursalById(@PathVariable Integer id) {

		logger.info("ingreso al metodo getSucursalById {}", id);
		
		return sucursalService.getSucursalById(id);
	}

	@GetMapping(path = "/sucursales")
	public ResponseDTO getSucursalParametroById(@RequestParam Integer id) {
		
		logger.info("ingreso al metodo getSucursalParametroById {}", id);

		return sucursalService.getSucursalById(id);
	}

	/**
	* Controlador para acceder al método Crear Sucursal
	* @author smmorales
	* @version 0.1, 2021/07/01
	*/

	@PostMapping(path = "/crear", consumes = "application/json", produces = "application/json")
	public ResponseDTO crearSucursal(@RequestBody SucursalDTO entity) {
		
		logger.info("ingreso al metodo createSucursal {}", entity);

		return sucursalService.crearSucursal(entity);
	}

	/**
	* Controlador para acceder al método Editar Sucursal
	* @author smmorales
	* @version 0.1, 2021/07/01
	*/

	@PostMapping(path = "/editar", consumes = "application/json", produces = "application/json")
	public ResponseDTO editarSucursal(@RequestBody SucursalDTO entity) {
		
		logger.info("ingreso al metodo editarSucursal {}", entity);

		return sucursalService.editarSucursal(entity);
	}
	
	/**
	* Controlador para acceder al método Eliminar Sucursal
	* @author acmoya
	* @version 0.1, 2021/07/01
	*/
	
	@GetMapping(path = "/delete/{id}")
	public ResponseDTO eliminarSucursal(@PathVariable Integer id) {
		
		logger.info("ingreso al metodo deleteSucursal {}", id);
		
		return sucursalService.eliminarSucursal(id);
	}
	
	/**
	* Controlador para acceder al servicio de sucursales por empresa
	* @author jcanizales
	* @version 0.1, 2021/07/06
	*/
	
	@GetMapping(path = "/all/{nit}")
	public ResponseDTO consultarSucursalxEmpresa(@RequestParam String nit) {
		logger.info("ingreso al metodo consultarSucursalxEmpresa {}", nit);
		return sucursalService.consultarSucursalxEmpresa(nit);
	}

}
