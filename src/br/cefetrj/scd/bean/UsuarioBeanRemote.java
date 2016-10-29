package br.cefetrj.scd.bean;

import javax.ejb.Remote;

import br.cefetrj.scd.entity.Usuario;

@Remote
public interface UsuarioBeanRemote {

	public Usuario insert(Usuario user);
}
