package com.projecto.Horadada.Dao;

import java.io.Serializable;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.projecto.Horadada.Entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository("clienteDao")
public interface ClienteDao extends JpaRepository<ClienteEntity, Serializable>{

	public abstract ClienteEntity findByidCliente(int idcliente);

}
