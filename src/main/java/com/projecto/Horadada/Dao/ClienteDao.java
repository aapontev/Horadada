package com.projecto.Horadada.Dao;



import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.projecto.Horadada.Entity.Cliente;

@Repository("clienteDao")
public interface ClienteDao extends CrudRepository<Cliente, Serializable>{

	public abstract Cliente findByidcliente(int idcliente);

}
