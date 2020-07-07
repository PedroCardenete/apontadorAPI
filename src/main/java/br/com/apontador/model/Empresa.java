package br.com.apontador.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Entity
@Table
public class Empresa implements Serializable{

	private static final long serialVersionUID = 1L;
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;

	@Column ( name = "typeempresaid")
	private Integer TypeEmpresaId = 1;

	@Column ( name = "Nome")
	@NotEmpty(message = "Campo nome não pode ser nulo")
	private String nome;

	@NotEmpty(message = "Campo logradouro não pode ser nulo")
	@Column( name = "Logradouro")
	private String logradouro;

	@NotEmpty(message = "Campo telefone não pode ser nulo")
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

	public Integer getTypeEmpresaId() {
		return TypeEmpresaId;
	}
	public void setTypeEmpresaId(Integer TypeEmpresaId) {
		this.TypeEmpresaId = TypeEmpresaId;
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

	public Empresa() {
	}

	public Empresa(Long id, Integer TypeEmpresaId, String nome, String logradouro, String telefone) {
		this.id = id;
		this.TypeEmpresaId = TypeEmpresaId;
		this.nome = nome;
		this.logradouro = logradouro;
		this.telefone = telefone;
	}

}
