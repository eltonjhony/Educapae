package com.educapae.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import com.educapae.model.Deficiencia;
import com.educapae.util.jpa.Transactional;

public class Deficiencias implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public Deficiencia porId(long id) {
		return manager.find(Deficiencia.class, id);
	}

	@Transactional
	public Deficiencia salvar(Deficiencia deficiencia) {
		return this.manager.merge(deficiencia);
	}

	@Transactional
	public void excluir(Deficiencia deficiencia) {
		Deficiencia temp = this.manager.find(Deficiencia.class, deficiencia.getId());
		this.manager.remove(temp);
	}

	public List<Deficiencia> todos() {
		return this.manager.createQuery("from Deficiencia", Deficiencia.class)
				.getResultList();
	}

}
