package com.educapae.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.educapae.model.Usuario;
import com.educapae.service.NegocioException;
import com.educapae.util.jpa.Transactional;

public class Usuarios implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	EntityManager manager = null;

	public Usuario porId(long id) {
		return this.manager.find(Usuario.class, id);
	}

	@Transactional
	public Usuario guardar(Usuario usu) {
		return this.manager.merge(usu);
	}

	@Transactional
	public void remover(Usuario usu) {
		try {
			Usuario temp = this.manager.find(Usuario.class, usu.getId());
			this.manager.remove(temp);
		} catch (PersistenceException ex) { 
			throw new NegocioException("Este usuário não pode ser excluído!");
		}
	}

	public List<Usuario> todos() {
		return this.manager.createQuery("from Usuario", Usuario.class)
				.getResultList();
	}

	public Usuario porNome(String nome) {
		return this.manager.createQuery("from Usuario where nome = :nome", Usuario.class)
				.setParameter("nome",nome).getSingleResult();
	}

}
