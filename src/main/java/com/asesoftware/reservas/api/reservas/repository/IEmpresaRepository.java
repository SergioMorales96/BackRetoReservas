package com.asesoftware.reservas.api.reservas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asesoftware.reservas.api.reservas.entity.EmpresaEntity;

public interface IEmpresaRepository extends JpaRepository<EmpresaEntity, String>{

}
