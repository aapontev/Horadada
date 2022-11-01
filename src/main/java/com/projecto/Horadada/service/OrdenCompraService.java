package com.projecto.Horadada.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.projecto.Horadada.Entity.OrdenCompra;

public interface OrdenCompraService {

	public abstract List<OrdenCompra> findAll();
	public abstract OrdenCompra findbyid(int id);
	public abstract Object save(OrdenCompra ordencompra);
	public abstract void delete(int id);
	public abstract List<OrdenCompra> findByestadoordencompra(int i);
	public Page<OrdenCompra> findAll(Pageable pageable);
}
