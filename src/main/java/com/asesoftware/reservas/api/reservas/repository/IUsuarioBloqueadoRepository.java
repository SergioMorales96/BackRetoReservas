package com.asesoftware.reservas.api.reservas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asesoftware.reservas.api.reservas.entity.UsuarioBloqueadoEntity;



public interface IUsuarioBloqueadoRepository extends JpaRepository<UsuarioBloqueadoEntity, Integer> {
	
	public List<UsuarioBloqueadoEntity> findByEmail(String correo);
	public List<UsuarioBloqueadoEntity> findBySucursalEntityIdSucursal(Integer id);
	
}
