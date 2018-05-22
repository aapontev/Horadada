package com.projecto.Horadada.Dao;


import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projecto.Horadada.Entity.Cotizacion;
import com.projecto.Horadada.Entity.Cotizaciondetalle;

@Repository("cotizaciondetalledao")
public interface CotizacionDetalleDao extends JpaRepository<Cotizaciondetalle, Serializable> {

	public abstract List<Cotizaciondetalle> findBycotizacion (Cotizacion idCotizacion);
}
