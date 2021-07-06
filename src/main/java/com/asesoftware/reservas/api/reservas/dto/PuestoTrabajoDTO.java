package com.asesoftware.reservas.api.reservas.dto;

import lombok.Data;

@Data
public class PuestoTrabajoDTO {

	
	private Integer idPuestoTrabajo;
	
	private String dominioEstado;	
	
	private String dominioTipo;
	
	private Integer idPiso;
	
	private String nombre;
	
	private String nombrePiso;

}
