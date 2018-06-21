package com.projecto.Horadada.service;

import java.util.List;
import com.projecto.Horadada.Entity.Ordencompra;

public interface OrdenCompraService {

	public abstract List<Ordencompra> findAll();

	public abstract Ordencompra findbyid(int id);

	public abstract Object save(Ordencompra ordencompra);

	public abstract void delete(int id);
}
