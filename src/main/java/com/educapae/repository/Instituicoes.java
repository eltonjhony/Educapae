package com.educapae.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.educapae.model.Instituicao;
import com.educapae.util.jpa.Transactional;



public class Instituicoes implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;


	public Instituicao guardar(Instituicao instituicao) {
		return this.manager.merge(instituicao);
	}


	public List<Instituicao> todos() {
		return this.manager.createQuery("From Instituicao", Instituicao.class)
				.getResultList();
	}

	@Transactional
	public void excluir(Instituicao instituicao) {
		Instituicao temp = this.manager.find(Instituicao.class, instituicao.getCodigo());
		this.manager.remove(temp);
	}

	public Instituicao porId(Long id) {
		return this.manager.find(Instituicao.class, id);
	}

}
