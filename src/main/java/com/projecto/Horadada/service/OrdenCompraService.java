package com.projecto.Horadada.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.projecto.Horadada.Entity.Ordencompra;

public interface OrdenCompraService {

	public abstract List<Ordencompra> findAll();
	public abstract Ordencompra findbyid(int id);
	public abstract Object save(Ordencompra ordencompra);
	public abstract void delete(int id);
	public abstract List<Ordencompra> findByestadoordencompra(int i);
	public Page<Ordencompra> findAll(Pageable pageable);
}
