package com.asesoftware.reservas.api.reservas.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.asesoftware.reservas.api.reservas.dto.PisoDTO;
import com.asesoftware.reservas.api.reservas.entity.PisoEntity;

@Mapper(componentModel = "spring")
public interface IPisoMapper {
	
	public PisoEntity dtoToEntity(PisoDTO dto);
	
	public PisoDTO entityToDto(PisoEntity entity);
	
	public List<PisoEntity> dtosToEntitys(List<PisoDTO> dtos);
	
	public List<PisoDTO> entitysToDtos(List<PisoEntity> entitys);
}
