package br.ufc.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.dao.IRoleDAO;
import br.ufc.dao.IUsuarioDAO;
import br.ufc.model.Role;
import br.ufc.model.Usuario;

@Transactional
@Controller
public class UsuarioController {

	@Autowired
	private IUsuarioDAO uDAO;
	@Autowired
	private IRoleDAO rDAO;
	
	
	@RequestMapping("leitorFormulario")
	public String usuarioFormulario(){
		return "usuario/inserir_leitor";
	}
	
	@RequestMapping("adicionarUsuario")
	public String adicionarUsuario(Usuario usuario){
		uDAO.inserir(usuario);
		return "redirect:loginFormulario";
	}
	
	@RequestMapping("adicionarLeitor")
	public String adicionarLeitor(Usuario usuario){
		Role r;
		r = rDAO.buscarRoleNome("Leitor");
		usuario.setFuncoes(r);
		uDAO.inserir(usuario);
		return "redirect:loginFormulario";
	}
	
	@RequestMapping("listarUsuarios")
	public String listar(Model model){
		model.addAttribute("usuarios", this.uDAO.listar());
		return "usuario/listar_usuarios";
	}
		
	@RequestMapping("removerUsuario")
	public String remover(Usuario usuario){
		
		this.uDAO.remover(usuario);
		return "redirect:listarUsuarios";
	}
	@RequestMapping("atualizarUsuario")
	public String atualizarusuario(Model model, Usuario usuario){
		Usuario u = uDAO.buscarUsuario(usuario.getId());
		model.addAttribute("usuario", u);
		return "usuario/alterar_usuario";
	}
	@RequestMapping("inserirUsuarioAlterado")
	public String inserirUsuarioAlterado(Usuario usuario){
		this.uDAO.atualizar(usuario);
		return "redirect:listarUsuarios";
	}
	
	@RequestMapping("loginFormulario")
	public String loginFormulario(){
		return "usuario/formulario_login";
	}
	
	@RequestMapping("usuarioLogout")
	public String usuarioLogout(HttpSession session){
		if(session!=null) session.invalidate();
		return "redirect:loginFormulario";
	}

	
	@RequestMapping("usuarioLogin")
	public String usuarioLogin(Usuario usuario, HttpSession session){
		//lógica do login
		
		if(usuario==null || usuario.getLogin()==null || usuario.getLogin()==""){
			return "redirect:loginFormulairo";
		}
		
		Usuario usuBanco = this.uDAO.buscarUsuarioLogin(usuario.getLogin());
		
		//login inexistente
		if(usuBanco==null){
			return "redirect:loginFormulario";
		}
		if(!(usuBanco.getSenha().equals(usuario.getSenha()))){
			return "redirect:loginFormulario";
		}
		
		//colocando o usuario na sessão
		session.setAttribute("logado", usuBanco);
		
		return "usuario/login_efetuado";
	}
	
}
