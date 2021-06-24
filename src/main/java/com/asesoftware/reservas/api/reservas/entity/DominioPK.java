package com.asesoftware.reservas.api.reservas.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

/**
 * The primary key class for the DOMINIO database table.
 * 
 */

@Data
@Embeddable
public class DominioPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="CODIGO_DOMINIO")
	private String codigoDominio;
	
	@Column(name="VALOR_DOMINO")
	private String valorDomino;

	public DominioPK() {}
	
	public DominioPK( String codigoDominio,String valorDomino) {
		
		this.valorDomino = valorDomino;
		this.codigoDominio = codigoDominio;
	}
	
	

	
}