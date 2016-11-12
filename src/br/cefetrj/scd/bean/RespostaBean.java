package br.cefetrj.scd.bean;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import br.cefetrj.scd.entity.Pergunta;
import br.cefetrj.scd.entity.Resposta;
import br.cefetrj.scd.entity.Usuario;

@Stateless
public class RespostaBean implements RespostaBeanRemote {

	@PersistenceContext(unitName="SCDPU")
	private EntityManager manager;

	public boolean registrar(Usuario usuario, Pergunta pergunta, String descricao){
		manager.persist(new Resposta(usuario, pergunta, descricao));

		return true;
	}
	
	public Resposta getRespostaId(String id) {
		return manager.find(Resposta.class, Long.parseLong(id));
	}
	
	@SuppressWarnings("unchecked")
	public List<Resposta> getRespostas(String perguntaId) {
		try {
			return manager.createQuery("SELECT r FROM Resposta r WHERE pergunta_id = :perguntaId")
					.setParameter("perguntaId", Long.parseLong(perguntaId))
					.getResultList();

		} catch (NoResultException e) {
			return null;
		}
	}
}
