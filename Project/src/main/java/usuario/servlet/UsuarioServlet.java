package usuario.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import usuario.dao.RolUsuarioDAO;
import usuario.dao.UsuarioDAO;
import usuario.entities.RolUsuario;
import usuario.entities.Usuario;
import usuario.enums.UsuarioEnum;

/**
 * Servlet implementation class UsuarioServlet
 */
public class UsuarioServlet extends HttpServlet {
	
	private static final Logger logger = LogManager.getLogger(UsuarioServlet.class);
	private static final long serialVersionUID = 1L;

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
		 try {
		        logger.info("Entrando init");
		        RolUsuarioDAO rolDao = new RolUsuarioDAO();
		        logger.info(rolDao.isEmpty());
		        rolDao.insertRol(new RolUsuario(UsuarioEnum.ADMIN));
		        rolDao.insertRol(new RolUsuario(UsuarioEnum.USER));
		        rolDao.insertRol(new RolUsuario(UsuarioEnum.GUEST));
		        logger.info("Creados perfiles de usuario " + UsuarioEnum.ADMIN + ", " + UsuarioEnum.USER + ", " + UsuarioEnum.GUEST);
		    } catch (Exception e) {
		        logger.error("Error al inicializar roles de usuario", e);
		        throw new ServletException("Error al inicializar roles de usuario", e);
		    }
		}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		logger.info("Entrando doGet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		logger.info("Entrando doPost");

		String nombre = request.getParameter("nombreUsuario");
		String apellidos = request.getParameter("apellidosUsuario");
		String dni = request.getParameter("dniUsuario");
		String sexo = request.getParameter("sexoUsuario");
		String fechaNacimientoStr = request.getParameter("fechaNacimiento");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		Date fechaNacimientoDate = null;
		try {
		    fechaNacimientoDate = formatter.parse(fechaNacimientoStr);
		} catch (ParseException e) {
		    e.printStackTrace();
		}

		String email = request.getParameter("emailUsuario");
		String telefono = request.getParameter("telefono");
		String nameUsuario = request.getParameter("nameUsuario");
		String contrasena = request.getParameter("contrasena");
		String[] rolesStrings = request.getParameterValues("roles[]");
		

		logger.info(nombre + " " + apellidos + " " + sexo + " " + fechaNacimientoStr + " " + formatter + " " + fechaNacimientoDate + " " + 
				email + " " + telefono + " " + nameUsuario + " " + contrasena + " " + rolesStrings);
		
		List<RolUsuario> rolesList = new ArrayList<>();
		if (rolesStrings != null) {
		    for (String rolString : rolesStrings) {
		        UsuarioEnum rolEnum = UsuarioEnum.getRol(rolString);
		        if (rolEnum != null) {
		            RolUsuario rolUsuario = new RolUsuario(rolEnum);
		            rolesList.add(rolUsuario);
		        }
		    }
		}
		
		logger.info("Rol del usuario " + rolesList.size());
		
		UsuarioDAO usao = new UsuarioDAO();
		Usuario usuario = new Usuario(nombre,apellidos,dni,sexo,fechaNacimientoDate,
				email,telefono,nameUsuario,contrasena,rolesList);


		usao.insert(usuario);

		List<Usuario> usuarios = usao.getUsuarios();

		request.setAttribute("listadoUsuarios", usuarios);
		RequestDispatcher rd = request.getRequestDispatcher("Proyecto/listadoUsuarios.jsp");

		rd.forward(request, response);
	}

}
