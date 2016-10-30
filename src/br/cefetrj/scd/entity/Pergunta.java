package br.cefetrj.scd.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Pergunta implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	@JoinColumn(referencedColumnName="id", nullable=false)
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(referencedColumnName="id", nullable=false)
	private Tema tema;
	
	@OneToMany(targetEntity=Resposta.class)
	private List<Resposta> respostas;
	
	@Column(nullable=false) private String descricao;

	public Pergunta() {}
	
	public Pergunta(Usuario usuario, Tema tema, String descricao) {
		this.usuario = usuario;
		this.tema = tema;
		this.descricao = descricao;
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	public List<Resposta> getRespostas() {
		return respostas;
	}

	public void setRespostas(List<Resposta> respostas) {
		this.respostas = respostas;
	}
}
