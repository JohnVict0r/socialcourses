package com.startworksgroup.socialcourses.domain;

public enum TipoCurso {

	TECNICO("Técnico"),
	GRADUACAO("Graduação"),
	POSGRADUACAO("Pós-Graduação");
	
	private String descricao;

	private TipoCurso(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
