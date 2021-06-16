package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.BeanCursoJsp;
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

		try {

			String acao = request.getParameter("acao");
			String user = request.getParameter("user");

			// verificando se a ação é de excluir o usuário
			if (acao.equalsIgnoreCase("delete")) {
				daoUsuario.delete(user);
				
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("/cadastroUsuario.jsp");
				request.setAttribute("usuarios", daoUsuario.listarUsuarios());
				dispatcher.forward(request, response);
			} 
			else if (acao.equalsIgnoreCase("editar")) {
				
				BeanCursoJsp cursoJsp = daoUsuario.consultar(user);
				
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("/cadastroUsuario.jsp");
				request.setAttribute("user", cursoJsp);
				dispatcher.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");

		BeanCursoJsp cursoJsp = new BeanCursoJsp();
		cursoJsp.setId(!id.isEmpty()? Long.parseLong(id) : 0);
		cursoJsp.setLogin(login);
		cursoJsp.setSenha(senha);
		
		if (id == null || id.isEmpty()) {
			daoUsuario.salvar(cursoJsp);			
		} else {
			daoUsuario.atualizar(cursoJsp);
		}


		try {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/cadastroUsuario.jsp");
			request.setAttribute("usuarios", daoUsuario.listarUsuarios());
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
