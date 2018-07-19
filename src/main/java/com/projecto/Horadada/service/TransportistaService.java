package com.projecto.Horadada.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.projecto.Horadada.Entity.Transportista;

public interface TransportistaService {
	
	public abstract List<Transportista> findByAll();
	public abstract Transportista findByidtransportista(int id);
	public abstract Transportista save(Transportista transportista);
	public abstract void delete(int id);
	public Page<Transportista> findAll(Pageable pageable);
	public abstract Transportista findByidsituaciontransportista(int i);
	}
