package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.ufc.model.Role;

@Repository
public class RoleDAO implements IRoleDAO{

	@PersistenceContext
	private EntityManager manager;
	
	public void inserirRole(Role role) {
		this.manager.persist(role);	
	
	}

	public void removerRole(Role role) {
		this.manager.remove(this.manager.getReference(Role.class, role.getId()));
		
	}

	public void atualizarRole(Role role) {
		this.manager.merge(role);
		
	}

	public List<Role> listarRoles() {
		List<Role> roles = this.manager.createQuery("select r from Role r").getResultList();
		return roles;
	}

	public Role buscarRole(Long id) {
		Role role = this.manager.find(Role.class, id);
		return role;
	}
	
	public Role buscarRoleNome(String role) {
		Role r = this.manager.find(Role.class, role);
		return r;
	}
}
