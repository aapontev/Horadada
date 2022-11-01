package com.projecto.Horadada.Dao;


import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.projecto.Horadada.Entity.TablaMaestra;

@Repository("tablaMaestraDao")
public interface TablaMaestraDao extends CrudRepository<TablaMaestra, Serializable>{

	
	@Query(value="select  distinct t.idtablamaestra from tablamaestra t order by t.idtablamaestra asc" ,nativeQuery=true)
	public abstract List<String> gettablaMaestra();
	
	public abstract List<TablaMaestra> findByidTablaMaestra(String idtabla);
	

	public abstract TablaMaestra findByidTablaMaestraAndClave1(String idtabla, String clave1);

}
