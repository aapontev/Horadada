package com.projecto.Horadada.Dao;


import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.projecto.Horadada.Entity.TablaMaestraEntity;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository("tablaMaestraDao")
public interface TablaMaestraDao extends JpaRepository<TablaMaestraEntity, Serializable>{

	
	@Query(value="select  distinct t.idtablamaestra from tablamaestra t order by t.idtablamaestra asc" ,nativeQuery=true)
	public abstract List<String> gettablaMaestra();
	
	public abstract List<TablaMaestraEntity> findByidTablaMaestra(String idtabla);

	public abstract TablaMaestraEntity findByidTablaMaestraAndClave1(String idtabla, String clave1);

}
