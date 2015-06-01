package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.ufc.model.Secao;

@Repository
public class SecaoDAO implements ISecaoDAO{
	
	@PersistenceContext
	private EntityManager manager;

	public void inserirSecao(Secao secao) {
		this.manager.persist(secao);
		
	}

	public void removerSecao(Secao secao) {
		this.manager.remove(this.manager.getReference(Secao.class, secao.getId()));
		
	}

	public void atualizarSecao(Secao secao) {
		this.manager.merge(secao);
		
	}

	public List<Secao> listarSecoes() {
		List<Secao> secoes = this.manager.createQuery("select s from Secao s").getResultList();
		return secoes;
	}

	public Secao buscarSecao(Long id) {
		Secao secao = this.manager.find(Secao.class, id);
		return secao;
	}
	

}
