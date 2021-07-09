package com.asesoftware.reservas.api.reservas.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReservasPTDiaSPDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String correo;
	private Integer numReserva;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy",timezone = "America/Bogota")
	private Date dia;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "HH:mm",timezone = "America/Bogota")
	private Date horaInicio;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "HH:mm",timezone = "America/Bogota")
	private Date horaFin;
	
	private String estado; 
	private Integer puestoDeTrabajo;
	private String nombre;
	private Integer piso;
	private String nombrePiso;
	private String sucursal;
	private String empresa;
	
	
}

