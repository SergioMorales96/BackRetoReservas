package com.asesoftware.reservas.api.reservas.dto;



import java.io.Serializable;

import lombok.Data;

@Data
public class DominioDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String codigoDominio;
	
	private String valorDominio;

	private String descripcion;

}
