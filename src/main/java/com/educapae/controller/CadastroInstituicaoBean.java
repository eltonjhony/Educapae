package com.educapae.controller;

import java.io.Serializable;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.educapae.model.Instituicao;
import com.educapae.service.CadastroInstituicaoService;
import com.educapae.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroInstituicaoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CadastroInstituicaoService cadastroInstituicaoService;

	private Instituicao instituicao;
	
	public CadastroInstituicaoBean() {
		this.limpar();
	}

	public void salvar() {
		this.cadastroInstituicaoService.salvar(instituicao);
		FacesUtil.addInfoMessage("Instituição incluída com sucesso!");
		this.limpar();
	}

	private void limpar() {
		this.instituicao = new Instituicao();
	}

	public boolean isExistente() {
		return instituicao.getCodigo() != null;
	}
	
	public Instituicao getInstituicao() {
		return instituicao;
	}
	
	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
	}

}
