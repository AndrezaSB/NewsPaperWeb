package br.ufc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.dao.IComentarioDAO;
import br.ufc.model.Comentario;

@Transactional
@Controller
public class ComentarioController {
	@Autowired
	private IComentarioDAO cDAO;
	
	@RequestMapping("comentarioFormulario")
	public String comentarioFormulario(){
		return "Comentario/inserir_comentario";
	}
	@RequestMapping("adicionarComentario")
	public String adicionarComentario(Comentario comentario){
		cDAO.inserirComentario(comentario);
		return "redirect:listarComentarios";
	}
	
	@RequestMapping("listarComentarios")
	public String listarComentarios(Model model){
		model.addAttribute("comentarios", this.cDAO.listarComentarios());
		return "comentario/listar_comentarios";
	}
		
	@RequestMapping("removerComentario")
	public String removerComentario(Comentario comentario){
		this.cDAO.removerComentario(comentario);
		return "redirect:listarComentarios";
	}
	@RequestMapping("atualizarComentario")
	public String atualizarComentario(Model model, Comentario comentario){
		Comentario c = cDAO.buscarComentario(comentario.getId());
		model.addAttribute("comentario", c);
		return "comentario/alterar_comentario";
	}
	@RequestMapping("inserirComentarioAlterado")
	public String inserirComentarioAlterado(Comentario comentario){
		this.cDAO.atualizarComentario(comentario);
		return "redirect:listarComentarios";
	}
}
