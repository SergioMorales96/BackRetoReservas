package com.asesoftware.reservas.api.reservas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.asesoftware.reservas.api.reservas.entity.PisoEntity;


public interface IPisoRepository extends JpaRepository<PisoEntity, Integer>{
	
		@Query(nativeQuery = true , value = "Select * from PISO  WHERE numero_piso= :piso")
		List<PisoEntity>     queryPorPiso(@Param("piso") Integer piso);
}
