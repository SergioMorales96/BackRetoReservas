package com.asesoftware.reservas.api.reservas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.asesoftware.reservas.api.reservas.entity.UsuarioAdministradorEntity;

public interface IUsuarioAdministradorRepository extends JpaRepository<UsuarioAdministradorEntity, Integer>{
	
	@Query("SELECT t from UsuarioAdministradorEntity t WHERE t.idSucursal = ?1")
	List<UsuarioAdministradorEntity> queryAdminPorSucursal(Integer idSucursal);

}
