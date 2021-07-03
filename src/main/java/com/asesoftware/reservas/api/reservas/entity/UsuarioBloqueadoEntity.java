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
@Table(name="USUARIO_BLOQUEADO")
public class UsuarioBloqueadoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SEQ_USUARIO_BLOQUEADO", sequenceName="SEQ_USUARIO_BLOQUEADO", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_USUARIO_BLOQUEADO")
	@Column(name="ID_BLOQUEADO")
	private Integer idBloqueado;

	@Column(name="EMAIL")
	private String email;

	@ManyToOne
    @JoinColumn(name = "ID_SUCURSAL")
    private SucursalEntity sucursalEntity;

	

}