package com.asesoftware.reservas.api.reservas.dto;

import org.springframework.http.HttpStatus;

import lombok.Data;

//Esta clase hará de contenedor de la respuesta. Su función es tener campos comunes a todas las peticiones.
//los campos comunes -para creación, por ejemplo- serán: Información (Data), status (mensajes) y error.
//Va a envolver la respuesta que se dará al usuario.
//Esta clase va ser la entidad que siempre se va retornar al usuario

@Data
public class ResponseDTO {

	private Object data;
	private boolean success;
	private String message;
	private HttpStatus status;
	
//Implementar constructor por defecto y automaticamente
	
	public ResponseDTO() {}
	
	public ResponseDTO(Object data, boolean success, String message, HttpStatus status) {
		this.data = data;
		this.success = success;
		this.message = message;
		this.status = status;
	}
}
