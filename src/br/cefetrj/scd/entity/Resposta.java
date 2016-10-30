package br.cefetrj.scd.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Resposta implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	@JoinColumn(referencedColumnName="id", nullable=false)
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(referencedColumnName="id", nullable=false)
	private Pergunta pergunta;
	
	@Column(nullable=false) private String descricao;

	public Resposta() {}
	
	public Resposta(Usuario usuario, Pergunta pergunta, String descricao) {
		super();
		this.usuario = usuario;
		this.pergunta = pergunta;
		this.descricao = descricao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Pergunta getPergunta() {
		return pergunta;
	}

	public void setPergunta(Pergunta pergunta) {
		this.pergunta = pergunta;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
