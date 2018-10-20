package com.proclube.proclube.domain.enums;

public enum StatusEnum {
	
	ATIVO(1, "Ativo"),
	INATIVO(2, "Inativo");
	
	private int codigo;
	private String descricao;
	
	private StatusEnum (int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public int getCodigo() {
		return codigo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static StatusEnum toEnum (Integer codigo) {
		if (codigo == null) {
			return null;
		}
		
		for (StatusEnum status : StatusEnum.values()) {
			if(codigo.equals(status.getCodigo())) {
				return status;	
			}
		}
		throw new IllegalArgumentException("Id inválido: " + codigo);
	}
	
}
