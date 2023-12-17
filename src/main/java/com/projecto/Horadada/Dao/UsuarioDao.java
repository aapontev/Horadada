package com.projecto.Horadada.Dao;

import com.projecto.Horadada.Entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDao extends JpaRepository<UsuarioEntity, String> {
    
}
