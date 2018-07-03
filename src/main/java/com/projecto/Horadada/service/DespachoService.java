package com.projecto.Horadada.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.projecto.Horadada.Entity.Despacho;

public interface DespachoService {

	public abstract List<Despacho> findAll();
	public abstract Despacho findByiddespacho(int id);
	public Page<Despacho> findAll(Pageable pageable);
	public abstract Despacho save(Despacho despacho);
	
}
