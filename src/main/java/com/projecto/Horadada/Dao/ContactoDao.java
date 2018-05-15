package com.projecto.Horadada.Dao;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.projecto.Horadada.Entity.Contacto;

@Repository("contactoDao")
public interface ContactoDao extends CrudRepository<Contacto, Serializable> {

}
