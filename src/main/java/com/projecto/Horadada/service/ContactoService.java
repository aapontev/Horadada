package com.projecto.Horadada.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.projecto.Horadada.Entity.Contacto;

public interface ContactoService {

	public abstract List<Contacto> findByAll();
	public abstract int findbyidcliente(int id);
	public abstract Contacto save(Contacto contacto);
	public abstract void delete(int id);
	public abstract Contacto findByidcontacto(int id);
	public abstract Page<Contacto> findAll(Pageable pageRequest);
}
