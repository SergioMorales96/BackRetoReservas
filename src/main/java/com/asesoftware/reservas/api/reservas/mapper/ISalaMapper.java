package com.asesoftware.reservas.api.reservas.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.asesoftware.reservas.api.reservas.dto.SalaDTO;
import com.asesoftware.reservas.api.reservas.entity.SalaEntity;

@Mapper(componentModel = "spring")
public interface ISalaMapper {
	
	public SalaEntity dtoToEntity(SalaDTO dto);
	
	public SalaDTO entityToDto(SalaEntity entity);
	
	public List<SalaEntity> dtosToEntitys(List<SalaDTO> dtos);
	
	public List<SalaDTO> entitysToDtos(List<SalaEntity> entitys);

}
