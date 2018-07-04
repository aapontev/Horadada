package com.projecto.Horadada.Dao;

import java.io.Serializable;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.projecto.Horadada.Entity.Tiposervicio;

@Repository("serviciodao")
public interface ServicioDao extends PagingAndSortingRepository<Tiposervicio, Serializable> {

	public abstract Tiposervicio findByIdservicio(int id);
}
