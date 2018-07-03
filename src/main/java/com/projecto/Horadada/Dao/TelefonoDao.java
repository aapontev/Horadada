package com.projecto.Horadada.Dao;

import java.io.Serializable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.projecto.Horadada.Entity.Telefono;

@Repository("telefonodao")
public interface TelefonoDao extends PagingAndSortingRepository<Telefono, Serializable> {

	
}
