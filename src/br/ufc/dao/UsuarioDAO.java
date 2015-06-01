package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.ufc.model.Usuario;

@Repository
public class UsuarioDAO implements IUsuarioDAO {

	@PersistenceContext
	private EntityManager manager;
	
	public void inserir(Usuario usuario) {
		this.manager.persist(usuario);
		
	}

	public void remover(Usuario usuario) {
		this.manager.remove(this.manager.getReference(Usuario.class, usuario.getId()));
		
	}

	public void atualizar(Usuario usuario) {
		this.manager.merge(usuario);
		
	}

	public List<Usuario> listar() {
		List<Usuario> usuarios = this.manager.createQuery("select u from Usuario u").getResultList();
		return usuarios;
	}

	public Usuario buscarUsuario(Long id) {
		Usuario usuario = this.manager.find(Usuario.class, id);
		return usuario;
	}

	public Usuario buscarUsuarioLogin(String login) {
		Usuario usuario = this.manager.find(Usuario.class, login);
		return usuario;
	}
}
