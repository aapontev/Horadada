package com.projecto.Horadada.Dao;

import com.projecto.Horadada.Entity.RoleUsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleUsuarioDao extends JpaRepository<RoleUsuarioEntity, Integer> {
    
}
