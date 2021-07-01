package com.asesoftware.reservas.api.reservas.mapper;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ISucursalMapper {

	public SucursalEntity dtoToEntity(SucursalDTO sucursalDTO);

	public SucursalDTO entityToDto(SucursalEntity sucursalEntity);

	public List<SucursalDTO> listEntityToDto(List<SucursalEntity> sucursalEntity);

	public List<SucursalEntity> listdtoToEntity(List<SucursalDTO> sucursalDTO);

}
