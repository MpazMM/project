package usuario.dao;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import usuario.entities.Usuario;
import utils.JpaUtils;

public class UsuarioDAO {
	private static final Logger logger = LogManager.getLogger(UsuarioDAO.class);
	private EntityManager em = JpaUtils.getEntityManager();

	
	public List<Usuario> getUsuarios() {
		logger.info("Creando consulta de usuarios");
		List<Usuario> usuarios = em.createQuery("from Usuario", Usuario.class).getResultList();
		return usuarios;
	}

	public Usuario getPorId(long id) {
		logger.info("Obteniendo registro por id");
		Usuario usuario;
		Query query = em.createQuery(
				"from Usuario us where us.id=?1", 
				Usuario.class);
		query.setParameter(1, id);
		usuario = (Usuario)query.getSingleResult();
		
		return usuario;
	}
	
	
	public void insert(Usuario usuario) {
		this.em.getTransaction().begin();
		try {
			em.persist(usuario);
			this.em.getTransaction().commit();
			logger.info("Usuario creado con éxito");
		}catch (Exception e) {
			logger.error("Error "+ e.getMessage());
			e.printStackTrace();
			this.em.getTransaction().rollback();
		}	
	}
	
	
	public Usuario validarUsuario(String nameUsuario, String contrasena) {
	    logger.info("Validando usuario: " + nameUsuario);
	    try {
	        Usuario usuario = em.createQuery("from Usuario us where us.nombreUsuario=:nameUsuario and us.contrasena=:contrasena", Usuario.class)
	                            .setParameter("nameUsuario", nameUsuario)
	                            .setParameter("contrasena", contrasena)
	                            .getSingleResult();
	        return usuario;
	    } catch (NoResultException e) {
	        logger.info("No se encontró un usuario con las credenciales proporcionadas");
	        return null;
	    } catch (Exception e) {
	        logger.error("Error al validar el usuario: " + e.getMessage());
	        return null;
	    }
	}
	
	//TODO
	public void update(Usuario usuario) {
	    logger.info("Modificando usuario " + usuario.getNombre() + " " + usuario.getApellidos() + " " + usuario.getDni());
	    this.em.getTransaction().begin();
	    try {
	        Usuario usuarioEncontrado = em.find(Usuario.class, usuario.getDni());
	        if (usuarioEncontrado != null) {
	            usuarioEncontrado.setNombre(usuario.getNombre());
	            usuarioEncontrado.setApellidos(usuario.getApellidos());
	            usuarioEncontrado.setDni(usuario.getDni());
	            // Aquí puedes seguir asignando los campos que necesites actualizar.
	            em.merge(usuarioEncontrado);
	            this.em.getTransaction().commit();
	            logger.info("Usuario actualizado con éxito");
	        } else {
	            logger.info("Usuario no encontrado");
	        }
	    } catch (Exception e) {
	        logger.error("Error al actualizar el usuario: " + e.getMessage());
	        e.printStackTrace();
	        this.em.getTransaction().rollback();
	    }
	}
	
	
	
	public void delete(Usuario usuario) {
	    logger.info("Borrando usuario " + usuario.getNombre() + " " + usuario.getApellidos() + " " + usuario.getDni());
	    this.em.getTransaction().begin();
	    try {
	        Usuario usuarioEncontrado = em.find(Usuario.class, usuario.getDni());
	        if (usuarioEncontrado != null) {
	            em.remove(usuarioEncontrado);
	            this.em.getTransaction().commit();
	            logger.info("Usuario borrado con éxito");
	        } else {
	            logger.info("Usuario a borrar no encontrado");
	        }
	    } catch (Exception e) {
	        logger.error("Error al borrar el usuario: " + e.getMessage());
	        e.printStackTrace();
	        this.em.getTransaction().rollback();
	    }
	}
	
}
