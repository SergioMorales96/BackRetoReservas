package com.asesoftware.reservas.api.reservas.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.asesoftware.reservas.api.reservas.dto.HorarioPuestoTrabajoDTO;
import com.asesoftware.reservas.api.reservas.entity.HorarioPuestoTrabajoEntity;

/**
 * Esta interfaz contiene metodos para castear diferentes arreglos de objetos de
 * la clase HorarioPuestoTrabajoEntity a la clase HorarioPuestoTrabajoDto o
 * viceversa
 * 
 * @author jrondon
 *
 */

@Mapper(componentModel = "spring")
public interface IHorarioPuestoTrabajoMapper {

	@Mapping(target = "sucursalEntity.nombre",source = "nombreSucursal")
	@Mapping(target = "sucursalEntity.idSucursal",source = "idSucursal")
	public HorarioPuestoTrabajoEntity dtoToEntity(HorarioPuestoTrabajoDTO dto);

	@Mapping(target = "nombreSucursal",source = "sucursalEntity.nombre")
	@Mapping(target = "idSucursal",source = "sucursalEntity.idSucursal")
	public HorarioPuestoTrabajoDTO entityToDto(HorarioPuestoTrabajoEntity entity);

	public List<HorarioPuestoTrabajoEntity> dtosToEntitys(List<HorarioPuestoTrabajoDTO> dtos);

	public List<HorarioPuestoTrabajoDTO> entitysToDtos(List<HorarioPuestoTrabajoEntity> entitys);

}
