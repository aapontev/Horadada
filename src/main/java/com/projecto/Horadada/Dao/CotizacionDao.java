package com.projecto.Horadada.Dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.projecto.Horadada.Entity.Cotizacion;
@Repository("Cotizaciondao")
public interface CotizacionDao extends PagingAndSortingRepository<Cotizacion, Serializable> {

	public abstract Cotizacion findByidcotizacion(int id);
	public abstract List<Cotizacion> findByaprobado(int estado);
}
