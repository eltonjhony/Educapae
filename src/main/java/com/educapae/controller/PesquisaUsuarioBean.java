package com.educapae.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.educapae.model.Deficiencia;
import com.educapae.model.Usuario;
import com.educapae.repository.Deficiencias;
import com.educapae.repository.Usuarios;
import com.educapae.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaUsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Usuarios usuarios;
	
	@Inject
	private Deficiencias deficiencias;
	
	private Usuario usuario;
	private List<Usuario> listaUsuarios;
	private List<Deficiencia> todasDeficiencias;
	
	public void inicializar() {
		if(FacesUtil.isNotPostBack()) {
			this.todasDeficiencias = deficiencias.todos();
		}
	}
	
	public PesquisaUsuarioBean() {
		this.limpar();
	}
	
	private void limpar() {
		this.usuario = new Usuario();
		this.listaUsuarios = new ArrayList<Usuario>();
		this.todasDeficiencias = new ArrayList<Deficiencia>();
	}
	
	public void pesquisar() {
		this.listaUsuarios = this.usuarios.todos();
	}
	
	public void excluir() {
		this.usuarios.remover(usuario);
		FacesUtil.addInfoMessage("Usuário excluído com sucesso!");
		this.listaUsuarios = usuarios.todos();
	}

	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}
	
	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}
	
	public List<Deficiencia> getTodasDeficiencias() {
		return todasDeficiencias;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
