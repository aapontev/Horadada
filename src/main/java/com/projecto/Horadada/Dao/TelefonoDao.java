package com.projecto.Horadada.Dao;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.projecto.Horadada.Entity.Telefono;

@Repository("telefonodao")
public interface TelefonoDao extends CrudRepository<Telefono, Serializable> {

	
}
