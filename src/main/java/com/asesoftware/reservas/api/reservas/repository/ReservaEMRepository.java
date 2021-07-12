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

import com.asesoftware.reservas.api.reservas.dto.ReservasPTDiaSPDTO;
import com.asesoftware.reservas.api.reservas.dto.ReservasSDiaSPDTO;

/**
* Clase ReservasPorDiaRepository para usar el SP PR_RESERVAS_DIA_PT
* @author jcanizales
* @version 0.1, 2021/07/06
*/

@Repository
public class ReservaEMRepository {

	private static final Logger logger = LoggerFactory.getLogger(ReservaEMRepository.class);
	
	private final EntityManager entityManager;
	
	@Autowired
	public ReservaEMRepository(final EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public List<ReservasPTDiaSPDTO> getReservaPTDia(Date fechaReserva) {
		
		StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery("PR_RESERVAS_DIA_PT")
				.registerStoredProcedureParameter("p_fFecha", Date.class, ParameterMode.IN) //Dato de entrada
				.setParameter("p_fFecha", fechaReserva)
				.registerStoredProcedureParameter("OUT_DATA", ReservasPTDiaSPDTO.class, ParameterMode.REF_CURSOR);
		
		//Ejecuta el metodo que retorna una lista de objetos
		@SuppressWarnings("unchecked")
		List<Object[]> listReservas = storedProcedureQuery.getResultList(); 
			
		//se pasa a dto
		List<ReservasPTDiaSPDTO> dataDTOs = listReservas.stream()
				.map(datos -> new ReservasPTDiaSPDTO(
						(String)datos[0], 
						((BigDecimal)datos[1]).intValueExact(), 
						(Date)datos[2], 
						(Date)datos[3], 
						(Date)datos[4], 
						(String)datos[5], 
						((BigDecimal)datos[6]).intValueExact(), 
						(String)datos[7], 
						((BigDecimal)datos[8]).intValueExact(), 
						(String)datos[9], 
						(String)datos[10], 
						(String)datos[11])
				)
				.collect(Collectors.toList());
		
		logger.info("Las reservas para la fecha {} son {}", fechaReserva, dataDTOs);
		
		return dataDTOs;
	}
	
	/**
	* Método para usar el procedimiento almacenado SP_CONSULTA_RESERVAS_SALAS_DIA
	* @author wsierra
	* @version 0.1, 2021/07/09
	*/
	
	public List<ReservasSDiaSPDTO> getReservaSDia(Date fechaReservaS) {
		
		StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery("PR_CON_RESERVAS_SALAS_DIA")
				.registerStoredProcedureParameter("in_fecha", Date.class, ParameterMode.IN) //Dato de entrada
				.setParameter("in_fecha", fechaReservaS)
				.registerStoredProcedureParameter("resultados", ReservasSDiaSPDTO.class, ParameterMode.REF_CURSOR);
		
		//Ejecuta el metodo que retorna una lista de objetos
		@SuppressWarnings("unchecked")
		List<Object[]> listReservas = storedProcedureQuery.getResultList(); 
			
		//se pasa a dto
		List<ReservasSDiaSPDTO> dataDTOs = listReservas.stream()
				.map(datos -> new ReservasSDiaSPDTO(
						((BigDecimal)datos[0]).intValue(), 
						(Date)datos[1], 
						(Date)datos[2], 
						(Date)datos[3], 
						(String)datos[4], 
						(String)datos[5], 
						(String)datos[6],
						((BigDecimal)datos[7]).intValue())
				)
				.collect(Collectors.toList());
		
		logger.info("Las reservas de salas para la fecha {} son {}", fechaReservaS, dataDTOs);
		
		return dataDTOs;
	}
}