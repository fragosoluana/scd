package br.cefetrj.scd.bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
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

}
