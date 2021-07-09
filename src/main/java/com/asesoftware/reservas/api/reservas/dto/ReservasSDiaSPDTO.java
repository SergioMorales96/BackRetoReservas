package com.asesoftware.reservas.api.reservas.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;


@Data
public class ReservasSDiaSPDTO {
	
	private Integer numeroReserva;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy",timezone = "America/New_York")
	private Date dia;

	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "HH:mm:ss",timezone = "America/New_York")
	private Date horaInicio;

	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "HH:mm:ss",timezone = "America/New_York")
	private Date horaFin;
	
	private String nombreUsuario;
	
	private String nombreSala;
	
	private Integer numeroAsistentes;
	
	public ReservasSDiaSPDTO() {}

	public ReservasSDiaSPDTO(Integer numeroReserva, Date dia, Date horaInicio, Date horaFin, String nombreUsuario,
			String nombreSala, Integer numeroAsistentes) {
		
		this.numeroReserva = numeroReserva;
		this.dia = dia;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.nombreUsuario = nombreUsuario;
		this.nombreSala = nombreSala;
		this.numeroAsistentes = numeroAsistentes;
	}
	
	

}
