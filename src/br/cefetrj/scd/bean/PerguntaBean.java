package br.cefetrj.scd.bean;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import br.cefetrj.scd.entity.Pergunta;
import br.cefetrj.scd.entity.Tema;
import br.cefetrj.scd.entity.Usuario;

@Stateless
public class PerguntaBean implements PerguntaBeanRemote {

	@PersistenceContext(unitName="SCDPU")
	private EntityManager manager;

	public boolean registrar(Usuario usuario, Tema tema, String descricao){
		manager.persist(new Pergunta(usuario, tema, descricao));

		return true;
	}
	
	public Pergunta getPerguntaId(String id) {
		return manager.find(Pergunta.class, Long.parseLong(id));
	}

	@SuppressWarnings("unchecked")
	public List<Pergunta> getPerguntas() {
		try {
			return manager.createQuery("SELECT p FROM Pergunta p")
					.getResultList();

		} catch (NoResultException e) {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Pergunta> getPerguntasUsuarioId(String usuarioId) {
		try {
			return manager.createQuery("SELECT p FROM Pergunta p WHERE p.usuario_id = :usuarioId")
					.setParameter("usuarioId", Long.parseLong(usuarioId))
					.getResultList();

		} catch (NoResultException e) {
			return null;
		}
	}
}
