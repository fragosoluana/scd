package br.cefetrj.scd.bean;

import javax.ejb.Remote;

import br.cefetrj.scd.entity.Pergunta;
import br.cefetrj.scd.entity.Resposta;
import br.cefetrj.scd.entity.Usuario;

@Remote
public interface RespostaBeanRemote {

	public boolean registrar(Usuario usuario, Pergunta pergunta, String descricao);
	public Resposta getRespostaId(String id);
	
}
