package usuario.dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import usuario.entities.RolUsuario;
import usuario.entities.Usuario;
import utils.JpaUtils;

public class RolUsuarioDAO {
	
	private EntityManager em = JpaUtils.getEntityManager();

	
	public List<RolUsuario> getRolUsuario() {
		List<RolUsuario> usuarios = em.createQuery("from RolUsuario").getResultList();
		return usuarios;
	}

	public RolUsuario getPorId(long id) {
		RolUsuario usuario;
		Query query = em.createQuery(
				"from RolUsuario ru where ru.id=?1", 
				RolUsuario.class);
		query.setParameter(1, id);
		usuario = (RolUsuario)query.getSingleResult();
		
		return usuario;
	}
	
	
	public void insert(RolUsuario rolUsuario) {
		this.em.getTransaction().begin();
		try {
			em.persist(rolUsuario);
			this.em.getTransaction().commit();
			
		}catch (Exception e) {
			this.em.getTransaction().rollback();
		}	
	}
	
	//TODO
	public void update(RolUsuario rolUsuario) {
		
	}
	
	
	//TODO
	public void delete(RolUsuario rolUsuario) {
		
	}
	
}
