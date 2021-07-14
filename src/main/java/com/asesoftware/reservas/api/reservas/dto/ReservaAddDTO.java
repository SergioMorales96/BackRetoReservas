package com.asesoftware.reservas.api.reservas.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReservaAddDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer numeroReserva;	
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy",timezone = "America/Bogota")
	private Date dia;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm", timezone = "America/Bogota")
	private Date horaInicio;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm", timezone = "America/Bogota")
	private Date horaFin;
	private Integer totalHoras;
	private String dominioTipoVehiculo;
	private String placa;
	private String emailUsuario;
	private String proyecto;
	private Integer idRelacion;
	private String tipoReserva;	
}
