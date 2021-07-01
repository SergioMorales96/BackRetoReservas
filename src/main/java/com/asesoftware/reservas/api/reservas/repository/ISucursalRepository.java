package com.asesoftware.reservas.api.reservas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.asesoftware.reservas.api.reservas.entity.SucursalEntity;

public interface ISucursalRepository extends JpaRepository<SucursalEntity, Integer>{

}
