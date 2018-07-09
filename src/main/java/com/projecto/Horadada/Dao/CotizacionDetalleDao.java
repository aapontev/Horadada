package com.projecto.Horadada.Dao;

import java.io.Serializable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.projecto.Horadada.Entity.Cotizaciondetalle;

@Repository("cotizaciondetalledao")
public interface CotizacionDetalleDao extends CrudRepository<Cotizaciondetalle, Serializable> {

	public abstract Cotizaciondetalle findByItem (int item);
}
