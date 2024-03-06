package usuario.dao;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import usuario.entities.Usuario;
import usuario.servlet.UsuarioServlet;
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
	
	//TODO
	public void update(Usuario usuario) {
		logger.info("Modificando usuario "  + usuario.getNombre() + " " + usuario.getApellidos() + " " + usuario.getDni());
		
	}
	
	
	//TODO
	public void delete(Usuario usuario) {
		logger.info("Borrando usuario " + usuario.getNombre() + " " + usuario.getApellidos() + " " + usuario.getDni());
		
	}
	
}
