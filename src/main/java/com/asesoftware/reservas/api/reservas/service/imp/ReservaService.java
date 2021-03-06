package com.asesoftware.reservas.api.reservas.service.imp;

import static com.asesoftware.reservas.api.reservas.utils.Constantes.ERROR_GENERICO;
import static com.asesoftware.reservas.api.reservas.utils.Constantes.OK;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.asesoftware.reservas.api.reservas.dto.CalendarioPuestoDTO;
import com.asesoftware.reservas.api.reservas.dto.CalendarioSalaDTO;
import com.asesoftware.reservas.api.reservas.dto.ReservaAddDTO;
import com.asesoftware.reservas.api.reservas.dto.ReservasPTDiaSPDTO;
import com.asesoftware.reservas.api.reservas.dto.ReservasSDiaSPDTO;
import com.asesoftware.reservas.api.reservas.dto.ReservasUsuaSPDTO;
import com.asesoftware.reservas.api.reservas.dto.ResponseDTO;
import com.asesoftware.reservas.api.reservas.repository.AforoDiaRepository;
import com.asesoftware.reservas.api.reservas.repository.CalendarioPuestoRepository;
import com.asesoftware.reservas.api.reservas.repository.CalendarioSalaRepository;
import com.asesoftware.reservas.api.reservas.repository.IReservasRepository;
import com.asesoftware.reservas.api.reservas.repository.ParqueaderoBicicletaEMRepository;
import com.asesoftware.reservas.api.reservas.repository.ParqueaderoCarroEMRepository;
import com.asesoftware.reservas.api.reservas.repository.ParqueaderoMotoEMRepository;
import com.asesoftware.reservas.api.reservas.repository.ReservaEMRepository;
import com.asesoftware.reservas.api.reservas.service.IReservaService;

@Service
public class ReservaService implements IReservaService {

	private static final Logger logger = LoggerFactory.getLogger(ReservaService.class);

	private static final String FORMATO_FECHA = "dd-MM-yyyy";

	@Autowired
	ReservaEMRepository reservasPorDiaRepository;

	@Autowired
	ReservaEMRepository reservasUsuario;

	@Autowired
	CalendarioSalaRepository calendarioSalaRepository;

	@Autowired
	CalendarioPuestoRepository calendarioPuestoRepository;

	@Autowired
	private ParqueaderoBicicletaEMRepository parqueaderoBicicletaEMRepository;

	@Autowired
	private ParqueaderoCarroEMRepository parqueaderoCarroEMRepository;

	@Autowired
	private ParqueaderoMotoEMRepository parqueaderoMotoEMRepository;

	@Autowired
	private AforoDiaRepository aforoDiaRepository;
	
	@Autowired
	private ReservaEMRepository reservaEMRepository;
	
	@Autowired
	private IReservasRepository reservaRepository;
	
	
	/**
	 * M??todo Consultar reservas por d??a PT
	 * 
	 * @author jcanizales
	 * @version 0.1, 2021/07/06
	 */

