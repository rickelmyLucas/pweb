package br.edu.ifgoiano.controle;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;

import br.edu.ifgoiano.entidade.Usuario;
import br.edu.ifgoiano.repositorio.UsuarioRepositorio;

public class LoginServlet extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		final String email = req.getParameter("email");
		final String senha = req.getParameter("senha");

		if (senha != null && senha.equals("12345")) {
			try {
				UsuarioRepositorio repositorio = new UsuarioRepositorio();
				List<Usuario> lstUsuario = repositorio.listarUsuario();

				req.setAttribute("usuarios", lstUsuario);

				req.getRequestDispatcher("listaUsuarios.jsp").forward(req, resp);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new ServletException("Erro na listagem, de Usuários");
			}
		} else {
			// se FALSE: retornar para a JSP (nenhumUsuarioCadastrado.jsp);
		}
	}
}
