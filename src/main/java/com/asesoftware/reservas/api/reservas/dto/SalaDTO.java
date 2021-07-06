package com.asesoftware.reservas.api.reservas.dto;

import lombok.Data;

@Data
public class SalaDTO {
	
	private Integer idSala;

	private Integer aforoMax;

	private String dominioEstado;

	private Integer idPiso;

	private String nombre;
	
	private String nombrePiso;

}
