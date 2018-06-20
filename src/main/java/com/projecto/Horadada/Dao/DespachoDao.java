package com.projecto.Horadada.Dao;

import java.io.Serializable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.projecto.Horadada.Entity.Despacho;

@Repository("despachodao")
public interface DespachoDao extends CrudRepository<Despacho, Serializable>{

}
