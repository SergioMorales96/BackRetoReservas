package com.asesoftware.reservas.api.reservas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.asesoftware.reservas.api.reservas.entity.UsuarioAdministradorEntity;

public interface IUsuarioAdministradorRepository extends JpaRepository<UsuarioAdministradorEntity, Integer>{
	
	@Query(nativeQuery = true , value = "Select * from USUARIO_ADMINISTRADOR where id_sucursal = :id")
	List<UsuarioAdministradorEntity> queryAdminPorSucursal(@Param("id") Integer idSucursal);

}
