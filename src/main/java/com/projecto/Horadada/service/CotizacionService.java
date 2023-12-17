package com.projecto.Horadada.service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.projecto.Horadada.Entity.CotizacionEntity;

public interface CotizacionService {

	public abstract List<CotizacionEntity> findAll ();
	public abstract CotizacionEntity findbyid(int id);
	public abstract CotizacionEntity save(CotizacionEntity cotizacion);
	public abstract void delete(int id);
	public Page<CotizacionEntity> findAll(Pageable pageable);
	public abstract List<CotizacionEntity> findByaprobado(int estado);
}
