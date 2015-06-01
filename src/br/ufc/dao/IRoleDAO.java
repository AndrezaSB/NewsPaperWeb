package br.ufc.dao;

import java.util.List;

import br.ufc.model.Role;

public interface IRoleDAO {
	
	public void inserirRole(Role role);
	public void removerRole(Role role);
	public void atualizarRole(Role role);
	public List<Role> listarRoles();
	public Role buscarRole(Long id);
	public Role buscarRoleNome(String role);

}
