package com.asesoftware.reservas.api.reservas.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReservasUsuaSPDTO {
	
	private Integer numeroReserva;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy",timezone = "America/New_York")
	private Date dia;

	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "HH:mm:ss",timezone = "America/New_York")
	private Date horaInicio;

	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "HH:mm:ss",timezone = "America/New_York")
	private Date horaFin;
	
	private Integer totalHoras;
	
	private String dominioEstado;
	
	private String dominioTipoVehiculo;
	
	private String parqueadero;
	
	private String placa;
	
	private String nombreUsuario;
	
	private String proyecto;
	
	private Integer idPuestoTrabajo;
	
	private Integer idSala;
	
	private String nombreSala;
	
	private String nombrePuesTrabajo;
	
	private Integer idPiso;
	
	private Integer numeroAsistentes;
}
