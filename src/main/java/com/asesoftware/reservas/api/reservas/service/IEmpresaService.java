package com.asesoftware.reservas.api.reservas.service;

import com.asesoftware.reservas.api.reservas.dto.EmpresaDTO;
import com.asesoftware.reservas.api.reservas.dto.ResponseDTO;

public interface IEmpresaService {
	
	public ResponseDTO empresaPorId(String nit);
	public ResponseDTO consultarTodas();
	public ResponseDTO actualizarEmpresa(EmpresaDTO empresaDTO);
	
}