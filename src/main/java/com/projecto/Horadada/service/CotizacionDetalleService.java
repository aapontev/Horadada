package com.projecto.Horadada.service;

import com.projecto.Horadada.Entity.CotizacionDetalleEntity;

public interface CotizacionDetalleService {

	public abstract CotizacionDetalleEntity findByItem (int item);
	public abstract CotizacionDetalleEntity save (CotizacionDetalleEntity cotizaciondetalle);
}
