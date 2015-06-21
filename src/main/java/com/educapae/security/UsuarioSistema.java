package com.educapae.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.educapae.model.Usuario;

public class UsuarioSistema extends User {

	private static final long serialVersionUID = 1L;
	
	static Collection<? extends GrantedAuthority> authorities = null;
	
	private Usuario usuario;
	
	public UsuarioSistema(Usuario usuario) {
		super(usuario.getNome(), usuario.getSenha(), authorities);
		this.usuario = usuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

}
