package com.asesoftware.reservas.api.reservas.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.asesoftware.reservas.api.reservas.dto.UsuarioAdministradorDTO;
import com.asesoftware.reservas.api.reservas.entity.UsuarioAdministradorEntity;

@Mapper(componentModel = "spring")
public interface IUsuarioAdministradorMapper {

	@Mapping(target = "sucursalEntity.nombre",source = "nombreSucursal")
	@Mapping(target = "sucursalEntity.idSucursal",source = "idSucursal")
	public UsuarioAdministradorEntity dtoToEntity(UsuarioAdministradorDTO dto);
	
	@Mapping(target = "nombreSucursal",source = "sucursalEntity.nombre")
	@Mapping(target = "idSucursal",source = "sucursalEntity.idSucursal")
	public UsuarioAdministradorDTO entityToDto(UsuarioAdministradorEntity entity);
	
	public List<UsuarioAdministradorEntity> dtosToEntitys(List<UsuarioAdministradorDTO> dtos);
	
	public List<UsuarioAdministradorDTO> entitysToDtos(List<UsuarioAdministradorEntity> entitys);
}
