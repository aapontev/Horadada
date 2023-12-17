package com.projecto.Horadada.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.projecto.Horadada.Entity.ContactoEntity;

public interface ContactoService {

	public abstract List<ContactoEntity> findByAll();
	public abstract int findbyidcliente(int id);
	public abstract ContactoEntity save(ContactoEntity contacto);
	public abstract void delete(int id);
	public abstract ContactoEntity findByidcontacto(int id);
	public abstract Page<ContactoEntity> findAll(Pageable pageRequest);
}
