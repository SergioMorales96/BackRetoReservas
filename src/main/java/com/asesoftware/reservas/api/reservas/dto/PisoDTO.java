package com.asesoftware.reservas.api.reservas.dto;

import javax.persistence.Column;

import lombok.Data;

@Data
public class PisoDTO {
	private Integer idPiso;

	private Integer aforoMaximo;

	private Integer idSucursal;

	private String nombre;

	private Integer numeroPiso;
}
