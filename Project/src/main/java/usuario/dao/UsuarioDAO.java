package usuario.dao;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
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

	public Usuario getPorDni(String dni) {
		logger.info("Obteniendo registro por dni");
		Usuario usuario;
		Query query = em.createQuery(
				"from Usuario us where us.dni=?1", 
				Usuario.class);
		query.setParameter(1, dni);
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
	
	
	  public void modificarUsuario(String dni, Usuario userModified) {
	        logger.info("Modificando usuario");
	        TypedQuery<Usuario> query = em.createQuery("from Usuario where dni=?1", Usuario.class);
	        query.setParameter(1, dni);

	        try {
	            Usuario user = query.getSingleResult();
	            logger.info("Imprimiendo usuario para actualizar: " +  user);
	            em.getTransaction().begin();
	            user.setNombre(userModified.getNombre());
				user.setApellidos(userModified.getApellidos());
				user.setDni(userModified.getDni());
				user.setSexo(userModified.getSexo());
				user.setFechaNacimiento(userModified.getFechaNacimiento());
				user.setEmail(userModified.getEmail());
				user.setTelefono(userModified.getTelefono());
				user.setNameUsuario(userModified.getNameUsuario());
				user.setContrasena(userModified.getContrasena());
				user.setRoles(userModified.getRoles());
	            em.merge(user);
	            em.getTransaction().commit();
	        } catch (NoResultException nre) {
	            logger.info("Dni " + userModified.getDni() + " no encontrado");
	        } catch (Exception e) {
	            logger.error(e.getMessage());
	            e.printStackTrace();
	            em.getTransaction().rollback();
	        }
	    }
	
	public void delete(Usuario usuario) {
	    logger.info("Borrando usuario " + usuario.getNombre() + " " + usuario.getApellidos() + " " + usuario.getDni());
	    this.em.getTransaction().begin();
	    try {
	        Usuario usuarioEncontrado = getPorDni(usuario.getDni());
	            em.remove(usuarioEncontrado);
	            this.em.getTransaction().commit();
	            logger.info("Usuario borrado con éxito");
	 
	    } catch (Exception e) {
	        logger.error("Error al borrar el usuario: " + e.getMessage());
	        this.em.getTransaction().rollback();
	    }
	}
	

	
}
