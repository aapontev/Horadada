package com.projecto.Horadada.Dao;


import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.projecto.Horadada.Entity.Solicitud;

@Repository("solicituddao")
public interface SolicitudDao extends PagingAndSortingRepository<Solicitud, Serializable>{

	public abstract Solicitud findByidsolicitud(int idsolicitud);
	
	@Query(value="select * from solicitud s where s.idsolicitud not in (select ch.idsolicitud from Cotizacionhist ch)" ,nativeQuery=true)///Solicitudes con Cotizacion sin aprobar
	public abstract List<Solicitud> getidsolicitud();
}
