package com.asesoftware.reservas.api.reservas.dto;

import java.util.Date;

import lombok.Data;

@Data
public class ReservasPTDiaDTO {
	
	private String correo;
	private Integer numReserva;
	private Date dia;
	private Date horaInicio;
	private Date horaFin;
	private Character estado; //revisar tipo de dato
	private Integer puestoDeTrabajo;
	private String nombrePuesto;
	private Integer piso;
	private String nombrePiso;
	private String sucursal;
	private String empresa;
	
	public ReservasPTDiaDTO() {
		
	}

	public ReservasPTDiaDTO(String correo, Integer numReserva, Date dia, Date horaInicio, Date horaFin,
			Character estado, Integer puestoDeTrabajo, String nombrePuesto, Integer piso, String nombrePiso,
			String sucursal, String empresa) {
		this.correo = correo;
		this.numReserva = numReserva;
		this.dia = dia;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.estado = estado;
		this.puestoDeTrabajo = puestoDeTrabajo;
		this.nombrePuesto = nombrePuesto;
		this.piso = piso;
		this.nombrePiso = nombrePiso;
		this.sucursal = sucursal;
		this.empresa = empresa;
	}
	
	
}

