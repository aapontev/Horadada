package com.projecto.Horadada.Dao;

import java.io.Serializable;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.projecto.Horadada.Entity.TelefonoMonitoreo;

@Repository("telefonodao")
public interface TelefonoDao extends PagingAndSortingRepository<TelefonoMonitoreo, Serializable> {

/*
	public abstract List<Telefono> findTelefonoByidPersona(int id);*/
	public abstract TelefonoMonitoreo findByimei(String imei);
	public abstract TelefonoMonitoreo findBynumeroTelefono(String numero);
}
