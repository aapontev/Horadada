package com.projecto.Horadada.Repository;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.projecto.Horadada.Entity.Tablamaestra;

@Repository("tablaMaestraDao")
public interface TablaMaestraDao extends JpaRepository<Tablamaestra, Serializable>{
	
	public abstract Tablamaestra findByIdtablamaestra(String idtablamaestra);
}
