package com.asesoftware.reservas.api.reservas.dto;

import org.springframework.http.HttpStatus;
import lombok.Data;


@Data
public class ResponseDTO     {

	private Object data;
	private boolean success;
	private String message;
	private HttpStatus status;
		
	public ResponseDTO() {}
	
	public ResponseDTO(Object data, boolean success, String message, HttpStatus status) {
		this.data = data;
		this.success = success;
		this.message = message;
		this.status = status;
	}
}
