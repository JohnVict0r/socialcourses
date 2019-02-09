package com.startworksgroup.socialcourses.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name="curso")
public class Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "O campo nome não pode ser vazio!")
	private String nome;
	
	@JsonInclude(Include.NON_NULL)
	@ManyToOne
	private Instituicao instituicao;

	@JsonInclude(Include.NON_NULL)
	@OneToMany(mappedBy = "curso")
	private List<Comentario> comentarios;

	@Enumerated(EnumType.STRING)
	private TipoCurso nivel;

	private int curtidas;

	// for deserialisation
	public Curso() {} 
	
	
	public Curso(String nome) {
		this.nome = nome;
	}

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

	public Instituicao getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
	}
	
	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public TipoCurso getNivel() {
		return nivel;
	}

	public void setNivel(TipoCurso nivel) {
		this.nivel = nivel;
	}
	
	public int getCurtidas() {
		return curtidas;
	}

	public void setCurtidas(int curtidas) {
		this.curtidas = curtidas;
	}

}