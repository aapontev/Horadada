package com.projecto.Horadada.Dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;
import com.projecto.Horadada.Entity.CotizacionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository("Cotizaciondao")
public interface CotizacionDao extends JpaRepository<CotizacionEntity, Serializable> {

	public abstract CotizacionEntity findByidCotizacion(int id);
	public abstract List<CotizacionEntity> findByaprobado(Integer estado);
}
