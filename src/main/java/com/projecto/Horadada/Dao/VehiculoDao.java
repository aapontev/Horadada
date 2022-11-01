package com.projecto.Horadada.Dao;

import java.io.Serializable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.projecto.Horadada.Entity.Vehiculo;

@Repository("vehiculodao")
public interface VehiculoDao extends PagingAndSortingRepository<Vehiculo, Serializable> {
	
	public abstract Vehiculo findByidVehiculo(int id);

}
