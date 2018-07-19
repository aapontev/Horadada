package com.projecto.Horadada.Dao;

import java.io.Serializable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.projecto.Horadada.Entity.Telefono;

@Repository("telefonodao")
public interface TelefonoDao extends PagingAndSortingRepository<Telefono, Serializable> {


	//public abstract List<Telefono> findBypersona(Persona id);
	public abstract Telefono findByimei(String imei);
	public abstract Telefono findBynumerotelefono(String numero);
}
