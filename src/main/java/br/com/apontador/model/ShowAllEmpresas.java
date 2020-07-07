package br.com.apontador.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "showallempresas")
public class ShowAllEmpresas implements Serializable{

	private static final long serialVersionUID = 1L;
		
	@Id
	private Long id;
	@Column ( name = "Tipo")
	private String tipo;
	@Column ( name = "Nome")
	private String nome;
	@Column( name = "Logradouro")
	private String logradouro;
	@Column( name = "Telefone")
	private String telefone;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTypeEmpresaId() {
		return tipo;
	}
	public void setTypeEmpresaId(String tipo) {
		this.tipo = tipo;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public ShowAllEmpresas() {
	}

	public ShowAllEmpresas(Long id, String tipo, String nome, String logradouro, String telefone) {
		this.id = id;
		this.tipo = tipo;
		this.nome = nome;
		this.logradouro = logradouro;
		this.telefone = telefone;
	}

}
