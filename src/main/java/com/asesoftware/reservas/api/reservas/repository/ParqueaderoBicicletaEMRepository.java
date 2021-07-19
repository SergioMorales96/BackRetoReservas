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
* Clase DisponibilidadParqueaderoBicis para usar el SP PR_DIS_PAR_BICICLETA
* @author jortizg
* @version 0.1, 2021/07/08
*/
@Repository
public class ParqueaderoBicicletaEMRepository {
	
	private static final Logger logger = LoggerFactory.getLogger(ParqueaderoBicicletaEMRepository.class);
	
	private final EntityManager entityManager;
	
	@Autowired
	public ParqueaderoBicicletaEMRepository(final EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	/**
	* Servicio getDisponibilidadParqueaderoBicis para usar el SP PR_DIS_PAR_BICICLETA
	* @author jortizg
	* @version 0.1, 2021/07/08
	*/
	public Integer getDisponibilidadParqueaderoBicis(Date fechaDisponible) {
		
		StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery("PR_DIS_PAR_BICICLETA")
				.registerStoredProcedureParameter("IN_FECHA", Date.class, ParameterMode.IN)
				.setParameter("IN_FECHA", fechaDisponible)
				.registerStoredProcedureParameter("RESULTADO", Integer.class, ParameterMode.OUT);
		
		Integer resultado = (Integer) storedProcedureQuery.getOutputParameterValue("RESULTADO");
		
		logger.info("La disponibilidad de parqueo de bicicletas para la fecha {} son {}", fechaDisponible, resultado);
		
		return resultado;
	}
}
