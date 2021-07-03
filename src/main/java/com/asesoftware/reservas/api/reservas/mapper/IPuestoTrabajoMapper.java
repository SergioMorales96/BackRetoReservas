package com.asesoftware.reservas.api.reservas.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.asesoftware.reservas.api.reservas.dto.PuestoTrabajoDTO;
import com.asesoftware.reservas.api.reservas.entity.PuestoTrabajoEntity;

@Mapper(componentModel = "spring")
public interface IPuestoTrabajoMapper {
	
	@Mapping(target = "pisoEntity.nombre",source = "nombrePiso")
	@Mapping(target = "pisoEntity.idPiso",source = "idPiso")
	public PuestoTrabajoEntity dtoToEntity(PuestoTrabajoDTO dto);
	
	@Mapping(target = "nombrePiso",source = "pisoEntity.nombre")
	@Mapping(target = "idPiso",source = "pisoEntity.idPiso")
	public PuestoTrabajoDTO entityToDto(PuestoTrabajoEntity entity);
	
	public List<PuestoTrabajoEntity> dtosToEntitys(List<PuestoTrabajoDTO> dtos);
	
	public List<PuestoTrabajoDTO> entitysToDtos(List<PuestoTrabajoEntity> entitys);

}
