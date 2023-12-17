package com.projecto.Horadada.service.Imp;

import com.projecto.Horadada.Dao.UsuarioDao;
import com.projecto.Horadada.Entity.UsuarioEntity;
import com.projecto.Horadada.service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("usuarioServiceImp")
public class UsuarioServiceImp implements UsuarioService{

    @Autowired
    private UsuarioDao usuarioRepository;
    
    @Override
    public List<UsuarioEntity> listarTodos() {
        return usuarioRepository.findAll();
    }

    @Override
    public UsuarioEntity obtenerUno(String codigo) {
        return usuarioRepository.findById(codigo).orElse(new UsuarioEntity());
    }

    @Override
    public UsuarioEntity insertar(UsuarioEntity ce) {
       return usuarioRepository.save(ce);
    }

    @Override
    public void modificar(UsuarioEntity ce) {
        usuarioRepository.save(ce);
    }

    @Override
    public void eliminar(String codigo) {
        usuarioRepository.deleteById(codigo);
    }

 
}
