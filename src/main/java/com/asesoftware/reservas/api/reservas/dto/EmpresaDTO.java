package com.asesoftware.reservas.api.reservas.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class EmpresaDTO implements Serializable  {
	
	private static final long serialVersionUID = 1L;

	private String nit;

	private String alias;

	private String codigoVerificacion;

	private String nombre;

}
