package com.asesoftware.reservas.api.reservas.entity;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;



/**
 * The persistent class for the SALA database table.
 * 
 */
@Data
@Entity
@Table(name="SALA")
public class SalaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SEQ_SALA", sequenceName="SEQ_SALA", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_SALA")
	@Column(name="ID_SALA")
	private Integer idSala;

	@Column(name="AFORO_MAX")
	private Integer aforoMax;

	@Column(name="DOMINIO_ESTADO")
	private String dominioEstado;

	@ManyToOne
    @JoinColumn(name = "ID_PISO")
    private PisoEntity pisoEntity;

	@Column(name="NOMBRE")
	private String nombre;

	
}