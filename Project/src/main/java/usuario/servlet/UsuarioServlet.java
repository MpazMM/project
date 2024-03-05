package usuario.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import usuario.dao.UsuarioDAO;
import usuario.entities.RolUsuario;
import usuario.entities.Usuario;
import usuario.enums.UsuarioEnum;

/**
 * Servlet implementation class UsuarioServlet
 */
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String subtitulo;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UsuarioServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("Entrando init");
		
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Entrando doGet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Entrando doPost");

		String nombre = request.getParameter("nombreUsuario");
		System.out.println(nombre);
		String apellidos = request.getParameter("apellidosUsuario");
		System.out.println(apellidos);
		String dni = request.getParameter("dniUsuario");
		System.out.println(dni);
		String sexo = request.getParameter("sexoUsuario");
		System.out.println(sexo);
		String fechaNacimientoStr = request.getParameter("fechaNacimiento");
		System.out.println(fechaNacimientoStr);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		Date fechaNacimientoDate = null;
		try {
		    fechaNacimientoDate = formatter.parse(fechaNacimientoStr);
		} catch (ParseException e) {
		    e.printStackTrace();
		}

		String email = request.getParameter("emailUsuario");
		System.out.println(email);
		String telefono = request.getParameter("telefono");
		System.out.println(telefono);
		String nameUsuario = request.getParameter("nameUsuario");
		System.out.println(nameUsuario);
		String contrasena = request.getParameter("contrasena");
		System.out.println(contrasena);
		String[] rolesStrings = request.getParameterValues("roles[]");
		for (String string : rolesStrings) {
			System.out.println(string);
		}
		

		List<RolUsuario> rolesSet = new ArrayList<>();
		if (rolesStrings != null) {
		    for (String rolString : rolesStrings) {
		        UsuarioEnum rolEnum = UsuarioEnum.getRol(rolString);
		        if (rolEnum != null) {
		            RolUsuario rolUsuario = new RolUsuario(rolEnum);
		            rolesSet.add(rolUsuario);
		        }
		    }
		}
		
		UsuarioDAO usao = new UsuarioDAO();
		Usuario usuario = new Usuario(nombre,apellidos,dni,sexo,fechaNacimientoDate,
				email,telefono,nameUsuario,contrasena,rolesSet);

		System.out.println(usuario);

		usao.insert(usuario);

		List<Usuario> usuarios = usao.getUsuarios();

		request.setAttribute("listadoUsuarios", usuarios);
		RequestDispatcher rd = request.getRequestDispatcher("Proyecto/listadoUsuarios.jsp");

		rd.forward(request, response);
	}

}
