package br.ufc.dao;

import java.util.List;

import br.ufc.model.Usuario;

public interface IUsuarioDAO {

	public void inserir(Usuario usuario);
	public void remover(Usuario usuario);
	public void atualizar(Usuario usuario);
	public List<Usuario> listar();
	public Usuario buscarUsuario(Long id);
	public Usuario buscarUsuarioLogin(String login);
	
}