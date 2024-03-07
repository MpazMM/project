package usuario.dao;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import usuario.entities.RolUsuario;
import utils.JpaUtils;

public class RolUsuarioDAO {
	private static final Logger logger = LogManager.getLogger(RolUsuarioDAO.class);
	private EntityManager em = JpaUtils.getEntityManager();

	
	public List<RolUsuario> getRolUsuario() {
		List<RolUsuario> rolUsuarios = em.createQuery("from RolUsuario").getResultList();
		logger.info("Obteniendo RoldeUsuarios " + rolUsuarios.size());
		return rolUsuarios;
	}

	public RolUsuario getPorRol(String rol) {
		Query query = em.createQuery(
				"from RolUsuario ru where ru.rolEnum=?1", 
				RolUsuario.class);
		query.setParameter(1, rol);
		RolUsuario rolUsuario = null;
		rolUsuario = (RolUsuario)query.getSingleResult();
		//logger.info("El rol es " + rolUsuario.getRolEnum();
		return rolUsuario;
	}
	
	
	public void insertRol(RolUsuario rolUsuario) {
	    if(isEmpty()) {
	    	logger.info("El rol ya existe y no será insertado de nuevo.");
	    }
	    
	    this.em.getTransaction().begin();
	    try {
	        em.persist(rolUsuario);
	        this.em.getTransaction().commit();
	        logger.info("RolUsuario creado con éxito: " + rolUsuario);
	    } catch (Exception e) {
	        this.em.getTransaction().rollback();
	        logger.error("Error al insertar el rol: ", e);
	    }
	}
	
	public boolean isEmpty() {
		List<RolUsuario> roles = em.createQuery("from RolUsuario", RolUsuario.class).getResultList();	
		boolean isVacio = false;
		if(roles.isEmpty()) {
			isVacio = true;
			logger.info("El RolUsuario está vacío");
		}
		return isVacio;


	}
	
}
