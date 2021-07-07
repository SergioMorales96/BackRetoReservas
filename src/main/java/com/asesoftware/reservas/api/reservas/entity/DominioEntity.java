package com.asesoftware.reservas.api.reservas.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;


/**
 * The persistent class for the DOMINIO database table.
 * 
 */
@Data
@Entity
@Table(name="DOMINIO")
public class DominioEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DominioPK dominioPK;

	@Column(name="DESCRIPCION")
	private String descripcion;

	

}