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

import com.asesoftware.reservas.api.reservas.dto.CalendarioPuestoDTO;

@Repository
public class CalendarioPuestoRepository {
	
	private static final Logger logger = LoggerFactory.getLogger(CalendarioPuestoRepository.class);
	
	private final EntityManager entityManager;
	
	
	@Autowired
	public CalendarioPuestoRepository(final EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	
	/**
	* Consulta calendario de un puesto utilizando el procedimiento almacenado
	* @author acmoya
	* @version 0.1, 12/07/2021
	*/
	@SuppressWarnings("unchecked")
	public List<CalendarioPuestoDTO> getCalendarioPuesto(Integer id, Date fechaInicio, Date fechaFin  ) {
		
		logger.info("Ingreso al metodo getCalendarioPuesto() id {} fechaInicio {} fechaFin {}", id, fechaInicio, fechaFin);
		
		StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery("PR_CON_CALENDARIO_PUESTOS")
				.registerStoredProcedureParameter("IN_FECHA", Date.class, ParameterMode.IN)
				.setParameter("IN_FECHA", fechaInicio)
				.registerStoredProcedureParameter("OUT_FECHA", Date.class, ParameterMode.IN)
				.setParameter("OUT_FECHA", fechaFin)
				.registerStoredProcedureParameter("IN_PUESTO", Integer.class, ParameterMode.IN)
				.setParameter("IN_PUESTO", id)
				.registerStoredProcedureParameter("RESULTADOS", CalendarioPuestoDTO.class, ParameterMode.REF_CURSOR);

		List<Object[]> listObjects = storedProcedureQuery.getResultList();


		return listObjects.stream()
				.map(datos-> new CalendarioPuestoDTO(((BigDecimal) datos[0]).intValue(), (Date) datos[1], (Date) datos[2], (Date) datos[3]))
				.collect(Collectors.toList());

		
	}

}
