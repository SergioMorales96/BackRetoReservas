package com.asesoftware.reservas.api.reservas.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReservaDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer numeroReserva;
	private Integer idPuestoTrabajo;
	private Integer totalHoras;
	private Integer idSala;
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd",timezone = "America/New_York")
	private Date dia;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm", timezone = "America/New_York")
	private Date horaInicio;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm", timezone = "America/New_York")
	private Date horaFin;
	private String dominioEstado;
	private String dominioTipoVehiculo;
	private String emailUsuario;
	private String parqueadero;
	private String proyecto;
	private String placa;
	
}
