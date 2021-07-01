package com.asesoftware.reservas.api.reservas.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.asesoftware.reservas.api.reservas.entity.UsuarioAdministradorEntity;


public interface IAdministradorRepository extends JpaRepository<UsuarioAdministradorEntity, Integer>{

	
	@Query("SELECT t FROM UsuarioAdministradorEntity t WHERE t.email = ?1")
	List<UsuarioAdministradorEntity> queryUsuarioAdminPorEmail(String email);
	
	
}
