package com.projecto.Horadada.Dao;

import java.io.Serializable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.projecto.Horadada.Entity.Despacho;

@Repository("despachodao")
public interface DespachoDao extends PagingAndSortingRepository<Despacho, Serializable>{

	public abstract Despacho findByiddespacho(int id);

}
