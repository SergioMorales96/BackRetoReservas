package com.asesoftware.reservas.api.reservas.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class ReservaAddDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
		
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy",timezone = "America/New_York")
	private Date dia;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm", timezone = "America/New_York")
	private Date horaInicio;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm", timezone = "America/New_York")
	private Date horaFin;
	private Integer totalHoras;
	private String dominioTipoVehiculo;
	private String placa;
	private String emailUsuario;
	private String proyecto;
	private Integer idRelacion;
	private String tipoReserva;	
	private String emailsAsistentes;
}
