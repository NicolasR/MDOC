package util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author Charles DUFOUR
 * @author Nicolas RIGNAULT
 * Fonction de manipulation Hibernate
 */
public class HibernateUtil {
	
	/**
	 * Factory
	 */
	private static final SessionFactory sessionFactory;

	static {
		try {
			// Crée la SessionFactory
			sessionFactory = new Configuration().configure()
					.buildSessionFactory();
		} catch (HibernateException ex) {
			throw new RuntimeException("Problème de configuration : "
					+ ex.getMessage(), ex);
		}
	}

	/**
	 * Session
	 */
	private static Session session = null;

	/**
	 * Renvoie la session courante
	 * @return la session courante
	 * @throws HibernateException
	 */
	public static Session currentSession() throws HibernateException {
		if (session == null) {
			session = sessionFactory.openSession();
		}
		return session;
	}

	/**
	 * Ferme la session
	 * @throws HibernateException
	 */
	public static void closeSession() throws HibernateException {
		if (session != null)
			session.close();
		session = null;
	}
}
