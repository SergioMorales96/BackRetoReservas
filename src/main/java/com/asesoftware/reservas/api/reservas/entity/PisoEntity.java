package com.asesoftware.reservas.api.reservas.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;


/**
 * The persistent class for the PISO database table.
 * 
 */
@Data
@Entity
@Table(name="PISO")
public class PisoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SEQ_PISO", sequenceName="SEQ_PISO", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_PISO")
	@Column(name="ID_PISO")
	private Integer idPiso;

	@Column(name="AFORO_MAXIMO")
	private Integer aforoMaximo;

	@Column(name="ID_SUCURSAL")
	private Integer idSucursal;

	@Column(name="NOMBRE")
	private String nombre;

	@Column(name="NUMERO_PISO")
	private Integer numeroPiso;

	

}