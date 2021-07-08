package com.asesoftware.reservas.api.reservas.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class SucursalDTO implements Serializable  {
	
	private static final long serialVersionUID = 1L;

	private Integer idSucursal;
	
	private Integer aforoMaximo;
	
	private String direccion;
	
	private String nit;
	
	private String nombre;
	
	private String nombreEmpresa;
	


}
