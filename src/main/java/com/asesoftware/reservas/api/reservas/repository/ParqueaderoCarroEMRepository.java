package com.asesoftware.reservas.api.reservas.repository;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
* Clase DisponibilidadParqueaderoCarro para usar el SP PR_CON_PARQUEADEROS_CARRO
* @author kpinilla
* @version 0.1, 2021/07/12
*/
@Repository
public class ParqueaderoCarroEMRepository {
	
	private static final Logger logger = LoggerFactory.getLogger(ParqueaderoCarroEMRepository.class);
	
	private final EntityManager entityManager;
	
	@Autowired
	public ParqueaderoCarroEMRepository(final EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	/**
	* Servicio getDisponibilidadParqueaderoCarro para usar el SP SP PR_CON_PARQUEADEROS_CARRO
	* @author kpinilla
	* @version 0.1, 2021/07/12
	*/
	public Integer getDisponibilidadParqueaderoCarro(Date fechaDisponible) {
		
		StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery("PR_CON_PARQUEADEROS_CARRO")
				.registerStoredProcedureParameter("IN_FECHA", Date.class, ParameterMode.IN)
				.setParameter("IN_FECHA", fechaDisponible)
				.registerStoredProcedureParameter("TOTAL_PARQ_DISPONIBLE", Integer.class, ParameterMode.OUT);
		
		Integer resultado = (Integer) storedProcedureQuery.getOutputParameterValue("TOTAL_PARQ_DISPONIBLE");
		
		logger.info("La disponibilidad de parqueo de carros para la fecha {} son {}", fechaDisponible, resultado);
		
		return resultado;
	}
}
