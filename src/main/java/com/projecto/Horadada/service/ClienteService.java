package com.projecto.Horadada.service;

import java.util.List;

import com.projecto.Horadada.Entity.Cliente;

public interface ClienteService {

	public abstract List<Cliente> findByAll();
	public abstract Cliente save(Cliente cliente);
	public abstract Cliente findByidcliente(int idcliente);
	public abstract void delete(int idcliente);

}
