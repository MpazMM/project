package utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaUtils {
	
//	public static EntityManager getEntityManager() {
//	
//		return getEntityManager("hibernateMySQL");
//		
//	}
	
    private static EntityManager em = null;

    public static EntityManager getEntityManager() {
        if (em == null) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernateOracleBBDD");     
            em = emf.createEntityManager();
        }
        return em;
    }
	
	
	
	
}
