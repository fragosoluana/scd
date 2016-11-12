package br.cefetrj.scd.bean;

import javax.ejb.Remote;

import br.cefetrj.scd.entity.Tema;

@Remote
public interface TemaBeanRemote {
	
	public boolean registrar(String nome);
	public Tema getTemaId(String id);
	public Tema getTemaNome(String nome);

}
