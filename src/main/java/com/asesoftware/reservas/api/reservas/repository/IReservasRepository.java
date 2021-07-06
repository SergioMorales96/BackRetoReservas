package com.asesoftware.reservas.api.reservas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asesoftware.reservas.api.reservas.entity.ReservaEntity;

public interface IReservasRepository extends JpaRepository<ReservaEntity, Integer>{

}
