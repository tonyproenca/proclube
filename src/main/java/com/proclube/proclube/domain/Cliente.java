package com.proclube.proclube.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.proclube.proclube.domain.enums.TipoAssociadoEnum;

@Entity
@JsonTypeName("cliente")
public class Cliente extends Person{
	private static final long serialVersionUID = 1L;

	@Column(nullable=false)
	private TipoAssociadoEnum tipoAssociadoEnum;
	
	@Column(nullable=false)
	private String banco;
	
	@Column(nullable=false)
	private String agencia;
	
	@Column(nullable=false)
	private String conta;
	
	private Long responsavelId;
	
	public Cliente() {}

	public Cliente(Long id, String firstName, String lastName, @CPF String cpf, String rg, @Email String mail,
			TipoAssociadoEnum tipoAssociadoEnum, String banco, String agencia, String conta) {
		super(id, firstName, lastName, cpf, rg, mail);
		this.tipoAssociadoEnum = tipoAssociadoEnum;
		this.banco = banco;
		this.agencia = agencia;
		this.conta = conta;
		this.responsavelId = null;
	}

	public TipoAssociadoEnum getTipoAssociadoEnum() {
		return tipoAssociadoEnum;
	}

	public void setTipoAssociadoEnum(TipoAssociadoEnum tipoAssociadoEnum) {
		this.tipoAssociadoEnum = tipoAssociadoEnum;
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

	@Override
	public String toString() {
		return "Cliente [banco=" + banco + ", agencia=" + agencia + ", conta=" + conta + ", getId()=" + getId()
				+ ", getFirstName()=" + getFirstName() + ", getLastName()=" + getLastName() + ", getCpf()=" + getCpf()
				+ ", getRg()=" + getRg() + ", getMail()=" + getMail() + ", getEndereco()=" + getEndereco() + "]";
	}
	
	public Long getResponsavel() {
		return responsavelId;
	}
	
	public void setResponsavel(Long responsavel) {
		this.responsavelId = responsavel;
	}
	
}
