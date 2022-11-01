package com.projecto.Horadada.Dao;

import java.io.Serializable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.projecto.Horadada.Entity.CotizacionDetalle;

@Repository("cotizaciondetalledao")
public interface CotizacionDetalleDao extends CrudRepository<CotizacionDetalle, Serializable> {

	public abstract CotizacionDetalle findByItem (Integer item);
}
