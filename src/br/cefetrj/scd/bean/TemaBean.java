package br.cefetrj.scd.bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import br.cefetrj.scd.entity.Tema;

@Stateless
public class TemaBean implements TemaBeanRemote {

	@PersistenceContext(unitName="SCDPU")
	private EntityManager manager;

	public boolean registrar(String nome){
		if(!isTemaExistente(nome)) {
			manager.persist(new Tema(nome));
			return true;
		} else {
			return false;
		}
	}

	public boolean isTemaExistente(String nome) {
		try {
			manager.createQuery("SELECT t FROM Tema t WHERE t.nome = :nome")
			.setParameter("nome", nome)
			.getSingleResult();

			return true;
		} catch (NoResultException e) {
			return false;
		}
	}
	
	public Tema getTemaNome(String nome) {
		try {
			return (Tema) manager.createQuery("SELECT t FROM Tema t WHERE t.nome = :nome")
			.setParameter("nome", nome)
			.getSingleResult();

		} catch (NoResultException e) {
			return null;
		}
	}
	
	public Tema getTemaId(String id) {
		return manager.find(Tema.class, Long.parseLong(id));
	}
}
