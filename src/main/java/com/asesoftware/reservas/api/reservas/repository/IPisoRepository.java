package com.asesoftware.reservas.api.reservas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.asesoftware.reservas.api.reservas.entity.PisoEntity;

public interface IPisoRepository extends JpaRepository<PisoEntity, String>{
	
	@Query("SELECT p FROM PisoEntity p WHERE p.idSucursal = ?1")
	List<PisoEntity> queryPisoPorSucursal(Integer idSucursal);
}













