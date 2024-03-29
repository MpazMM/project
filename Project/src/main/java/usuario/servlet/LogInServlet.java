package usuario.servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import usuario.dao.UsuarioDAO;

/**
 * Servlet implementation class LogInServlet
 */
public class LogInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogInServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nameUsuario = request.getParameter("usuario");
        String contrasena = request.getParameter("contrasena");
        UsuarioDAO usdao = new UsuarioDAO();
        RequestDispatcher rd = null;
        
        if (usdao.validarUsuario(nameUsuario, contrasena)!=null) {
            request.setAttribute("usuario", nameUsuario);
            rd = request.getRequestDispatcher("Proyecto/userLogIn.jsp");
        } else {
            request.setAttribute("mensaje", "Usuario o contraseña incorrectos");
            rd = request.getRequestDispatcher("/index.jsp"); 
        }
        
        rd.forward(request, response);
    }
}