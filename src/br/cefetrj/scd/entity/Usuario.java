package br.cefetrj.scd.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	
	@OneToMany(targetEntity=Resposta.class)
	private List<Resposta> respostas;
	
	@OneToMany(targetEntity=Pergunta.class)
	private List<Pergunta> perguntas;
	
	@Column(nullable=false) private String nome;
	@Column(nullable=false) private String senha;
	@Column(nullable=false) private String email;
	@Column(nullable=false) private boolean isAdmin;
	
	private Integer reputacao;
	
	public Usuario() {}
	
	public Usuario(String nome, String senha, String email, boolean isAdmin) {
		this.nome = nome;
		this.senha = senha;
		this.email = email;
		this.isAdmin = isAdmin;
		
		this.reputacao = 0;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Integer getReputacao() {
		return reputacao;
	}
	
	public void setReputacao(Integer idade) {
		this.reputacao = idade;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public boolean isAdmin() {
		return isAdmin;
	}
	
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public List<Resposta> getRespostas() {
		return respostas;
	}

	public void setRespostas(List<Resposta> respostas) {
		this.respostas = respostas;
	}

	public List<Pergunta> getPerguntas() {
		return perguntas;
	}

	public void setPerguntas(List<Pergunta> perguntas) {
		this.perguntas = perguntas;
	}
}
