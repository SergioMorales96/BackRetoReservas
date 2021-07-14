package com.asesoftware.reservas.api.reservas.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.asesoftware.reservas.api.reservas.dto.ReservaDTO;
import com.asesoftware.reservas.api.reservas.entity.ReservaEntity;

@Mapper(componentModel = "spring")
public interface IReservaMapper {
	
	public ReservaEntity dtoToEntity(ReservaDTO dto);

	public ReservaDTO entityToDto(ReservaEntity entity);

	public List<ReservaEntity> dtosToEntitys(List<ReservaDTO> dtos);

	public List<ReservaDTO> entitysToDtos(List<ReservaEntity> entitys);

}
