package com.asesoftware.reservas.api.reservas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.asesoftware.reservas.api.reservas.entity.PisoEntity;

public interface IPisoRepository extends JpaRepository<PisoEntity, String>{

	//@Query(nativeQuery = true , value = "Select * from piso where id_sucursal = :id")
	//List<PisoEntity> queryPisoPorSucursal(@Param("id") Integer idSucursal);
	
	@Query("SELECT p FROM PisoEntity p WHERE p.idSucursal = ?1")
	List<PisoEntity> queryPisoPorSucursal(Integer idSucursal);
}













