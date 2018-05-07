package com.projecto.Horadada.Repository;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.projecto.Horadada.Entity.Usuario;

@Repository("usuarioDao")
public interface UsuarioDao extends JpaRepository<Usuario, Serializable> {

	public abstract Usuario findByUsername(String username);
}
