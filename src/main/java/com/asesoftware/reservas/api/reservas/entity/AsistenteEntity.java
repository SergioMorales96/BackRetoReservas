package com.asesoftware.reservas.api.reservas.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;


/**
 * The persistent class for the ASISTENTES database table.
 * 
 */
@Data
@Entity
@Table(name="ASISTENTES")
public class AsistenteEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SEQ_ASISTENTES", sequenceName="SEQ_ASISTENTES", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_ASISTENTES")
	@Column(name="ID_ASISTENTE")
	private Integer idAsistente;
	
	@Column(name="EMAIL_ASISTENTE")
	private String emailAsistente;

	@Column(name="NUMERO_RESERVA")
	private Integer numeroReserva;

	
}