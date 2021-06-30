package com.asesoftware.reservas.api.reservas.service;

import com.asesoftware.reservas.api.reservas.dto.ResponseDTO;

public interface IUsuarioAdministradorService {
	
	public ResponseDTO adminPorSucursal(Integer idSucursal);

}
