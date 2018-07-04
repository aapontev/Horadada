package com.projecto.Horadada.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.projecto.Horadada.Entity.Cliente;

public interface ClienteService {

	public abstract List<Cliente> findByAll();
	public abstract Cliente save(Cliente cliente);
	public abstract Cliente findByidcliente(int idcliente);
	public abstract int delete(int idcliente);
	public Page<Cliente> findAll(Pageable pageable);
	public abstract Cliente findOne(Long clienteId);
}
