package com.asesoftware.reservas.api.reservas.entity;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;



/**
 * The persistent class for the SUCURSAL database table.
 * 
 */
@Data
@Entity
@Table(name="SUCURSAL")
public class SucursalEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SEQ_SUCURSAL", sequenceName="SEQ_SUCURSAL", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_SUCURSAL")
	@Column(name="ID_SUCURSAL")
	private Integer idSucursal;

	@Column(name="AFORO_MAXIMO")
	private Integer aforoMaximo;

	@Column(name="DIRECCION")
	private String direccion;

	@Column(name="NOMBRE")
	private String nombre;
	
	@ManyToOne
    @JoinColumn(name = "NIT")
    private EmpresaEntity empresaEntity;
	

}