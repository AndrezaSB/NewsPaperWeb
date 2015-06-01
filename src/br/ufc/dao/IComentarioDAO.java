package br.ufc.dao;

import java.util.List;

import br.ufc.model.Comentario;

public interface IComentarioDAO{

	public void inserir(Comentario comentario);
	public void remover(Comentario comentario);
	public void atualizar(Comentario comentario);
	public List<Comentario> listar();
	public Comentario buscarComentario(Long id);
	
}