	@Override
	public ResponseDTO consultarReservaXDiaPT(String fechaString) {

		SimpleDateFormat fechaFormat = new SimpleDateFormat(FORMATO_FECHA);

		Date fecha;
		try {
			fecha = fechaFormat.parse(fechaString);
			logger.info("ingreso al metodo consultarReservaXDiaPT de service {}", fecha);

			List<ReservasPTDiaSPDTO> listaReservasXDia = reservasPorDiaRepository.getReservaPTDia(fecha);
			return new ResponseDTO(listaReservasXDia, true, OK, HttpStatus.OK);
		} catch (ParseException e) {
			return new ResponseDTO(null, false, OK, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Servicio disponibilidadParqueaderoBicis para usar el SP PR_DIS_PAR_BICICLETA
	 * 
	 * @author jortizg
	 * @version 0.1, 2021/07/08
	 */
	@Override
	public ResponseDTO disponibilidadParqueaderoBicis(String fechaString) {

		SimpleDateFormat fechaFormat = new SimpleDateFormat(FORMATO_FECHA);

		Date fecha;
		try {
			fecha = fechaFormat.parse(fechaString);
			logger.info("ingreso al metodo disponibilidadParqueaderoBicis de service {}", fecha);

			Integer parqueaderosDisponibles = parqueaderoBicicletaEMRepository.getDisponibilidadParqueaderoBicis(fecha);

			logger.info("salida del metodo disponibilidadParqueaderoBicis de service {}", parqueaderosDisponibles);

			if (parqueaderosDisponibles <= 0) {
				return new ResponseDTO(null, false, OK, HttpStatus.INTERNAL_SERVER_ERROR);
			} else {
				return new ResponseDTO(parqueaderosDisponibles, true, OK, HttpStatus.OK);
			}

		} catch (ParseException e) {
			return new ResponseDTO(null, false, OK, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Consulta el calendario de una sala por medio de un procedimiento almacenado
	 * en el rango de las fechas especificadas
	 * 
	 * @author ajgutierrez
	 * @version 0.1, 2021/07/08
	 */
	@Override
	public ResponseDTO consultaCalendarioSalas(Integer id, String fechaInicio, String fechaFin) {

		SimpleDateFormat fechaFormat = new SimpleDateFormat(FORMATO_FECHA);
		Date fechaIn;
		Date fechaF;
		try {
			fechaIn = fechaFormat.parse(fechaInicio);
			fechaF = fechaFormat.parse(fechaFin);
			logger.info("consultaCalendarioSalas()");
			List<CalendarioSalaDTO> answ = calendarioSalaRepository.getCalendarioSala(id, fechaIn, fechaF);
			return new ResponseDTO(answ, true, OK, HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseDTO(null, false, ERROR_GENERICO, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	/**
	 * Servicio que consulta el calendario de un puesto de trabajo
	 * 
	 * @author acmoya
	 * @version 0.1, 12/07/2021
	 */
	@Override
	public ResponseDTO consultaCalendarioPuestos(Integer id, String fechaInicio, String fechaFin) {

		SimpleDateFormat fechaFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date fechaIn;
		Date fechaF;
		try {
			fechaIn = fechaFormat.parse(fechaInicio);
			fechaF = fechaFormat.parse(fechaFin);
			logger.info("Ingreso al metodo consultaCalendarioPuestos()");
			List<CalendarioPuestoDTO> listaCalendarioPuesto = calendarioPuestoRepository.getCalendarioPuesto(id,
					fechaIn, fechaF);
			return new ResponseDTO(listaCalendarioPuesto, true, OK, HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseDTO(null, false, ERROR_GENERICO, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Consulta las reservas de las salas mediante el correspondiente procedimiento
	 * almacenado
	 * 
	 * @author wsierra
	 * @version 0.1, 2021/07/09
	 */
	@Override
	public ResponseDTO consultarReservaXDiaS(String fechaString) {

		SimpleDateFormat fechaFormat = new SimpleDateFormat(FORMATO_FECHA);

		Date fecha;
		try {
			fecha = fechaFormat.parse(fechaString);
			logger.info("ingreso consultarReservaXDiaS()");

			List<ReservasSDiaSPDTO> listaReservasXDia = reservasPorDiaRepository.getReservaSDia(fecha);
			return new ResponseDTO(listaReservasXDia, true, OK, HttpStatus.OK);
		} catch (ParseException e) {
			return new ResponseDTO(null, false, ERROR_GENERICO, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Servicio disponibilidadParqueaderoCarro para usar el SP
	 * PR_CON_PARQUEADEROS_CARRO
	 * 
	 * @author kpinilla
	 * @version 0.1, 2021/07/08
	 */

	@Override
	public ResponseDTO disponibilidadParqueaderoCarro(String fecha) {
		SimpleDateFormat fechaFormat = new SimpleDateFormat(FORMATO_FECHA);

		Date fecha2;
		try {
			fecha2 = fechaFormat.parse(fecha);
			logger.info("ingreso al metodo disponibilidadParqueaderoCarro de service {}", fecha2);

			Integer parqueaderosDisponibles = parqueaderoCarroEMRepository.getDisponibilidadParqueaderoCarro(fecha2);

			logger.info("salida del metodo disponibilidadParqueaderoCarro de service {}", parqueaderosDisponibles);

			if (parqueaderosDisponibles <= 0) {
				return new ResponseDTO(null, false, OK, HttpStatus.INTERNAL_SERVER_ERROR);
			} else {
				return new ResponseDTO(parqueaderosDisponibles, true, OK, HttpStatus.OK);
			}

		} catch (ParseException e) {
			return new ResponseDTO(null, false, OK, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Servicio para usar el procedimiento almacenado PR_CREAR_RESERVA
	 * 
	 * @author jrondon
	 * @version 0.1, 2021/07/08
	 */
	public ResponseDTO crearReserva(ReservaAddDTO reservaAddDto) {
		logger.info("Ingres?? al m??todo del servicio crearReserva");
		try {
			Integer reservaAdderInt = reservaEMRepository.addNewReserva(reservaAddDto);
			logger.info("Se cre?? la nueva reserva");
			return new ResponseDTO(reservaAdderInt, true, OK, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Error {}.  No se creo la reserva en el procedimiento almacenado", e.getMessage());
			return new ResponseDTO(null, false, ERROR_GENERICO, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * Servicio para usar cancelar una reserva
	 * 
	 * @author jrondon
	 * @version 0.1, 2021/07/16
	 */
	@Override
	public ResponseDTO cancelarReserva(Integer id) {
		logger.info("Ingres?? al m??todo del servicio cancelarReserva");
		try {
			reservaRepository.cancelarReserva(id);
			return new ResponseDTO(null, true, OK, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Error {}.  No se pudo gestionar la cancelacion de la reserva", e.getMessage());
			return new ResponseDTO(null, false, ERROR_GENERICO, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Servicio disponibilidadParqueaderoCarro para usar el SP
	 * PRO_CON_PARQUEADEROS_MOTO
	 * 
	 * @author cfcruz
	 * @version 0.1, 2021/07/13
	 */
	@Override
	public ResponseDTO disponibilidadParqueaderoMoto(String fechaString) {

		SimpleDateFormat fechaFormat = new SimpleDateFormat(FORMATO_FECHA);

		Date fecha;

		try {
			fecha = fechaFormat.parse(fechaString);
			logger.info("ingreso al metodo disponibilidadParqueaderoMoto de service {}", fecha);

			Integer parqueaderosDisponiblesMoto = parqueaderoMotoEMRepository.getDisponibilidadParqueaderoMoto(fecha);

			logger.info("salida del metodo disponibilidadParqueaderoMoto de service {}", parqueaderosDisponiblesMoto);

			if (parqueaderosDisponiblesMoto <= 0) {
				return new ResponseDTO(null, false, OK, HttpStatus.INTERNAL_SERVER_ERROR);
			} else {
				return new ResponseDTO(parqueaderosDisponiblesMoto, true, OK, HttpStatus.OK);
			}

		} catch (ParseException e) {
			return new ResponseDTO(null, false, OK, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseDTO validarAforoDia(String fechaString, Integer idPiso) {
		SimpleDateFormat formatoFecha = new SimpleDateFormat(FORMATO_FECHA);

		Date fechaDate;
		try {
			fechaDate = formatoFecha.parse(fechaString);

			logger.info("ingreso a m??todo validarAforoDia en el Reserva Service {}", fechaString);

			Integer aforoDia = aforoDiaRepository.getAforoDia(fechaDate, idPiso);

			logger.info("salida de m??todo validarAforoDia en el service {}", fechaString);

			if (aforoDia <= 0) {
				return new ResponseDTO(null, false, OK, HttpStatus.INTERNAL_SERVER_ERROR);
			} else {
				return new ResponseDTO(aforoDia, true, OK, HttpStatus.OK);
			}
		} catch (ParseException e) {
			return new ResponseDTO(null, false, OK, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	/**
	 * Servicio consultar reservas de usuario, para usar el SP
	 * PR_CON_PARQUEADEROS_CARRO
	 * 
	 * @author abarrios
	 * @version 0.1, 2021/07/13
	 */

	@Override
	public ResponseDTO consultaReservaUsuario(String fechaInicio, String fechaFin, String correo) {
		SimpleDateFormat fechaFormat = new SimpleDateFormat(FORMATO_FECHA);
		Date fechaInici;
		Date fechaFi;
		try {
			fechaInici = fechaFormat.parse(fechaInicio);
			fechaFi = fechaFormat.parse(fechaFin);
			logger.info("consultaReservasUsuario()");
			List<ReservasUsuaSPDTO> answ = reservasUsuario.getReservaUsua(fechaInici, fechaFi, correo);
			return new ResponseDTO(answ, true, OK, HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseDTO(null, false, ERROR_GENERICO, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
