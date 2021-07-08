package com.asesoftware.reservas.api.reservas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.asesoftware.reservas.api.reservas.entity.SalaEntity;

public interface ISalaRepository extends JpaRepository<SalaEntity, Integer>{
	
	/*
	* Método para obtener el las salas por piso de la base de datos usando la anotación @Query
	* @author jlucero
	* @version 0.1, 2021/07/08
	*/
	
	/* Nativa
	@Query(value = "SELECT s.id_sala, s.nombre, s.aforo_max, s.id_piso, s.dominio_estado "+
			"FROM Sala s, Piso p "+
			"WHERE s.id_piso = p.id_piso and p.id_piso = ?1", nativeQuery = true)
	*/
	
	@Query(value = "SELECT s "+
			"FROM SalaEntity s, PisoEntity p "+
			"WHERE s.pisoEntity.idPiso = p.idPiso and p.idPiso = ?1")
	
	List<SalaEntity> getSalasByPiso(@Param("id_piso") Integer id);
}
