package com.projecto.Horadada.service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.projecto.Horadada.Entity.Cotizacion;

public interface CotizacionService {

	public abstract List<Cotizacion> findAll ();
	public abstract Cotizacion findbyid(int id);
	public abstract Cotizacion save(Cotizacion cotizacion);
	public abstract void delete(int id);
	public Page<Cotizacion> findAll(Pageable pageable);
	public abstract List<Cotizacion> findByaprobado(int estado);
}
