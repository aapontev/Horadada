package com.projecto.Horadada.service;

import java.util.List;

import com.projecto.Horadada.Entity.Despacho;

public interface DespachoService {

	public abstract List<Despacho> findAll();

	public abstract Despacho findByiddespacho(int id);

	public abstract Despacho save(Despacho despacho);
}
