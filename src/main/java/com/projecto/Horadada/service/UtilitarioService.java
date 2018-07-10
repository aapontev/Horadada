package com.projecto.Horadada.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.projecto.Horadada.Entity.Direccion;
import com.projecto.Horadada.Entity.Tablamaestra;
import com.projecto.Horadada.Entity.Telefono;
import com.projecto.Horadada.Entity.Tiposervicio;
import com.projecto.Horadada.Entity.Ubicacion;

public interface UtilitarioService {

	public abstract Page<Tiposervicio> findAllServ(Pageable pageable);
	public abstract Ubicacion getUbicacion(int iddespacho,int idtransportista);
	public abstract Ubicacion getUbicacionOne();
	public abstract Ubicacion save(Ubicacion ubi);	
	public abstract List<Tablamaestra> findByIdtablamaestra(String idTabla);
	public abstract List<String> gettablamaestra();
	public abstract List<Telefono> findByAll();
	public abstract Telefono save(Telefono telefono);
	public abstract Page<Telefono> findAllTel(Pageable pageable);
	public abstract Tiposervicio findByIdservicio(int id);
	public abstract Tiposervicio save(Tiposervicio servicio);
	public abstract void deleteServ(int id);
	public abstract Page<Direccion> findAllDir(Pageable pageRequest);
	public abstract Direccion findByIddireccion(int id);
	public abstract void deleteDire(int id);
	public abstract Direccion save(Direccion direccion);
	public abstract List<Tiposervicio> findByNombre(String term);
	public abstract List<Direccion> findAll();
}
