package com.educapae.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name ="Instituicao")
public class Instituicao implements Serializable {
	

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "inst_condigo")
	private Long codigo;

	@Column(name = "razao_social", length = 200)
	private String razaoSocial;

	@Column(name = "nome_fantasia", length = 200)
	private String nomeFantasia;

	@Column(name = "cnpj", length = 50, nullable = true)
	private String cnpj;

	@Column(name = "inscricao_estadual", length = 50)
	private String inscricaoEstadual;

	@Column(name = "telefone", length = 50)
	private String telefone;

	@Column(name = "email", length = 50)
	private String email;

	@Column(name = "logadouro", length = 50)
	private String logradouro;

	@Column(name = "bairro", length = 50)
	private String bairro;

	@Column(name = "numero", length = 50)
	private int numero;

	@Column(name = "cidade", length = 50)
	private String cidade;

	@Column(name = "nome_diretor", length = 50)
	private String nomeDiretor;

	@Column(name = "logotipo", length = 50)
	private String logotipo;

	@Column(name = "uf", length = 50)
	private String uf;

	@Column(name = "complemento", length = 50)
	private String complemento;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getNomeDiretor() {
		return nomeDiretor;
	}

	public void setNomeDiretor(String nomeDiretor) {
		this.nomeDiretor = nomeDiretor;
	}

	public String getLogotipo() {
		return logotipo;
	}

	public void setLogotipo(String logotipo) {
		this.logotipo = logotipo;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		Instituicao other = (Instituicao) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	

	private Long editando;
	
	@Transient
	public Long getEditando() {
		return editando;
	}
	
	public void setEditando(Long editando) {
		this.editando = editando;
	}
 

	
	

}
