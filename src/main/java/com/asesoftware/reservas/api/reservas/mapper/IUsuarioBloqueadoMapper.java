package com.asesoftware.reservas.api.reservas.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.asesoftware.reservas.api.reservas.dto.UsuarioBloqueadoDTO;
import com.asesoftware.reservas.api.reservas.entity.UsuarioBloqueadoEntity;


@Mapper(componentModel = "spring")
public interface IUsuarioBloqueadoMapper {
	
	@Mapping(target = "sucursalEntity.nombre",source = "nombreSucursal")
	@Mapping(target = "sucursalEntity.idSucursal",source = "idSucursal")
	public UsuarioBloqueadoEntity dtoToEntity(UsuarioBloqueadoDTO dto);
	
	@Mapping(target = "nombreSucursal",source = "sucursalEntity.nombre")
	@Mapping(target = "idSucursal",source = "sucursalEntity.idSucursal")
	public UsuarioBloqueadoDTO entityToDto(UsuarioBloqueadoEntity entity);
	
	public List<UsuarioBloqueadoEntity> dtosToEntitys(List<UsuarioBloqueadoDTO> dtos);
	
	public List<UsuarioBloqueadoDTO> entitysToDtos(List<UsuarioBloqueadoEntity> entitys);
	
}
