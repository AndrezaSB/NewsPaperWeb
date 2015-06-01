package br.ufc.dao;

import java.util.List;

import br.ufc.model.Classificado;

public interface IClassificadoDAO {
	
	public void inserir(Classificado classificado);
	public void remover(Classificado classificado);
	public void atualizar(Classificado classificado);
	public List<Classificado> listar();
	public Classificado buscarClassificado(Long id);
	
}
