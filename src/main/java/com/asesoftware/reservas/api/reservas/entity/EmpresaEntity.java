package com.asesoftware.reservas.api.reservas.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;


/**
 * The persistent class for the EMPRESA database table.
 * 
 */
@Data
@Entity
@Table(name="EMPRESA")
public class EmpresaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="NIT")
	private String nit;

	@Column(name="ALIAS")
	private String alias;

	@Column(name="CODIGO_VERIFICACION")
	private String codigoVerificacion;

	@Column(name="NOMBRE")
	private String nombre;

	

}