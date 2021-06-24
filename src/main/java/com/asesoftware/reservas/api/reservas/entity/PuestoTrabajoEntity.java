package com.asesoftware.reservas.api.reservas.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;


/**
 * The persistent class for the PUESTO_TRABAJO database table.
 * 
 */
@Data
@Entity
@Table(name="PUESTO_TRABAJO")
public class PuestoTrabajoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SEQ_PUESTO_TRABAJO", sequenceName="SEQ_PUESTO_TRABAJO", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_PUESTO_TRABAJO")
	@Column(name="ID_PUESTO_TRABAJO")
	private Integer idPuestoTrabajo;

	@Column(name="DOMINIO_ESTADO")
	private String dominioEstado;

	@Column(name="DOMINIO_TIPO")
	private String dominioTipo;

	@Column(name="ID_PISO")
	private Integer idPiso;

	@Column(name="NOMBRE")
	private String nombre;

	
}