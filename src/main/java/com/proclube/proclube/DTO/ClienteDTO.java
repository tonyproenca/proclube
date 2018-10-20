package com.proclube.proclube.DTO;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.proclube.proclube.domain.Cliente;

public class ClienteDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	@NotEmpty(message="Preenchimento obrigatorio")
	@Length(min=5, max=120, message="O tamanho deve ser entre 5 e 120 caracteres")
	private String firstName;
	
	@NotEmpty(message="Preenchimento obrigatorio")
	@Length(min=5, max=120, message="O tamanho deve ser entre 5 e 120 caracteres")
	private String lastName;
	
	@Email(message="Email inválido")
	private String mail;
	
	private String tipo;
	
	public ClienteDTO() {}

	/**
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param mail
	 * @param tipo
	 */
	public ClienteDTO(Cliente cliente){
		this.id = cliente.getId();
		this.firstName = cliente.getFirstName();
		this.lastName = cliente.getLastName();
		this.mail = cliente.getMail();
		this.tipo = cliente.getTipoAssociadoEnum().getDescricao();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	

}
