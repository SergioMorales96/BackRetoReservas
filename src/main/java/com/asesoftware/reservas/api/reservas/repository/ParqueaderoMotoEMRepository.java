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
public class ParqueaderoMotoEMRepository {
    private static final Logger logger = LoggerFactory.getLogger(ParqueaderoMotoEMRepository.class);
    
	private final EntityManager entityManager;
	
	@Autowired
	public ParqueaderoMotoEMRepository(final EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public Integer getDisponibilidadParqueaderoMoto(Date fechaDisponible) {
		logger.info("entro a funcion parqueomoto ");
		StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery("PR_DIS_PAR_MOTO")
				.registerStoredProcedureParameter("IN_FECHA", Date.class, ParameterMode.IN)
				.setParameter("IN_FECHA", fechaDisponible)
				.registerStoredProcedureParameter("PARQUEADERO_DISPONIBLE", Integer.class, ParameterMode.OUT);
		
		Integer resultado = (Integer) storedProcedureQuery.getOutputParameterValue("PARQUEADERO_DISPONIBLE");
		logger.info("La disponibilidad de parqueo de carros para la fecha {} son {}", fechaDisponible, resultado);
		
		return resultado;
	}
	
}
