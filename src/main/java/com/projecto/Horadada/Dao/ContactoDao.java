package com.projecto.Horadada.Dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.projecto.Horadada.Entity.ContactoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository("contactoDao")
public interface ContactoDao extends JpaRepository<ContactoEntity, Serializable> {
	
	@Query(value="select COUNT(*) from contacto where idcliente = :id" ,nativeQuery=true)
	public abstract int getclienteIdCliente(@Param("id") int id);
	
	public abstract ContactoEntity findByidContacto(int id);
}
