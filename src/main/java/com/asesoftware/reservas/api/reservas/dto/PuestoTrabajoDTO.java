package com.asesoftware.reservas.api.reservas.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class PuestoTrabajoDTO  implements Serializable  {

	private static final long serialVersionUID = 1L;

	private Integer idPuestoTrabajo;
	
	private String dominioEstado;	
	
	private String dominioTipo;
	
	private Integer idPiso;
	
	private String nombre;
	
	private String nombrePiso;

}
