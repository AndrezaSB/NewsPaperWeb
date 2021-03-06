package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.ufc.model.Classificado;

@Repository
public class ClassificadoDAO implements IClassificadoDAO{

	@PersistenceContext
	private EntityManager manager;
	
	public void inserirClassificado(Classificado classificado) {
		this.manager.persist(classificado);
		
	}

	public void removerClassificado(Classificado classificado) {
		this.manager.remove(this.manager.getReference(Classificado.class, classificado.getId()));
		
	}

	public void atualizarClassificado(Classificado classificado) {
		this.manager.merge(classificado);
		
	}

	public List<Classificado> listarClassificados() {
		List<Classificado> classificados = this.manager.createQuery("select c from Classificado c").getResultList();
		return classificados;
	}

	public Classificado buscarClassificado(Long id) {
		Classificado classificado = this.manager.find(Classificado.class, id);
		return classificado;
	}

}
