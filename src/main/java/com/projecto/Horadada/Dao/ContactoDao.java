package com.projecto.Horadada.Dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.projecto.Horadada.Entity.Contacto;

@Repository("contactoDao")
public interface ContactoDao extends CrudRepository<Contacto, Serializable> {
	
	@Query(value="select COUNT(*) from contacto where idcliente = :id" ,nativeQuery=true)
	public abstract int getclienteIdcliente(@Param("id") int id);
	
	public abstract Contacto findByidcontacto(int id);
}
