package com.asesoftware.reservas.api.reservas.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class CalendarioSalaDTO implements Serializable{
	
	
	private static final long serialVersionUID = 1L;


	Integer numeroReserva;
	
    
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy",timezone = "America/Bogota")
	Date dia;
	
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "kk:mm",timezone = "America/Bogota")
	Date horaInicio;
	
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "kk:mm",timezone = "America/Bogota")
	Date horaFin;
	
	public CalendarioSalaDTO() {}
	
	
	public CalendarioSalaDTO(Integer numeroReserva, Date dia, Date horaInicio, Date horaFin) {
		super();
		this.numeroReserva = numeroReserva;
		this.dia = dia;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
	}
	
	
	
	
	
	
	
}
