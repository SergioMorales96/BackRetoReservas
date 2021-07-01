package com.asesoftware.reservas.api.reservas.service;

import com.asesoftware.reservas.api.reservas.dto.DominioDTO;
import com.asesoftware.reservas.api.reservas.dto.ResponseDTO;

public interface IDominioService {
	
	public ResponseDTO createDominio(DominioDTO dominioDTO);
	
	public ResponseDTO reloadDominio(DominioDTO dominioDTO);
	
	public ResponseDTO updateDominio(DominioDTO dominioDTO);
	
	public ResponseDTO deleteDominio(String dominioPK);
}
