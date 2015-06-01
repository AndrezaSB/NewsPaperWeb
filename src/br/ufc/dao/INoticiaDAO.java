package br.ufc.dao;

import java.util.List;

import br.ufc.model.Noticia;

public interface INoticiaDAO {
	
	public void inserirNoticia(Noticia noticia);
	public void removerNoticia(Noticia noticia);
	public void atualizarNoticia(Noticia noticia);
	public List<Noticia> listarNoticias();
	public Noticia buscarNoticia(Long id);
	
}
