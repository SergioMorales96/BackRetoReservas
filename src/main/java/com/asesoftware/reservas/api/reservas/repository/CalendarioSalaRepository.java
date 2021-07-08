package com.asesoftware.reservas.api.reservas.repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.asesoftware.reservas.api.reservas.dto.CalendarioSalaDTO;



@Repository
public class CalendarioSalaRepository {
	
	
	private static final Logger logger = LoggerFactory.getLogger(CalendarioSalaRepository.class);
	
	private final EntityManager entityManager;
	
	
	@Autowired
	public CalendarioSalaRepository(final EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	
	/**
	* Consulta calendario de una sala haciendo uso del procedimiento almacenado
	* @author ajgutierrez
	* @version 0.1, 2021/07/08
	*/
	@SuppressWarnings("unchecked")
	public List<CalendarioSalaDTO> getCalendarioSala(Integer id, Date fechaInicio, Date fechaFin  ) {
		
		logger.info("getCalendarioSala() id {} fechaInicio {} fechaFin {}", id, fechaInicio, fechaFin);
		
		StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery("PR_CONSULTAR_CALENDARIO_SALA")
				.registerStoredProcedureParameter("IN_FECHA", Date.class, ParameterMode.IN)
				.setParameter("IN_FECHA", fechaInicio)
				.registerStoredProcedureParameter("FN_FECHA", Date.class, ParameterMode.IN)
				.setParameter("FN_FECHA", fechaFin)
				.registerStoredProcedureParameter("IN_SALA", Integer.class, ParameterMode.IN)
				.setParameter("IN_SALA", id)
				.registerStoredProcedureParameter("RESULTADOS", CalendarioSalaDTO.class, ParameterMode.REF_CURSOR);

		List<Object[]> listObjects = storedProcedureQuery.getResultList();


		List<CalendarioSalaDTO> dataDTOs = listObjects.stream()
				.map(datos-> new CalendarioSalaDTO(((BigDecimal) datos[0]).intValue(), (Date) datos[1], (Date) datos[2], (Date) datos[3]))
				.collect(Collectors.toList());

		return dataDTOs;
	}
	
}
