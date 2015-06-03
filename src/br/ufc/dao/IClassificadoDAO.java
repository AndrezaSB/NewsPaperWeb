package br.ufc.dao;

import java.util.List;

import br.ufc.model.Classificado;

public interface IClassificadoDAO {
	
	public void inserirClassificado(Classificado classificado);
	public void removerClassificado(Classificado classificado);
	public void atualizarClassificado(Classificado classificado);
	public List<Classificado> listarClassificados();
	public Classificado buscarClassificado(Long id);
	
}
