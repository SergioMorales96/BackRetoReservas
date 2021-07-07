package com.asesoftware.reservas.api.reservas.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.asesoftware.reservas.api.reservas.dto.DominioDTO;
import com.asesoftware.reservas.api.reservas.entity.DominioEntity;

@Mapper(componentModel = "spring")
public interface IDominioMapper {
	
	@Mappings({
		@Mapping(source = "codigoDominio",target = "dominioPK.codigoDominio"),
		@Mapping(source = "valorDominio",target = "dominioPK.valorDominio"),
		
	})
	
	public DominioEntity dtoToEntity(DominioDTO dto);
	
	@Mappings({
		@Mapping(source = "dominioPK.codigoDominio",target = "codigoDominio"),
		@Mapping(source = "dominioPK.valorDominio",target = "valorDominio"),
		
	})
	
	public DominioDTO entityToDto(DominioEntity entity);
	
	public List<DominioEntity> dtosToEntitys(List<DominioDTO> dtos);

	public List<DominioDTO> entitysToDtos(List<DominioEntity> entitys);
	
}
