package br.ufc.dao;

import java.util.List;

import br.ufc.model.Comentario;

public interface IComentarioDAO{

	public void inserirComentario(Comentario comentario);
	public void removerComentario(Comentario comentario);
	public void atualizarComentario(Comentario comentario);
	public List<Comentario> listarComentarios();
	public Comentario buscarComentario(Long id);
	
}
