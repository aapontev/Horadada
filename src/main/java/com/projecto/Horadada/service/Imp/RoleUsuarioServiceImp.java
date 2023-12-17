package com.projecto.Horadada.service.Imp;

import com.projecto.Horadada.Dao.RoleUsuarioDao;
import com.projecto.Horadada.Entity.RoleUsuarioEntity;
import com.projecto.Horadada.service.RoleUsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("roleUsuarioServiceImp")
public class RoleUsuarioServiceImp implements RoleUsuarioService {

    
    @Autowired
    private RoleUsuarioDao roleUsuarioRepository;
    
    @Override
    public List<RoleUsuarioEntity> listarTodos() {
        return roleUsuarioRepository.findAll();
    }

    @Override
    public RoleUsuarioEntity obtenerUno(int codigo) {
        return roleUsuarioRepository.findById(codigo).get();
    }

    @Override
    public void insertar(RoleUsuarioEntity ce) {
        roleUsuarioRepository.save(ce);
    }

    @Override
    public void modificar(RoleUsuarioEntity ce) {
        roleUsuarioRepository.save(ce);
    }

    @Override
    public void eliminar(int codigo) {
        roleUsuarioRepository.deleteById(codigo); 
    }
    
    
}
