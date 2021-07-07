package com.asesoftware.reservas.api.reservas.service;

import java.util.List;

import com.asesoftware.reservas.api.reservas.dto.DominioDTO;
import com.asesoftware.reservas.api.reservas.dto.ResponseDTO;
import com.asesoftware.reservas.api.reservas.entity.DominioEntity;

public interface IDominioService {
	
	public ResponseDTO createDominio(DominioDTO dominioDTO);
	
	public ResponseDTO readDominioByCodDomi(String codigoDominio);
	
	public ResponseDTO readDominio();
	
	public ResponseDTO updateDominio(DominioDTO dominioDTO);
	
	public ResponseDTO deleteDominio(DominioDTO dominioDTO);
}
