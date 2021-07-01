package com.asesoftware.reservas.api.reservas.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

/**
 * Esta clase contiene la información expuesta en el api-rest para la entidad
 * horario_puesto_trabajo
 * 
 * @author jrondon
 *
 */
@Data
public class HorarioPuestoTrabajoDTO {

	// VARIABLES DE LA ENTIDAD
	private Integer idHorario;
	private Integer idSucursal;
	private Integer numeroHoras;
	private String nombre;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss", timezone = "America/New_York")
	private Date horaFin;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss", timezone = "America/New_York")
	private Date horaInicio;

	// VARIABLES LOGICAS
	// Anotar aca las variables que no hacen parte de la entidad pero se requieren
	// para la logica de esta clase
}
