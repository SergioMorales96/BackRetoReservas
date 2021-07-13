package com.asesoftware.reservas.api.reservas.repository;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AforoDiaRepository {
	
	private static final Logger logger = LoggerFactory.getLogger(AforoDiaRepository.class);
	
	private final EntityManager entityManager;

	@Autowired
	public AforoDiaRepository(final EntityManager entityManager) {
		this.entityManager=entityManager;
	}
	
	/**
	* Servicio getAforoDia para usar el SP PR_TOTALAFORO_PISO_DIA
	* @author nbarreto
	* @version 0.1, 2021/07/13
	*/
	public Integer getAforoDia(Date fechaDisponible,Integer idPiso) {
		
		StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery("PR_TOTALAFORO_PISO_DIA")
				.registerStoredProcedureParameter("IN_FECHA", Date.class, ParameterMode.IN)
				.setParameter("IN_FECHA", fechaDisponible)
				.registerStoredProcedureParameter("IN_PISO", Integer.class, ParameterMode.IN)
				.setParameter("IN_PISO", idPiso)
				.registerStoredProcedureParameter("AFORO_DISP", Integer.class, ParameterMode.OUT);
		
		Integer resultado = (Integer) storedProcedureQuery.getOutputParameterValue("AFORO_DISP");
		
		logger.info("El aforo del piso para la fecha {} es de {} personas", fechaDisponible, resultado);
		
		return resultado;
		
	}
}
