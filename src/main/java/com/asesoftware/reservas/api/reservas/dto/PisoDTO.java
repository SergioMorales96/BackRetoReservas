package com.asesoftware.reservas.api.reservas.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class PisoDTO  implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer idPiso;

	private Integer aforoMaximo;

	private Integer idSucursal;

	private String nombre;

	private Integer numeroPiso;
	
	private String nombreSucursal;
}
