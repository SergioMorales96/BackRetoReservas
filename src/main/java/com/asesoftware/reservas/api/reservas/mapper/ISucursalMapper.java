package com.asesoftware.reservas.api.reservas.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import com.asesoftware.reservas.api.reservas.dto.SucursalDTO;
import com.asesoftware.reservas.api.reservas.entity.SucursalEntity;

@Mapper(componentModel = "spring")
public interface ISucursalMapper {

	public SucursalEntity dtoToEntity(SucursalDTO sucursalDTO);

	public SucursalDTO entityToDto(SucursalEntity sucursalEntity);

	public List<SucursalDTO> listEntityToDto(List<SucursalEntity> sucursalEntity);

	public List<SucursalEntity> listdtoToEntity(List<SucursalDTO> sucursalDTO);

}
