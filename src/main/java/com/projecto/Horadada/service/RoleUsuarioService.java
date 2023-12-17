package com.projecto.Horadada.service;

import com.projecto.Horadada.Entity.RoleUsuarioEntity;
import java.util.List;

public interface RoleUsuarioService {
    
    public List<RoleUsuarioEntity> listarTodos();
    public RoleUsuarioEntity obtenerUno(int codigo);
    public void insertar(RoleUsuarioEntity ce);
    public void modificar(RoleUsuarioEntity ce);
    public void eliminar(int codigo);
}
