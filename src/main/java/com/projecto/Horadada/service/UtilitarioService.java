package com.projecto.Horadada.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.projecto.Horadada.Entity.Direccion;
import com.projecto.Horadada.Entity.TablaMaestra;
import com.projecto.Horadada.Entity.TelefonoMonitoreo;
import com.projecto.Horadada.Entity.TipoServicio;
import com.projecto.Horadada.Entity.Ubicacion;
import com.projecto.Horadada.Entity.Vehiculo;

public interface UtilitarioService {

	public abstract Page<TipoServicio> findAllServ(Pageable pageable);
	public abstract TipoServicio findByIdservicio(int id);
	public abstract TipoServicio save(TipoServicio servicio);
	public abstract void deleteServ(int id);
	public abstract List<TipoServicio> findByNombre(String term);
	
	public abstract Ubicacion getUbicacion(int iddespacho,int idtransportista);
	public abstract Ubicacion getUbicacionOne();
	public abstract Ubicacion save(Ubicacion ubi);	
	
	public abstract List<TablaMaestra> findByIdtablaMaestra(String idTabla);
	public abstract List<String> gettablamaestra();
	public abstract TablaMaestra findByidTablaMaestraAndClave1(String idTabla, String clave1);
	
	public abstract List<TelefonoMonitoreo> findByAll();
	public abstract TelefonoMonitoreo save(TelefonoMonitoreo telefono);
	public abstract Page<TelefonoMonitoreo> findAllTel(Pageable pageable);
	/*public abstract List<Telefono> findTelefonoByidPersona(int id);*/
	public abstract TelefonoMonitoreo findByimei(String imei);
	public abstract TelefonoMonitoreo findBynumerotelefono(String numero);
	
	public abstract Page<Direccion> findAllDir(Pageable pageRequest);
	public abstract Direccion findByIddireccion(int id);
	public abstract void deleteDire(int id);
	public abstract Direccion save(Direccion direccion);
	public abstract List<Direccion> findAll();
	
	public abstract Page<Vehiculo> findAll(Pageable pageRequest);
	public abstract Vehiculo findByidvehiculo(int id);
	public abstract void deleteVeh(int id);
	public abstract Vehiculo save(Vehiculo vehiculo);
}
