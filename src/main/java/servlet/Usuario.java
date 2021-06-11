package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.BeansCursoJsp;
import dao.DaoUsuario;

@WebServlet("/salvarUsuario")
public class Usuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	DaoUsuario daoUsuario = new DaoUsuario();
	
       
    public Usuario() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException {
		
		String login = request.getParameter("login");		
		String senha = request.getParameter("senha");
		
		BeansCursoJsp cursoJsp = new BeansCursoJsp();
		cursoJsp.setLogin(login);
		cursoJsp.setSenha(senha);		
		daoUsuario.salvar(cursoJsp);
	}

}
