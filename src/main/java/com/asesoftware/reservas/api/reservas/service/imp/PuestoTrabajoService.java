package com.asesoftware.reservas.api.reservas.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asesoftware.reservas.api.reservas.dto.PuestoTrabajoDTO;
import com.asesoftware.reservas.api.reservas.dto.ResponseDTO;
import com.asesoftware.reservas.api.reservas.repository.IPuestoTrabajoRepository;
import com.asesoftware.reservas.api.reservas.service.IPuestoTrabajoService;

@Service
public class PuestoTrabajoService implements IPuestoTrabajoService{
	
	@Autowired
	private IPuestoTrabajoRepository puestoTrabajoRepository;

	@Override
	public ResponseDTO consultarTodas() {

		return null;
	}

	@Override
	public ResponseDTO PuestoTrabajoPorId(Integer idPuestoTrabajo) {

		return null;
	}

	@Override
	public ResponseDTO crearPuestoTrabajo(PuestoTrabajoDTO puestoTrabajoDTO) {

		return null;
	}

	@Override
	public ResponseDTO actualizarPuestoTrabajo(PuestoTrabajoDTO puestoTrabajoDTO) {

		return null;
	}

	@Override
	public ResponseDTO borrarPuestoTrabajo(Integer idPuestoTrabajo) {

		return null;
	}

}
