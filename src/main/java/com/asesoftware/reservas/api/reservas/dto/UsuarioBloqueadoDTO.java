package com.asesoftware.reservas.api.reservas.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class UsuarioBloqueadoDTO implements Serializable  {
	
	private static final long serialVersionUID = 1L;

	private Integer idBloqueado;

	private String email;

	private Integer idSucursal;
	
	private String nombreSucursal;
	
}
