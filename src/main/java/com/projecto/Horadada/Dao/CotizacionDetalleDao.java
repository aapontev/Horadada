package com.projecto.Horadada.Dao;

import java.io.Serializable;
import org.springframework.stereotype.Repository;
import com.projecto.Horadada.Entity.CotizacionDetalleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository("cotizaciondetalledao")
public interface CotizacionDetalleDao extends JpaRepository<CotizacionDetalleEntity, Serializable> {

	public abstract CotizacionDetalleEntity findByItem (Integer item);
}
