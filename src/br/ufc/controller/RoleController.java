package br.ufc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.dao.IRoleDAO;
import br.ufc.model.Role;

@Transactional
@Controller
public class RoleController {

	@Autowired
	private IRoleDAO rDAO;
	
	@RequestMapping("roleFormulario")
	public String roleFormulario(){
		return "role/inserir_role";
	}
	@RequestMapping("adicionarRole")
	public String adicionarRole(Role role){
		rDAO.inserirRole(role);
		return "redirect:listarRoles";
	}
	
	@RequestMapping("listarRoles")
	public String listarRoles(Model model){
		model.addAttribute("roles", this.rDAO.listarRoles());
		return "role/listar_roles";
	}
		
	@RequestMapping("removerRole")
	public String removerRole(Role role){
		
		this.rDAO.removerRole(role);
		return "redirect:listarRoles";
	}
	@RequestMapping("atualizarRole")
	public String atualizarRole(Model model, Role role){
		Role r = rDAO.buscarRole(role.getId());
		model.addAttribute("role", r);
		return "role/alterar_role";
	}
	@RequestMapping("inserirRoleAlterado")
	public String inserirRoleAlterado(Role role){
		this.rDAO.atualizarRole(role);
		return "redirect:listarRoles";
	}

}
