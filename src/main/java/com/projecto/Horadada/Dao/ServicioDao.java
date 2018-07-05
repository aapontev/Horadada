package com.projecto.Horadada.Dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.projecto.Horadada.Entity.Tiposervicio;

@Repository("serviciodao")
public interface ServicioDao extends PagingAndSortingRepository<Tiposervicio, Serializable> {

	public abstract Tiposervicio findByIdservicio(int id);

	public abstract List<Tiposervicio> findByNombreservicioLikeIgnoreCase(String string);
}
