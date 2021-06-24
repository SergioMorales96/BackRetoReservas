package com.asesoftware.reservas.api.reservas.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;


/**
 * The persistent class for the USUARIO_ADMINISTRADOR database table.
 * 
 */
@Data
@Entity
@Table(name="USUARIO_ADMINISTRADOR")
public class UsuarioAdministradorEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SEQ_USUARIO_ADMINISTRADOR", sequenceName="SEQ_USUARIO_ADMINISTRADOR", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_USUARIO_ADMINISTRADOR")
	@Column(name="ID_ADMINISTRADOR")
	private Integer idAdministrador;

	@Column(name="EMAIL")
	private String email;

	@Column(name="ID_SUCURSAL")
	private Integer idSucursal;

	

}