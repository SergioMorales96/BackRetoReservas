package com.asesoftware.reservas.api.reservas.service;
import com.asesoftware.reservas.api.reservas.dto.ResponseDTO;
import com.asesoftware.reservas.api.reservas.dto.SucursalDTO;

public interface ISucursalService {

	public ResponseDTO getAll();
	
	public ResponseDTO getSucursalById(Integer id);

	public ResponseDTO createSucursal(SucursalDTO sucursalDTO);

	public ResponseDTO updateSucursal(SucursalDTO sucursalDTO);
	
	public ResponseDTO deleteSucursal(Integer id);

}
