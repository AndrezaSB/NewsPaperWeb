package br.ufc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.dao.INoticiaDAO;
import br.ufc.dao.ISecaoDAO;
import br.ufc.model.Noticia;
import br.ufc.model.Secao;

@Transactional
@Controller
public class NoticiaController {

	@Autowired
	private INoticiaDAO nDAO;
	@Autowired
	private ISecaoDAO sDAO;
	
	private Secao s;
	
	@RequestMapping("noticiaFormulario")
	public String noticiaFormulario(Model model){
		model.addAttribute("secoes", this.sDAO.listarSecoes());
		return "noticia/inserir_noticia";
	}
	
	@RequestMapping("adicionarNoticia")
	public String adicionarNoticia(Noticia noticia){
		s = sDAO.buscarSecao(noticia.getSecao().getId());
		noticia.setSecao(s);
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
