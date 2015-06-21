package com.educapae.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.educapae.model.Usuario;
import com.educapae.repository.Usuarios;
import com.educapae.util.cdi.CDIServiceLocator;

public class AppUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String nome) throws UsernameNotFoundException {
		Usuarios usuarios = CDIServiceLocator.getBean(Usuarios.class);
		Usuario usuario = usuarios.porNome(nome);
		
		UsuarioSistema user = null;
		
		if (usuario != null) {
			user = new UsuarioSistema(usuario);
		}
		
		return user;
	}

}
