package usuario.dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import usuario.entities.Usuario;
import utils.JpaUtils;

public class UsuarioDAO {
	
	private EntityManager em = JpaUtils.getEntityManager();

	
	public List<Usuario> getUsuarios() {
		List<Usuario> usuarios = em.createQuery("from Usuario").getResultList();
		return usuarios;
	}

	public Usuario getPorId(long id) {
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
		}catch (Exception e) {
			this.em.getTransaction().rollback();
		}	
	}
	
	public void update(Usuario usuario) {
		
	}
	
	public void delete(Usuario usuario) {
		
	}
	
}
