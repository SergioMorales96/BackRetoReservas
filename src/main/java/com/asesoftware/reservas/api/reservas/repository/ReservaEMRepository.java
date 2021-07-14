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

import com.asesoftware.reservas.api.reservas.dto.ReservaAddDTO;
import com.asesoftware.reservas.api.reservas.dto.ReservasPTDiaSPDTO;
import com.asesoftware.reservas.api.reservas.dto.ReservasSDiaSPDTO;
import com.asesoftware.reservas.api.reservas.dto.ReservasUsuaSPDTO;
import com.asesoftware.reservas.api.reservas.entity.ReservaEntity;

/**
 * Clase ReservasPorDiaRepository para usar procedimientos almacenados
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
				.map(datos -> ReservasPTDiaSPDTO
						.builder()
						.correo((String)datos[0])
						.numReserva(((BigDecimal)datos[1]).intValueExact())
						.dia((Date)datos[2])
						.horaInicio((Date)datos[3])
						.horaFin((Date)datos[4])
						.estado((String)datos[5])
						.puestoDeTrabajo(((BigDecimal)datos[6]).intValueExact())
						.nombre((String)datos[7])
						.piso(((BigDecimal)datos[8]).intValueExact())
						.nombrePiso((String)datos[9])
						.sucursal((String)datos[10])
						.empresa((String)datos[11]).build())
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
				.map(datos ->  ReservasSDiaSPDTO
						.builder()
						.numeroReserva(((BigDecimal)datos[0]).intValue())
						.dia((Date)datos[1])
						.horaInicio((Date)datos[2])
						.horaFin((Date)datos[3])
						.nombreUsuario((String)datos[4])
						.nombreSala((String)datos[5])
						.nombrePiso((String)datos[6])
						.numeroAsistentes(((BigDecimal)datos[7]).intValue())
						.build())
				.collect(Collectors.toList());
		
		logger.info("Las reservas de salas para la fecha {} son {}", fechaReservaS, dataDTOs);
		
		return dataDTOs;
	}
	
	/**
	* Método para usar el procedimiento almacenado PR_CON_RESERVA_USUARIO
	* @author abarrios
	* @version 0.1, 2021/07/13
	*/
	
	public List<ReservasUsuaSPDTO> getReservaUsua(Date fechaInicio, Date fechaFin, String correo) {

		StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery("PR_CON_RESERVA_USUARIO")
				.registerStoredProcedureParameter("IN_FECHA", Date.class, ParameterMode.IN) //Dato de entrada
				.registerStoredProcedureParameter("IN_FECHAFIN", Date.class, ParameterMode.IN) //Dato de entrada
				.registerStoredProcedureParameter("IN_CORREO", String.class, ParameterMode.IN) //Dato de entrada
				.setParameter("IN_FECHA", fechaInicio)
				.setParameter("IN_FECHAFIN", fechaFin)
				.setParameter("IN_CORREO", correo)
				.registerStoredProcedureParameter("OUT_INFO_RESERVAS", ReservasUsuaSPDTO.class, ParameterMode.REF_CURSOR);

		//Ejecuta el metodo que retorna una lista de objetos
		@SuppressWarnings("unchecked")
		List<Object[]> listReservas = storedProcedureQuery.getResultList(); 

		//se pasa a dto
		List<ReservasUsuaSPDTO> dataDTOs = listReservas.stream()
				.map(datos -> ReservasUsuaSPDTO
						.builder()
						.numeroReserva(((BigDecimal)datos[0]).intValue())
						.dia((Date)datos[1])
						.horaInicio((Date)datos[2])
						.horaFin((Date)datos[3])
						.totalHoras(((BigDecimal)datos[4]).intValue())
						.dominioEstado((String)datos[5])
						.dominioTipoVehiculo((String)datos[6])
						.parqueadero(((Character)datos[7]).toString())
						.placa((String)datos[8])
						.nombreUsuario((String)datos[9])
						.proyecto((String)datos[10])
						.idPuestoTrabajo(datos[11] != null ? ((BigDecimal)datos[11]).intValue():null)
						.idSala(datos[12]!= null ? ((BigDecimal)datos[12]).intValue():null)
						.nombreSala((String)datos[13])
						.nombrePuesTrabajo((String)datos[14])
						.build())
				.collect(Collectors.toList());

		logger.info("de la fecha inicio {} a la fecha {} del usuario {}", fechaInicio,fechaFin,correo, dataDTOs);

		return dataDTOs;
	}

	/**
	* Método para usar el procedimiento almacenado SP_CREAR_RESERVA
	* @author jrondon
	* @version 0.1, 2021/07/12
	*/
	public ReservaEntity addNewReserva(ReservaAddDTO reservaAddDTO) {
		logger.info("Ingreso al repositorio de addNewReserva");
		StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery("PR_CREAR_RESERVA")
				.registerStoredProcedureParameter("indDia", Date.class, ParameterMode.IN)
				.registerStoredProcedureParameter("inHoraInicio", Date.class, ParameterMode.IN)
				.registerStoredProcedureParameter("inHoraFin", Date.class, ParameterMode.IN)
				.registerStoredProcedureParameter("inTotalHoras", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("inDominioTipoVehiculo", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("inPlaca", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("inEmailUsuario", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("inProyecto", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("inIdRelacion", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("inTipoReserva", String.class, ParameterMode.IN)
				.setParameter("indDia", reservaAddDTO.getDia())
				.setParameter("inHoraInicio", reservaAddDTO.getHoraInicio())
				.setParameter("inHoraFin", reservaAddDTO.getHoraFin())
				.setParameter("inTotalHoras", reservaAddDTO.getTotalHoras())
				.setParameter("inDominioTipoVehiculo", reservaAddDTO.getDominioTipoVehiculo())
				.setParameter("inPlaca", reservaAddDTO.getPlaca())
				.setParameter("inEmailUsuario", reservaAddDTO.getEmailUsuario())
				.setParameter("inProyecto", reservaAddDTO.getProyecto())
				.setParameter("inIdRelacion", reservaAddDTO.getIdRelacion())
				.setParameter("inTipoReserva", reservaAddDTO.getTipoReserva())
				.registerStoredProcedureParameter("outResultado", ReservasUsuaSPDTO.class, ParameterMode.REF_CURSOR);
		logger.info("Se enviaron los datos al procedimiento almacenado");
		
		//Ejecuta el metodo que retorna el objeto creado
		Object reservaCreada = storedProcedureQuery.getSingleResult();
		logger.info("Se creo la reserva y se retornan el registro en forma de objeto");
		
		//ReservaDTO dataDTO = (ReservaDTO) reservaCreada;
		ReservaEntity reservaEntity = (ReservaEntity) reservaCreada;
		logger.info("El objeto con el registro ahora es una entidad");
		
		return reservaEntity;
	}
}