package com.projecto.Horadada.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.projecto.Horadada.Entity.Telefono;

public interface TelefonoService {

	public abstract List<Telefono> findByAll();
	public abstract Telefono save(Telefono telefono);
	public Page<Telefono> findAll(Pageable pageable);
}
