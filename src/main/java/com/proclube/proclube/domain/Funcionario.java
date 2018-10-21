package com.proclube.proclube.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Funcionario extends Person{
	private static final long serialVersionUID = 1L;
	
	@Column(nullable=false, unique=true)
	private String login;
	
	@Column(nullable=false)
	@JsonIgnore
	private String senha;
	
	public Funcionario (){}

	/**
	 * @param login
	 * @param senha
	 *
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param cpf
	 * @param rg
	 * @param mail
	 */
	public Funcionario(Long id, String firstName, String lastName, @CPF String cpf, String rg, @Email String mail, String login, String senha) {
		super(id, firstName, lastName, cpf, rg, mail);
		this.login = login;
		this.senha = senha;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
