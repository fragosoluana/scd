package br.cefetrj.scd.bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
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
}
