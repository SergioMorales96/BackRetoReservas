package com.asesoftware.reservas.api.reservas.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import com.asesoftware.reservas.api.reservas.dto.PuestoTrabajoDTO;
import com.asesoftware.reservas.api.reservas.entity.PuestoTrabajoEntity;

@Mapper(componentModel = "spring")
public interface IPuestoTrabajoMapper {
	
	
	public PuestoTrabajoEntity dtoToEntity(PuestoTrabajoDTO dto);
	
	public PuestoTrabajoDTO entityToDto(PuestoTrabajoEntity entity);
	
	public List<PuestoTrabajoEntity> dtosToEntitys(List<PuestoTrabajoDTO> dtos);
	
	public List<PuestoTrabajoDTO> entitysToDtos(List<PuestoTrabajoEntity> entitys);

}
