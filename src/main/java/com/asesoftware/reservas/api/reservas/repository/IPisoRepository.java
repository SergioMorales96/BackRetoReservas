package com.asesoftware.reservas.api.reservas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.asesoftware.reservas.api.reservas.entity.PisoEntity;


public interface IPisoRepository extends JpaRepository<PisoEntity, Integer>{

}
