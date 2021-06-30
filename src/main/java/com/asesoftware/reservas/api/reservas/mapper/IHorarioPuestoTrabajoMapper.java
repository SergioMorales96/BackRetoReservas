package com.asesoftware.reservas.api.reservas.mapper;

import java.util.List;

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
public interface IHorarioPuestoTrabajoMapper {

	public HorarioPuestoTrabajoEntity dtoToEntity(HorarioPuestoTrabajoDTO dto);

	public HorarioPuestoTrabajoDTO entityToDto(HorarioPuestoTrabajoEntity entity);

	public List<HorarioPuestoTrabajoEntity> dtosToEntitys(List<HorarioPuestoTrabajoDTO> dtos);

	public List<HorarioPuestoTrabajoDTO> entitysToDtos(List<HorarioPuestoTrabajoEntity> entitys);

}
