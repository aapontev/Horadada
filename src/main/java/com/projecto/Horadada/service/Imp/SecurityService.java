package com.projecto.Horadada.service.Imp;

import com.projecto.Horadada.Dao.UsuarioDao;
import com.projecto.Horadada.Entity.UsuarioEntity;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SecurityService implements UserDetailsService {

    @Autowired
    private UsuarioDao urepo;

    @Override
    public UserDetails loadUserByUsername(String nombre) throws
            UsernameNotFoundException {
        UsuarioEntity ue = urepo.findById(nombre).get();
        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority("ROLE_"+ue.getIdroleusuario().getNombreRol())); //+ue.getIdroleusuario().getNombreRol()

        UserDetails udet = new User(ue.getNombreUsuario(), ue.getContrasena(), roles);
        return udet;
    }
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
