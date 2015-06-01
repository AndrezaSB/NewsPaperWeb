package br.ufc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.dao.ISecaoDAO;
import br.ufc.model.Secao;

@Transactional
@Controller
public class SecaoController {

	@Autowired
	private ISecaoDAO sDAO;
	
	@RequestMapping("secaoFormulario")
	public String secaoFormulario(){
		return "secao/inserir_secao";
	}
	@RequestMapping("adicionarSecao")
	public String adicionarSecao(Secao secao){
		sDAO.inserirSecao(secao);
		return "redirect:listarSecoes";
	}
	
	@RequestMapping("listarSecoes")
	public String listarSecaos(Model model){
		model.addAttribute("secoes", this.sDAO.listarSecoes());
		return "secao/listar_secoes";
	}
		
	@RequestMapping("removerSecao")
	public String removerSecao(Secao secao){
		
		this.sDAO.removerSecao(secao);
		return "redirect:listarSecoes";
	}
	@RequestMapping("atualizarSecao")
	public String atualizarSecao(Model model, Secao secao){
		Secao s = sDAO.buscarSecao(secao.getId());
		model.addAttribute("secao", s);
		return "secao/alterar_secao";
	}
	@RequestMapping("inserirSecaoAlterada")
	public String inserirSecaoAlterada(Secao secao){
		this.sDAO.atualizarSecao(secao);
		return "redirect:listarSecoes";
	}

}
