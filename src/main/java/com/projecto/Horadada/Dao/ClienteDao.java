package com.projecto.Horadada.Dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.projecto.Horadada.Entity.Cliente;

@Repository("clienteDao")
public interface ClienteDao extends JpaRepository<Cliente, Serializable>{

	public abstract Cliente findByidcliente(int idcliente);

}
