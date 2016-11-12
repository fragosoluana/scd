package br.cefetrj.scd.bean;

import javax.ejb.Remote;

import br.cefetrj.scd.entity.Usuario;

@Remote
public interface UsuarioBeanRemote {

	public boolean registrar(String nome, String senha, String email, boolean isAdmin);
	public Usuario getUsuarioEmail(String email);
	public Usuario login(String email, String senha);
	public Usuario getUsuarioId(String id);
}
