package com.asesoftware.reservas.api.reservas.service;

import org.springframework.stereotype.Service;

import com.asesoftware.reservas.api.reservas.dto.ResponseDTO;

@Service
public interface IPisoService {
	public ResponseDTO pisoPorIdSucursal(Integer idSucursal);
}
