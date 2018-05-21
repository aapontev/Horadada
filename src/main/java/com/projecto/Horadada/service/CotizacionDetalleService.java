package com.projecto.Horadada.service;

import java.util.List;

import com.projecto.Horadada.Entity.Cotizacion;
import com.projecto.Horadada.Entity.Cotizaciondetalle;

public interface CotizacionDetalleService {

	public abstract List<Cotizaciondetalle> findBycotizacion (Cotizacion idCotizacion);
	
}
