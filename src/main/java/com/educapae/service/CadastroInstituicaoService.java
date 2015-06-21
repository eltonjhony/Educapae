package com.educapae.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.educapae.model.Instituicao;
import com.educapae.repository.Instituicoes;
import com.educapae.util.jpa.Transactional;

public class CadastroInstituicaoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Instituicoes instituicoes;
	

	@Transactional
	public Instituicao salvar(Instituicao instituicao) {
		
		if (jaExiste() && instituicao.getCodigo() == null ) {
			throw new NegocioException("Já existe uma instituição cadastrada.");
		}
		
		return this.instituicoes.guardar(instituicao);
		
	}

	private boolean jaExiste() {
		return this.instituicoes.todos().size() > 0;
	}
}
