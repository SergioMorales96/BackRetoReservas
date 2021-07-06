package com.asesoftware.reservas.api.reservas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asesoftware.reservas.api.reservas.entity.SalaEntity;

public interface ISalaRepository extends JpaRepository<SalaEntity, Integer>{

}
