package com.asesoftware.reservas.api.reservas.service.imp;

import org.springframework.stereotype.Service;

@Service
public class SucursalService {
	
	@Autowired
	private ISucursalRepository sucursalRepository;
	
	@Autowired
	private ISucursalMapper mapperSucursal;


}
