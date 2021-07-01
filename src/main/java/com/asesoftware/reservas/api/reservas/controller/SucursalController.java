package com.asesoftware.reservas.api.reservas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/sucursales")
public class SucursalController {
	
	@Autowired
	private ISucursalService sucursalesService;

}
