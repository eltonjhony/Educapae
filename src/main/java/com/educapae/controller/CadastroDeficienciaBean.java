package com.educapae.controller;

import java.io.Serializable;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.educapae.model.Deficiencia;
import com.educapae.repository.Deficiencias;
import com.educapae.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroDeficienciaBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private Deficiencias deficiencias;

	private Deficiencia deficiencia;
	
	public CadastroDeficienciaBean() {
		this.limpar();
	}

	public void salvar() {
		this.deficiencias.salvar(deficiencia);
		FacesUtil.addInfoMessage("Deficiencia incluída com sucesso!");
		this.limpar();
	}

	private void limpar() {
		this.deficiencia = new Deficiencia();
	}

	public boolean isExistente() {
		return deficiencia.getId() != null;
	}
	
	public Deficiencia getDeficiencia() {
		return deficiencia;
	}
	
	public void setDeficiencia(Deficiencia deficiencia) {
		this.deficiencia = deficiencia;
	}

}
