package br.cefetrj.scd.bean;

import java.util.List;

import javax.ejb.Remote;

import br.cefetrj.scd.entity.Pergunta;
import br.cefetrj.scd.entity.Tema;
import br.cefetrj.scd.entity.Usuario;

@Remote
public interface PerguntaBeanRemote {

	public boolean registrar(Usuario usuario, Tema tema, String descricao);
	public Pergunta getPerguntaId(String id);
	public List<Pergunta> getPerguntas();
	public List<Pergunta> getPerguntasUsuarioId(String usuarioId);
	
}
