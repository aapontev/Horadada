package com.projecto.Horadada.Dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.projecto.Horadada.Entity.TipoServicio;

@Repository("serviciodao")
public interface ServicioDao extends PagingAndSortingRepository<TipoServicio, Serializable> {

	public abstract TipoServicio findByIdServicio(int id);

	public abstract List<TipoServicio> findByNombreServicioLikeIgnoreCase(String string);
}
