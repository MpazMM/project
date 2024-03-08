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
			if(rolDao.isEmpty()) {
			rolDao.insertRol(new RolUsuario(UsuarioEnum.ADMIN.toString()));
			rolDao.insertRol(new RolUsuario(UsuarioEnum.USER.toString()));
			rolDao.insertRol(new RolUsuario(UsuarioEnum.GUEST.toString()));
			logger.info("Creados perfiles de usuario " + UsuarioEnum.ADMIN + ", " + UsuarioEnum.USER + ", "
					+ UsuarioEnum.GUEST);
			}
		} catch (Exception e) {
			logger.error("Error al inicializar roles de usuario", e);

		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		logger.info("Entrando doGet");
		UsuarioDAO dao = new UsuarioDAO();
		List<Usuario> listaUsuarios = dao.getUsuarios();
		request.setAttribute("listadoUsuarios", listaUsuarios);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Proyecto/listadoUsuarios.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		logger.info("Entrando doPost");
		UsuarioDAO usdao = new UsuarioDAO();
		String nombre = request.getParameter("nombreUsuario");
		String apellidos = request.getParameter("apellidosUsuario");
		String dni = request.getParameter("dniUsuario");
		String sexo = request.getParameter("sexoUsuario");
		String fechaNacimientoStr = request.getParameter("fechaNacimiento");
		SimpleDateFormat fechaNacimiento = new SimpleDateFormat("yyyy-MM-dd");
		String email = request.getParameter("emailUsuario");
		String telefono = request.getParameter("telefono");
		String nameUsuario = request.getParameter("nameUsuario");
		String contrasena = request.getParameter("contrasena");
		String[] rolesStrings = request.getParameterValues("roles[]");

		try {
			Usuario usuario = new Usuario(nombre, apellidos, dni, sexo, fechaNacimiento.parse(fechaNacimientoStr),
					email, telefono, nameUsuario, contrasena);
			List<RolUsuario> rolesList = new ArrayList<RolUsuario>();
			for (String rol : rolesStrings) {
				RolUsuarioDAO roldao = new RolUsuarioDAO();
				RolUsuario r = roldao.getPorRol(rol);
				rolesList.add(r);
			}
			System.out.println(rolesList.size());
			usuario.setRoles(rolesList);
			
			if(request.getParameter("accion").equals("insertar")) {
				logger.info("Insertando usuario " + usuario);
				usdao.insert(usuario);
			}else if(request.getParameter("accion").equals("eliminar")) {
				usdao.delete(usuario);
				logger.info("Borrando usuario " + usuario);
			}else if(request.getParameter("accion").equals("modificar")) {
				usdao.modificarUsuario(dni, usuario);
				logger.info("Modificando usuario " + usuario);
			}
		
		} catch (NumberFormatException | ParseException e) {
			logger.error("Excepción en creación usuario " + e.getMessage());
			e.printStackTrace();
		}

		List<Usuario> listaUsuarios = usdao.getUsuarios();

		request.setAttribute("listadoUsuarios", listaUsuarios);
		RequestDispatcher rd = request.getRequestDispatcher("Proyecto/listadoUsuarios.jsp");

		rd.forward(request, response);

	}
}
