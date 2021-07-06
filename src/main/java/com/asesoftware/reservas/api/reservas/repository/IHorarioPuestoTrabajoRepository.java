package com.asesoftware.reservas.api.reservas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.asesoftware.reservas.api.reservas.entity.HorarioPuestoTrabajoEntity;

public interface IHorarioPuestoTrabajoRepository extends JpaRepository<HorarioPuestoTrabajoEntity, Integer> {

	@Query("SELECT h FROM HorarioPuestoTrabajoEntity h, SucursalEntity s WHERE h.idSucursal = s.idSucursal AND s.idSucursal = ?1")
	List<HorarioPuestoTrabajoEntity> queryHorarioPuestoTrabajoEntities(Integer idSucursal);
	
}
