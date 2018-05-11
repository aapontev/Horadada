package com.projecto.Horadada.Dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.projecto.Horadada.Entity.Tablamaestra;

@Repository("tablaMaestraDao")
public interface TablaMaestraDao extends CrudRepository<Tablamaestra, Serializable>{

	public abstract List<Tablamaestra> findByIdtablamaestra(String idTabla);
	
	@Query(value="select  distinct descripcion from tablamaestra",nativeQuery=true)
	public abstract List<String> getdescripcion();
}
