package com.projecto.Horadada.Dao;



import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.projecto.Horadada.Entity.Transportista;

@Repository("transportistaDao")
public interface TransportistaDao extends CrudRepository<Transportista, Serializable> {

	public abstract Transportista findByidtransportista(int id);
}
