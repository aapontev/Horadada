package com.projecto.Horadada.service;

import com.projecto.Horadada.Entity.CotizacionDetalle;

public interface CotizacionDetalleService {

	public abstract CotizacionDetalle findByItem (int item);
	public abstract CotizacionDetalle save (CotizacionDetalle cotizaciondetalle);
}
