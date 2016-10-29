package br.cefetrj.scd.bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.cefetrj.scd.entity.Usuario;

@Stateless
public class UsuarioBean implements UsuarioBeanRemote {

	@PersistenceContext(unitName="SCDPU")
    EntityManager manager;
	
	public Usuario insert(Usuario usuario){
		manager.persist(usuario);
		return usuario;
	}
}
