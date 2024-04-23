package hibernate_user.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import hibernate_user.User;

public class UserDao {

	private static final User User = null;

	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("sujit").createEntityManager();
	}
	
	public void saveUser(User user) {
       EntityManager manager = getEntityManager();
       EntityTransaction transaction = manager.getTransaction();
       transaction.begin();
       manager.persist(user);
       transaction.commit();	  
	}
	
	public User getUser(String email) {
		EntityManager manager = getEntityManager();
		Query query = manager.createQuery("SELECT a FROM User a WHERE a.email = :email");//named parameter.
		query.setParameter("email", email);
		try {
			return (User) query.getSingleResult();
			
		} catch (Exception e) {
			return null;
		}
	}

	public User displayPasswords(String email) {
		
	    return User;
	}
	
	public User savePasswords(User user) {
		EntityManager manager = getEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		try {
			transaction.begin();
			manager.merge(user);
			transaction.commit();

			return user;
		} catch (Exception e) {
			return null;
		}
	}
}
