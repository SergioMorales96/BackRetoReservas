package com.asesoftware.reservas.api.reservas.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

import java.util.Date;


/**
 * The persistent class for the RESERVA database table.
 * 
 */
@Data
@Entity
@Table(name="RESERVA")
public class ReservaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SEQ_RESERVA", sequenceName="SEQ_RESERVA", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_RESERVA")
	@Column(name="NUMERO_RESERVA")
	private Integer numeroReserva;

	@Temporal(TemporalType.DATE)
	private Date dia;

	@Column(name="DOMINIO_ESTADO")
	private String dominioEstado;

	@Column(name="DOMINIO_TIPO_VEHICULO")
	private String dominioTipoVehiculo;

	@Column(name="EMAIL_USUARIO")
	private String emailUsuario;

	@Temporal(TemporalType.DATE)
	@Column(name="HORA_FIN")
	private Date horaFin;

	@Temporal(TemporalType.DATE)
	@Column(name="HORA_INICIO")
	private Date horaInicio;

	@Column(name="ID_PUESTO_TRABAJO")
	private Integer idPuestoTrabajo;

	@Column(name="ID_SALA")
	private Integer idSala;

	@Column(name="PARQUEADERO")
	private String parqueadero;

	@Column(name="PLACA")
	private String placa;

	@Column(name="PROYECTO")
	private String proyecto;

	@Column(name="TOTAL_HORAS")
	private Integer totalHoras;

	
}