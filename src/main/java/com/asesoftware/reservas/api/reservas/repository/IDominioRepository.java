package com.asesoftware.reservas.api.reservas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asesoftware.reservas.api.reservas.entity.DominioEntity;
import com.asesoftware.reservas.api.reservas.entity.DominioPK;

public interface IDominioRepository extends JpaRepository<DominioEntity, DominioPK>{
	

}
