package com.projecto.Horadada.Dao;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.projecto.Horadada.Entity.Cotizacion;
import com.projecto.Horadada.Entity.Cotizaciondetalle;

@Repository("cotizaciondetalledao")
public interface CotizacionDetalleDao extends CrudRepository<Cotizaciondetalle, Serializable> {

	public abstract List<Cotizaciondetalle> findBycotizacion (Cotizacion idCotizacion);
	public abstract Cotizaciondetalle findByItem (int item);
}
