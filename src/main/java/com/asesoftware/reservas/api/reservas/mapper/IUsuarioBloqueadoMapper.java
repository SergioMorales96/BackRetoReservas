package com.asesoftware.reservas.api.reservas.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.asesoftware.reservas.api.reservas.dto.UsuarioBloqueadoDTO;
import com.asesoftware.reservas.api.reservas.entity.UsuarioBloqueadoEntity;


@Mapper(componentModel = "spring")
public interface IUsuarioBloqueadoMapper {
	
	
	
	public UsuarioBloqueadoEntity dtoToEntity(UsuarioBloqueadoDTO dto);
	
	public UsuarioBloqueadoDTO entityToDto(UsuarioBloqueadoEntity entity);
	
	public List<UsuarioBloqueadoEntity> dtosToEntitys(List<UsuarioBloqueadoDTO> dtos);
	
	public List<UsuarioBloqueadoDTO> entitysToDtos(List<UsuarioBloqueadoEntity> entitys);
	
}
