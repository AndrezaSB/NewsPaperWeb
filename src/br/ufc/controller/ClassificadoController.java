package br.ufc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.dao.IClassificadoDAO;
import br.ufc.model.Classificado;

@Transactional
@Controller
public class ClassificadoController {


	@Autowired
	private IClassificadoDAO cDAO;
	
	@RequestMapping("classificadoFormulario")
	public String classificadoFormulario(){
		return "classificado/inserir_classificado";
	}
	@RequestMapping("adicionarClassificado")
	public String adicionarClassificado(Classificado classificado){
		cDAO.inserirClassificado(classificado);
		return "redirect:listarClassificados";
	}
	
	@RequestMapping("listarClassificados")
	public String listarClassificados(Model model){
		model.addAttribute("Classificados", this.cDAO.listarClassificados());
		return "classificado/listar_Classificados";
	}
		
	@RequestMapping("removerClassificado")
	public String removerClassificado(Classificado classificado){
		this.cDAO.removerClassificado(classificado);
		return "redirect:listarClassificados";
	}
	@RequestMapping("atualizarClassificado")
	public String atualizarClassificado(Model model, Classificado classificado){
		Classificado c = cDAO.buscarClassificado(classificado.getId());
		model.addAttribute("classificado", c);
		return "classificado/alterar_Classificado";
	}
	@RequestMapping("inserirClassificadoAlterado")
	public String inserirClassificadoAlterado(Classificado Classificado){
		this.cDAO.atualizarClassificado(Classificado);
		return "redirect:listarClassificados";
	}

	
}
