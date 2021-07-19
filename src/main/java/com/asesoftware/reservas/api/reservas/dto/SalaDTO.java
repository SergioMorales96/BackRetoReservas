package com.asesoftware.reservas.api.reservas.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class SalaDTO implements Serializable  {
	
	private static final long serialVersionUID = 1L;

	private Integer idSala;

	private Integer aforoMax;

	private String dominioEstado;

	private Integer idPiso;

	private String nombre;
	
	private String nombrePiso;

}
