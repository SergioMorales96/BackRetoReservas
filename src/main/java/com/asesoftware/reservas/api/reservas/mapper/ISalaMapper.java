package com.asesoftware.reservas.api.reservas.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.asesoftware.reservas.api.reservas.dto.SalaDTO;
import com.asesoftware.reservas.api.reservas.entity.SalaEntity;

@Mapper(componentModel = "spring")
public interface ISalaMapper {
	
	@Mapping(target = "pisoEntity.nombre",source = "nombrePiso")
	@Mapping(target = "pisoEntity.idPiso",source = "idPiso")
	public SalaEntity dtoToEntity(SalaDTO dto);
	
	@Mapping(target = "nombrePiso",source = "pisoEntity.nombre")
	@Mapping(target = "idPiso",source = "pisoEntity.idPiso")
	public SalaDTO entityToDto(SalaEntity entity);
	
	public List<SalaEntity> dtosToEntitys(List<SalaDTO> dtos);
	
	public List<SalaDTO> entitysToDtos(List<SalaEntity> entitys);

}
