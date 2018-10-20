package com.proclube.proclube.DTO;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import com.proclube.proclube.services.validation.ClienteInsert;

@ClienteInsert
public class ClienteNewDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message="Preenchimento obrigatorio")
	@Length(min=2, max=60, message="O tamanho deve ser entre 5 e 120 caracteres")
	private String firstName;
	
	@NotEmpty(message="Preenchimento obrigatorio")
	@Length(min=2, max=60, message="O tamanho deve ser entre 5 e 120 caracteres")
	private String lastName;
	
	@CPF
	@NotEmpty(message="Preenchimento obrigatorio")
	private String cpf;
	
	@NotEmpty(message="Preenchimento obrigatorio")
	private String rg;
	
	@NotEmpty(message="Preenchimento obrigatorio")
	private String email;
	
	@NotEmpty(message="Preenchimento obrigatorio")
	private String logradouro;
	
	@NotEmpty(message="Preenchimento obrigatorio")
	private String numero;
	private String complemento;
	
	@NotEmpty(message="Preenchimento obrigatorio")
	private String bairro;
	
	@NotEmpty(message="Preenchimento obrigatorio")
	private String cep;

	private Integer cidadeId;
	
	@NotEmpty(message="Preenchimento obrigatorio")
	private String telefone1;
	private String telefone2;
	private String telefone3;
	
	private Integer tipo;
	
	@NotEmpty(message="Preenchimento obrigatorio")
	private String banco;
	
	@NotEmpty(message="Preenchimento obrigatorio")
	private String agencia;
	
	@NotEmpty(message="Preenchimento obrigatorio")
	private String conta;
	
	public ClienteNewDTO() {}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
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

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Integer getCidadeId() {
		return cidadeId;
	}

	public void setCidadeId(Integer cidadeId) {
		this.cidadeId = cidadeId;
	}

	public String getTelefone1() {
		return telefone1;
	}

	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}

	public String getTelefone2() {
		return telefone2;
	}

	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}

	public String getTelefone3() {
		return telefone3;
	}

	public void setTelefone3(String telefone3) {
		this.telefone3 = telefone3;
	}
	
	public Integer getTipo() {
		return tipo;
	}
	
	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getConta() {
		return conta;
	}

	public void setConta(String conta) {
		this.conta = conta;
	}
	
	

}
