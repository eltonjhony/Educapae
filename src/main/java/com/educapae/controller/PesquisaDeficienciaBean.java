package com.educapae.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.educapae.model.Deficiencia;
import com.educapae.repository.Deficiencias;
import com.educapae.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaDeficienciaBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Deficiencias deficiencias;
	
	private Deficiencia deficiencia;
	private List<Deficiencia> listaDeficiencia;
	
	
	public PesquisaDeficienciaBean() {
		this.limpar();
	}
	
	private void limpar() {
		this.listaDeficiencia = new ArrayList<Deficiencia>();
		
	}
	
	public void pesquisar() {
		this.listaDeficiencia = deficiencias.todos();
	}

	public void excluirDeficiencia() {
		this.deficiencias.excluir(deficiencia);
		FacesUtil.addInfoMessage("Deficiência excluída com sucesso!");
		this.listaDeficiencia = deficiencias.todos();
	}

	public List<Deficiencia> getListaDeficiencia() {
		return listaDeficiencia;
	}
	
	public void setListaDeficiencia(List<Deficiencia> listaDeficiencia) {
		this.listaDeficiencia = listaDeficiencia;
	}
	
	public Deficiencia getDeficiencia() {
		return deficiencia;
	}
	
	public void setDeficiencia(Deficiencia deficiencia) {
		this.deficiencia = deficiencia;
	}

}
