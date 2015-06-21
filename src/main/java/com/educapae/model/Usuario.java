package com.educapae.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private String sexo;
	private Date dataNascimento;
	private String tipo;
	private String telefone;
	private String nomeUsuario;
	private String senha;
	private String responsavel;
	private int grauDeficiencia;
	private Deficiencia deficiencia = new Deficiencia();

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="nome",length=30, nullable=false)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name="sexo",length=2,nullable=false)
	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_nascimento",nullable=false)
	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	@Column(name="tipo",length=20,nullable=false)
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Column(name="fone",length=30)
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Column(name="nome_usuario",length=20,nullable=false)
	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	@Column(name="senha",length=32,nullable=false)
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Column(name="responsavel",length=30)
	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	@Column(name="grau_deficiencia")
	public int getGrauDeficiencia() {
		return grauDeficiencia;
	}

	public void setGrauDeficiencia(int grauDeficiencia) {
		this.grauDeficiencia = grauDeficiencia;
	}

	@ManyToOne
	@JoinColumn(name="deficiencia_id")
	public Deficiencia getDeficiencia() {
		return deficiencia;
	}

	public void setDeficiencia(Deficiencia deficiencia) {
		this.deficiencia = deficiencia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		Usuario other = (Usuario) obj;
		if (id != other.id)
			return false;
		return true;
	}

	
	

}
