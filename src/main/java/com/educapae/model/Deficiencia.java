package com.educapae.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "deficiencias")
public class Deficiencia implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private String descricao;
	private List<Usuario> lista;
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idDeficiencia")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name="nome", length=30, nullable=false)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name="descricao", length=50)
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@OneToMany(mappedBy="deficiencia", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	public List<Usuario> getLista() {
		return lista;
	}
	
	public void setLista(List<Usuario> lista) {
		this.lista = lista;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Deficiencia other = (Deficiencia) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
