package com.asesoftware.reservas.api.reservas.repository;

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

import com.asesoftware.reservas.api.reservas.dto.ReservasPTDiaDTO;

@Repository
public class ReservasPorDiaRepository {

	private static final Logger logger = LoggerFactory.getLogger(ReservasPorDiaRepository.class);
	
	private final EntityManager entityManager;
	
	@Autowired
	public ReservasPorDiaRepository(final EntityManager entityManager) {
		this.entityManager = entityManager;
	}
		
	@SuppressWarnings("unchecked")
	public List<ReservasPTDiaDTO> getReservaPTDia(Date fechaReserva ) {
		
		StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery("PR_RESERVAS_DIA_PT")
				.registerStoredProcedureParameter("p_fFecha", String.class, ParameterMode.IN)
				.setParameter("p_fFecha", fechaReserva);
		
		List<Object[]> listReservas = (List)storedProcedureQuery.getResultList();
		
		
		List<ReservasPTDiaDTO> dataDTOs = listReservas.stream()
				.map(datos-> new ReservasPTDiaDTO(
						(String)datos[0], (Integer)datos[1], (Date)datos[2], (Date)datos[3], (Date)datos[4], (Character)datos[5],
						(Integer)datos[6], (String)datos[7], (Integer)datos[8], (String)datos[9], (String)datos[10], (String)datos[11]))
				.collect(Collectors.toList());
		
		logger.info("Las reservas para la fecha {} son {}", fechaReserva, dataDTOs);
		
		return dataDTOs;
	}
	
	
	
}