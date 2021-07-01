package com.asesoftware.reservas.api.reservas.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asesoftware.reservas.api.reservas.mapper.ISucursalMapper;
import com.asesoftware.reservas.api.reservas.repository.ISucursalRepository;

@Service
public class SucursalService {
	
	@Autowired
	private ISucursalRepository sucursalRepository;
	
	@Autowired
	private ISucursalMapper mapperSucursal;


}
