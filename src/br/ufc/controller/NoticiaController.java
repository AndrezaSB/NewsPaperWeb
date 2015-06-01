package br.ufc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.dao.INoticiaDAO;
import br.ufc.model.Noticia;

@Transactional
@Controller
public class NoticiaController {

	@Autowired
	private INoticiaDAO nDAO;
	
	@RequestMapping("noticiaFormulario")
	public String noticiaFormulario(){
		return "noticia/inserir_noticia";
	}
	@RequestMapping("adicionarNoticia")
	public String adicionarNoticia(Noticia noticia){
		nDAO.inserirNoticia(noticia);
		return "redirect:listarNoticias";
	}
	
	@RequestMapping("listarNoticias")
	public String listarNoticias(Model model){
		model.addAttribute("noticias", this.nDAO.listarNoticias());
		return "noticia/listar_noticias";
	}
		
	@RequestMapping("removerNoticia")
	public String removerNoticia(Noticia noticia){
		
		this.nDAO.removerNoticia(noticia);
		return "redirect:listarNoticias";
	}
	@RequestMapping("atualizarNoticia")
	public String atualizarNoticia(Model model, Noticia noticia){
		Noticia n = nDAO.buscarNoticia(noticia.getId());
		model.addAttribute("noticia", n);
		return "noticia/alterar_noticia";
	}
	@RequestMapping("inserirNoticiaAlterado")
	public String inserirNoticiaAlterado(Noticia noticia){
		this.nDAO.atualizarNoticia(noticia);
		return "redirect:listarNoticias";
	}

}
