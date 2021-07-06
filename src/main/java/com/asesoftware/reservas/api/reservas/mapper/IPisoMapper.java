package com.asesoftware.reservas.api.reservas.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.asesoftware.reservas.api.reservas.dto.PisoDTO;
import com.asesoftware.reservas.api.reservas.entity.PisoEntity;

@Mapper(componentModel = "spring")
public interface IPisoMapper {
	
	@Mapping(target = "sucursalEntity.nombre",source = "nombreSucursal")
	@Mapping(target = "sucursalEntity.idSucursal",source = "idSucursal")
	public PisoEntity dtoToEntity(PisoDTO dto);
	
	@Mapping(target = "nombreSucursal",source = "sucursalEntity.nombre")
	@Mapping(target = "idSucursal",source = "sucursalEntity.idSucursal")
	public PisoDTO entityToDto(PisoEntity entity);
	
	public List<PisoEntity> dtosToEntitys(List<PisoDTO> dtos);
	
	public List<PisoDTO> entitysToDtos(List<PisoEntity> entitys);
}
