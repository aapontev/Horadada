package com.projecto.Horadada.Dao;



import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projecto.Horadada.Entity.Cotizacion;

@Repository("Cotizaciondao")
public interface CotizacionDao extends JpaRepository<Cotizacion, Serializable> {

	public abstract Cotizacion findByidcotizacion(int id);
}
