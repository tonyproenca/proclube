package com.proclube.proclube.domain.enums;

public enum TipoAssociadoEnum {
	
	DEPENDENTE(1, "Dependente"),
	PATROCIONADOR(2, "Patrocinador"),
	RESPONSAVEL(3, "Responsável");
	
	private int codigo;
	private String descricao;
	
	private TipoAssociadoEnum (int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public int getCodigo() {
		return codigo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static TipoAssociadoEnum toEnum (Integer codigo) {
		if (codigo == null) {
			return null;
		}
		
		for (TipoAssociadoEnum tipo : TipoAssociadoEnum.values()) {
			if(codigo.equals(tipo.getCodigo())) {
				return tipo;	
			}
		}
		throw new IllegalArgumentException("Id inválido: " + codigo);
	}
	
}
