package br.ufc.dao;

import java.util.List;

import br.ufc.model.Secao;

public interface ISecaoDAO {
	public void inserirSecao(Secao secao);
	public void removerSecao(Secao secao);
	public void atualizarSecao(Secao secao);
	public List<Secao> listarSecoes();
	public Secao buscarSecao(Long id);

}
