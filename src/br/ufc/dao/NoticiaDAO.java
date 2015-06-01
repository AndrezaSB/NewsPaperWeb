package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.ufc.model.Noticia;
import br.ufc.model.Usuario;

@Repository
public class NoticiaDAO implements INoticiaDAO{

	@PersistenceContext
	private EntityManager manager;
	
	public void inserirNoticia(Noticia noticia) {
		this.manager.persist(noticia);
		
	}

	public void removerNoticia(Noticia noticia) {
		this.manager.remove(this.manager.getReference(Noticia.class, noticia.getId()));
		
	}

	public void atualizarNoticia(Noticia noticia) {
		this.manager.merge(noticia);
		
	}

	public List<Noticia> listarNoticias() {
		List<Noticia> noticias = this.manager.createQuery("select n from Noticia n").getResultList();
		return noticias;
	}

	public Noticia buscarNoticia(Long id) {
		Noticia noticia = this.manager.find(Noticia.class, id);
		return noticia;
	}

}
