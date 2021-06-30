package com.asesoftware.reservas.api.reservas.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

/**
 * The persistent class for the HORARIO_PUESTO_TRABAJO database table.
 * 
 */
@Data
@Entity
@Table(name = "HORARIO_PUESTO_TRABAJO")
public class HorarioPuestoTrabajoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "SEQ_HORARIO", sequenceName = "SEQ_HORARIO", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_HORARIO")
	@Column(name = "ID_HORARIO")
	private Integer idHorario;

	@Temporal(TemporalType.DATE)
	@Column(name = "HORA_FIN")
	private Date horaFin;

	@Temporal(TemporalType.DATE)
	@Column(name = "HORA_INICIO")
	private Date horaInicio;

	@Column(name = "ID_SUCURSAL")
	private Integer idSucursal;

	@Column(name = "NOMBRE")
	private String nombre;

	@Column(name = "NUMERO_HORAS")
	private Integer numeroHoras;

}