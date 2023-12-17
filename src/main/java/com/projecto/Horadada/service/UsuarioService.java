package com.projecto.Horadada.service;

import com.projecto.Horadada.Entity.UsuarioEntity;
import java.util.List;

public interface UsuarioService {
    public List<UsuarioEntity> listarTodos();
    public UsuarioEntity obtenerUno(String codigo);
    public UsuarioEntity insertar(UsuarioEntity ce);
    public void modificar(UsuarioEntity ce);
    public void eliminar(String codigo);
    
}
