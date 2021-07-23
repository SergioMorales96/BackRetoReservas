package com.asesoftware.reservas.api.reservas.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.asesoftware.reservas.api.reservas.entity.ReservaEntity;

public interface IReservasRepository extends JpaRepository<ReservaEntity, Integer> {

	@Modifying
	@Transactional
	@Query("UPDATE ReservaEntity r SET r.dominioEstado = 'C' WHERE r.numeroReserva = ?1")
	void cancelarReserva(Integer id);

}
