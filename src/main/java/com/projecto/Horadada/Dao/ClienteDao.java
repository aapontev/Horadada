package com.projecto.Horadada.Dao;

import java.io.Serializable;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.projecto.Horadada.Entity.Cliente;

@Repository("clienteDao")
public interface ClienteDao extends PagingAndSortingRepository<Cliente, Serializable>{

	public abstract Cliente findByidcliente(int idcliente);

}
