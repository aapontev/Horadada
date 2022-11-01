package com.projecto.Horadada.Dao;

import java.io.Serializable;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.projecto.Horadada.Entity.Transportista;

@Repository("transportistaDao")
public interface TransportistaDao extends PagingAndSortingRepository<Transportista, Serializable> {

	public abstract Transportista findByidTransportista(int id);
	public abstract Transportista findByidSituacionTransportista(Integer id);
}
