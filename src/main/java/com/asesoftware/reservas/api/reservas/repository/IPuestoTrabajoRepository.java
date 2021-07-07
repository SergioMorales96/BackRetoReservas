package com.asesoftware.reservas.api.reservas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asesoftware.reservas.api.reservas.entity.PuestoTrabajoEntity;

public interface IPuestoTrabajoRepository extends JpaRepository<PuestoTrabajoEntity, Integer>{
	
	/**
	* Método consultar puestos de trabajo por piso
	* @author jcanizales
	* @version 0.1, 2021/07/07
	*/
	
	public List<PuestoTrabajoEntity> findByPisoEntityIdPiso(Integer idPiso);
	
	

}
