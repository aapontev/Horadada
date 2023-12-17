package com.projecto.Horadada.Dao;

import com.projecto.Horadada.Entity.PersonaEntity;
import java.io.Serializable;
import org.springframework.stereotype.Repository;
import com.projecto.Horadada.Entity.TelefonoMonitoreoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository("telefonodao")
public interface TelefonoDao extends JpaRepository<TelefonoMonitoreoEntity, Serializable> {

    public abstract TelefonoMonitoreoEntity findByimei(String imei);

    public abstract TelefonoMonitoreoEntity findBynumeroTelefono(String numero);
    
    public abstract TelefonoMonitoreoEntity findBypersona(PersonaEntity persona);
}
