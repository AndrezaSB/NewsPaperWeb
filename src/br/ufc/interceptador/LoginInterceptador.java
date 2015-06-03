package br.ufc.interceptador;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import br.ufc.model.Usuario;

public class LoginInterceptador extends HandlerInterceptorAdapter{
	
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object controller) throws Exception {
		
		
		String uri = request.getRequestURI();
		if(uri.endsWith("loginFormulario")) return true;
		if(uri.endsWith("leitorFormulario")) return true;
		if(uri.endsWith("usuarioLogout")) return true;
		
		
		HttpSession session = request.getSession();
		if(session.getAttribute("logado")!=null){
			if(uri.endsWith("listarUsuarios")){
				
			}
			
		}
		
		response.sendRedirect("loginFormulario");
		return false;
	}

}
