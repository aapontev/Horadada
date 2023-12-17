package com.projecto.Horadada.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.projecto.Horadada.Entity.ClienteEntity;

public interface ClienteService {

	public abstract List<ClienteEntity> findByAll();
	public abstract ClienteEntity save(ClienteEntity cliente);
	public abstract ClienteEntity findByidCliente(int idcliente);
	public abstract int delete(int idcliente);
	public Page<ClienteEntity> findAll(Pageable pageable);
	public abstract ClienteEntity findOne(Long clienteId);
}
