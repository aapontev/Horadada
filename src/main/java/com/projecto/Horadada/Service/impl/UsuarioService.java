package com.projecto.Horadada.Service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.projecto.Horadada.Entity.RoleUsuario;
import com.projecto.Horadada.Entity.Usuario;
import com.projecto.Horadada.Repository.UsuarioDao;

@Service("usuarioService")
public class UsuarioService implements UserDetailsService {

	@Autowired
	@Qualifier("usuarioDao")
	private UsuarioDao usuarioDao;
	
	//@Autowired
	//@Qualifier("tablamaestraDao")
	//private TablaMaestraDao tablamaestraDao;
	
	//private Tablamaestra rolUsu = tablamaestraDao.findByIdtablamaestra("Hora005");

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario user = usuarioDao.findByUsername(username);
		List<GrantedAuthority> authorities = buildAutorities(user.getRoleUsuario());
		return buildUser(user, authorities);
	}
	
	private User buildUser(Usuario user,List<GrantedAuthority>authorities) {
		
		return new User(user.getUsuario(), user.getContrasena(), user.isEstado(),
				true, true, true, authorities);		
	}
	
	private List<GrantedAuthority>buildAutorities (Set<RoleUsuario> userRoles){
		Set<GrantedAuthority> auths= new HashSet<GrantedAuthority>();
		for(RoleUsuario userRole : userRoles) {
			auths.add(new SimpleGrantedAuthority(userRole.getNombrerol()));
		}
		return new ArrayList<GrantedAuthority>(auths);
		
	}

}
