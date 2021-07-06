package com.asesoftware.reservas.api.reservas.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.asesoftware.reservas.api.reservas.entity.SucursalEntity;

public interface ISucursalRepository extends JpaRepository<SucursalEntity, Integer>{
	
	/**
	* Método consultar Sucursal por Empresa
	* @author jcanizales
	* @version 0.1, 2021/07/06
	*/
	
	List<SucursalEntity> findByEmpresaEntityNit(String nit);
	
}
