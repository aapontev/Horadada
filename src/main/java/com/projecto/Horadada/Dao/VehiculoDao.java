package com.projecto.Horadada.Dao;

import java.io.Serializable;
import org.springframework.stereotype.Repository;
import com.projecto.Horadada.Entity.VehiculoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository("vehiculodao")
public interface VehiculoDao extends JpaRepository<VehiculoEntity, Serializable> {

    public abstract VehiculoEntity findByidVehiculo(int id);

}
