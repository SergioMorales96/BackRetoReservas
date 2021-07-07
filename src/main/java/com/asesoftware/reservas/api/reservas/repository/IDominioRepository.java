package com.asesoftware.reservas.api.reservas.repository;



import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.asesoftware.reservas.api.reservas.entity.DominioEntity;
import com.asesoftware.reservas.api.reservas.entity.DominioPK;

public interface IDominioRepository extends JpaRepository<DominioEntity, DominioPK>{
	
	
	@Modifying
	@Transactional 
	@Query("UPDATE DominioEntity u SET u.dominioPK.valorDominio = ?1 WHERE u.dominioPK.codigoDominio = ?2 AND u.descripcion = ?3")
	void queryDominioUpdate(String valorDominio,String codigoDominio, String descripcion);


	@Modifying
	@Transactional 
	@Query("DELETE FROM DominioEntity u WHERE u.dominioPK.valorDominio = ?1 AND u.dominioPK.codigoDominio = ?2 AND u.descripcion = ?3")
	void queryDominioDelete(String valorDominio,String codigoDominio, String descripcion);


}
