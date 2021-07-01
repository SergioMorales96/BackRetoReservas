package com.asesoftware.reservas.api.reservas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asesoftware.reservas.api.reservas.entity.UsuarioAdministradorEntity;

public interface IAdministradorRepository extends JpaRepository<UsuarioAdministradorEntity, Integer>{

}
