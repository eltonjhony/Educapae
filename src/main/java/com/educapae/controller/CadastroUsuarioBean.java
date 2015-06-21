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
public class CadastroUsuarioBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private Usuarios usuarios;
	
	@Inject
	private Deficiencias deficiencias;
	
	private Usuario usuario;
	private List<Deficiencia> comboDeficiencia;
	
	public CadastroUsuarioBean() {
		this.limpar();
	}

	public void inicializar() {
		if(FacesUtil.isNotPostBack()) {
			this.comboDeficiencia = deficiencias.todos();
		}
	}

	public void salvarUsuario() {
		this.usuarios.guardar(usuario);
		FacesUtil.addInfoMessage("Usuário incluído com sucesso!");
		this.limpar();
	}

	private void limpar() {
		this.usuario = new Usuario();
		this.comboDeficiencia = new ArrayList<Deficiencia>();
		
	}

	
	public boolean isExistente() {
		return usuario.getId() != null;
	}

	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public List<Deficiencia> getComboDeficiencia() {
		return comboDeficiencia;
	}
	
}
