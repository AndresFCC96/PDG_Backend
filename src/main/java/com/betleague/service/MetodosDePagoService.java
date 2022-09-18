package com.betleague.service;

import java.util.List;

import com.betleague.domain.MetodoDePago;
import com.betleague.dto.MetodoDePagoDTO;

public interface MetodosDePagoService {
	
	public List<MetodoDePago> obtenerLosMetodosDePagoPorCliente(Long cedula) throws Exception;
	
	public MetodoDePago guardarMetodoDePago(MetodoDePagoDTO metodoDePagoDTO) throws Exception;
	
	public MetodoDePago modificarMetodoDePago(MetodoDePagoDTO metodoDePagoDTO) throws Exception;
	
	public void eliminarMetodoDePago(Long numeroTarjeta) throws Exception;
}
