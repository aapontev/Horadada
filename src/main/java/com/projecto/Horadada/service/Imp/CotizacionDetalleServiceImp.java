package com.projecto.Horadada.service.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.projecto.Horadada.Dao.CotizacionDetalleDao;
import com.projecto.Horadada.Entity.Cotizacion;
import com.projecto.Horadada.Entity.Cotizaciondetalle;
import com.projecto.Horadada.service.CotizacionDetalleService;

public class CotizacionDetalleServiceImp implements CotizacionDetalleService{
	
	@Autowired
	@Qualifier("cotizaciondetalledao")
	CotizacionDetalleDao cotizaciondetalledao;

	@Override
	public List<Cotizaciondetalle> findBycotizacion(Cotizacion idCotizacion) {
		List<Cotizaciondetalle> detallecotizacion = cotizaciondetalledao.findBycotizacion(idCotizacion);
		return detallecotizacion;
	}

}
