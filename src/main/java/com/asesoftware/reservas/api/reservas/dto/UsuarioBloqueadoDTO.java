package com.asesoftware.reservas.api.reservas.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class UsuarioBloqueadoDTO implements Serializable  {
	
	private static final long serialVersionUID = 1L;

	private Integer idBloqueado;

	private String email;

	private Integer idSucursal;
	
	private String nombreSucursal;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy",timezone = "America/Bogota")
	private Date bloqueadoHasta;
	
}
