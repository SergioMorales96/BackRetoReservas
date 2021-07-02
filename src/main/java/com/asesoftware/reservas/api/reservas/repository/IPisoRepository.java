package com.asesoftware.reservas.api.reservas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.asesoftware.reservas.api.reservas.entity.PisoEntity;


public interface IPisoRepository extends JpaRepository<PisoEntity, Integer>{
	
	
		@Query("SELECT t FROM PisoEntity t WHERE t.numeroPiso = ?1  ")
		 public List<PisoEntity> queryPorPiso(Integer piso);
		
}
