package com.educapae.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.educapae.model.Instituicao;
import com.educapae.repository.Instituicoes;

@Named
@ViewScoped
public class PesquisaInstituicaoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Instituicoes instituicoes;
	
	private List<Instituicao> listaInstituicoes;
	
	
	public PesquisaInstituicaoBean() {
		this.limpar();
	}
	
	private void limpar() {
		this.listaInstituicoes = new ArrayList<Instituicao>();
	}
	
	public void pesquisar() {
		this.listaInstituicoes = instituicoes.todos();
	}



	public List<Instituicao> getListaInstituicoes() {
		return listaInstituicoes;
	}
	
	public void setListaInstituicoes(List<Instituicao> listaInstituicoes) {
		this.listaInstituicoes = listaInstituicoes;
	}

}
