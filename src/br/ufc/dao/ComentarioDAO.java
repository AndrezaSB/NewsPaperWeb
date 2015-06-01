package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.ufc.model.Comentario;

@Repository
public class ComentarioDAO implements IComentarioDAO {


	@PersistenceContext
	private EntityManager manager;
	
	public void inserir(Comentario comentario) {
		this.manager.persist(comentario);
		
	}

	public void remover(Comentario comentario) {
		this.manager.remove(this.manager.getReference(Comentario.class, comentario.getId()));
		
	}

	public void atualizar(Comentario comentario) {
		this.manager.merge(comentario);
		
	}

	public List<Comentario> listar() {
		List<Comentario> comentarios = this.manager.createQuery("select c from Comentario c").getResultList();
		return comentarios;
	}

	public Comentario buscarComentario(Long id) {
		Comentario comentario = this.manager.find(Comentario.class, id);
		return comentario;
	}

	
}
