package com.asesoftware.reservas.api.reservas.dto;

import lombok.Data;

@Data
public class UsuarioAdministradorDTO {

	private Integer idAdministrador;
	
	private String email;

	private Integer idSucursal;
}
