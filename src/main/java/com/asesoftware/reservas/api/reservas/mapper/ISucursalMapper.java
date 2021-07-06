package com.asesoftware.reservas.api.reservas.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.asesoftware.reservas.api.reservas.dto.SucursalDTO;
import com.asesoftware.reservas.api.reservas.entity.SucursalEntity;

@Mapper(componentModel = "spring")
public interface ISucursalMapper {

	
	@Mapping(target = "empresaEntity.nombre",source = "nombreEmpresa")
	@Mapping(target = "empresaEntity.nit",source = "nit")
	public SucursalEntity dtoToEntity(SucursalDTO sucursalDTO);

	
	@Mapping(target = "nombreEmpresa",source = "empresaEntity.nombre")
	@Mapping(target = "nit",source = "empresaEntity.nit")
	public SucursalDTO entityToDto(SucursalEntity sucursalEntity);

	public List<SucursalDTO> listEntityToDto(List<SucursalEntity> sucursalEntity);

	public List<SucursalEntity> listdtoToEntity(List<SucursalDTO> sucursalDTO);

}
