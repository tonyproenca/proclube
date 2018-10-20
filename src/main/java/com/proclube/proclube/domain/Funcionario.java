package com.proclube.proclube.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Funcionario extends Person{
	private static final long serialVersionUID = 1L;
	
	@Column(nullable=false, unique=true)
	private String login;
	
	@Column(nullable=false)
	private String senha;

}
