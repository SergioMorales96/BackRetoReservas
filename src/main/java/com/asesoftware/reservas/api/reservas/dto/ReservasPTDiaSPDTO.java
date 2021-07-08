package com.asesoftware.reservas.api.reservas.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class ReservasPTDiaSPDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String correo;
	private Integer numReserva;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy",timezone = "America/New_York")
	private Date dia;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "HH:mm",timezone = "America/Bogota")
	private Date hora_Inicio;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "HH:mm",timezone = "America/Bogota")
	private Date hora_Fin;
	
	private String estado; 
	private Integer puestoDeTrabajo;
	private String nombre;
	private Integer piso;
	private String nombrePiso;
	private String sucursal;
	private String empresa;
	
	public ReservasPTDiaSPDTO() {
	}
	
	public ReservasPTDiaSPDTO(String correo, Integer numReserva, Date dia, Date hora_Inicio, Date hora_Fin,
			String estado, Integer puestoDeTrabajo, String nombre, Integer piso, String nombrePiso, String sucursal,
			String empresa) {
		this.correo = correo;
		this.numReserva = numReserva;
		this.dia = dia;
		this.hora_Inicio = hora_Inicio;
		this.hora_Fin = hora_Fin;
		this.estado = estado;
		this.puestoDeTrabajo = puestoDeTrabajo;
		this.nombre = nombre;
		this.piso = piso;
		this.nombrePiso = nombrePiso;
		this.sucursal = sucursal;
		this.empresa = empresa;
	}
}

