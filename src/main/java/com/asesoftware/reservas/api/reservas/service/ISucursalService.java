package com.asesoftware.reservas.api.reservas.service;
import com.asesoftware.reservas.api.reservas.dto.ResponseDTO;
import com.asesoftware.reservas.api.reservas.dto.SucursalDTO;

public interface ISucursalService {

	public ResponseDTO getAll();
	
	public ResponseDTO getSucursalById(Integer id);

	public ResponseDTO crearSucursal(SucursalDTO sucursalDTO);

	public ResponseDTO editarSucursal(SucursalDTO sucursalDTO);
	
	public ResponseDTO eliminarSucursal(Integer id);

}
