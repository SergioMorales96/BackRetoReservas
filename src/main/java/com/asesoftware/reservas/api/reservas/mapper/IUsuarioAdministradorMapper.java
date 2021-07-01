package com.asesoftware.reservas.api.reservas.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.asesoftware.reservas.api.reservas.dto.UsuarioAdministradorDTO;
import com.asesoftware.reservas.api.reservas.entity.UsuarioAdministradorEntity;

@Mapper(componentModel = "spring")
public interface IUsuarioAdministradorMapper {
	
	public UsuarioAdministradorEntity dtoToEntity(UsuarioAdministradorDTO dtoAdmin);
	
	public UsuarioAdministradorDTO entityToDto(UsuarioAdministradorEntity entityAdmin);
	
	public List<UsuarioAdministradorEntity> dtosToEntitys(List<UsuarioAdministradorDTO> dtosAdmin);
	
	public List<UsuarioAdministradorDTO> entitysToDtos(List<UsuarioAdministradorEntity> entitysAdmin);

}
