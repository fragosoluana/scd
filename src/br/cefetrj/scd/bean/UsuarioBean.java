package br.cefetrj.scd.bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.cefetrj.scd.entity.Usuario;

@Stateless(mappedName="ejb/UsuarioBeanJNDI")
public class UsuarioBean implements UsuarioBeanRemote {

	@PersistenceContext(unitName="SCDPU")
    EntityManager manager;
	
	public String registrar(Usuario usuario){
		manager.persist(usuario);
		
		return "Usuario cadastrado";
	}
}
