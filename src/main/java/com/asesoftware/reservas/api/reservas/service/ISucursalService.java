package com.asesoftware.reservas.api.reservas.service;
import com.asesoftware.reservas.api.reservas.dto.ResponseDTO;
import com.asesoftware.reservas.api.reservas.dto.SucursalDTO;

public interface ISucursalService {

	public ResponseDTO createSucursal(SucursalDTO sucursalDTO);

	public ResponseDTO updateSucursal(SucursalDTO sucursalDTO);
	
	public ResponseDTO getAll();
	
	public ResponseDTO deleteSucursal(Integer idSucursal);

}
