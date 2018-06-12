package com.projecto.Horadada.Dao;

import java.io.Serializable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.projecto.Horadada.Entity.Cotizacion;

@Repository("Cotizaciondao")
public interface CotizacionDao extends CrudRepository<Cotizacion, Serializable> {

	public abstract Cotizacion findByidcotizacion(int id);
}
