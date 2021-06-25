package com.asesoftware.reservas.api.reservas.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.asesoftware.reservas.api.reservas.dto.EmpresaDTO;
import com.asesoftware.reservas.api.reservas.entity.EmpresaEntity;

@Mapper(componentModel = "spring")
public interface IEmpresaMapper {

	public EmpresaEntity dtoToEntity(EmpresaDTO dto);
	
	public EmpresaDTO entityToDto(EmpresaEntity entity);
	
	public List<EmpresaEntity> dtosToEntitys(List<EmpresaDTO> dtos);
	
	public List<EmpresaDTO> entitysToDtos(List<EmpresaEntity> entitys);
	
}
