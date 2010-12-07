package domain;

import java.sql.Connection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public abstract class DAO<T> {
	
	protected Connection connect = null;
	protected Session session = null;
	protected SessionFactory sessionFactory = null;
	
	protected void openSession()
	{
		this.session = sessionFactory.openSession();		
	}
	
	protected void closeSession()
	{
		this.session.close();
	}
    
    /**
     * Constructeur
     * @param conn
     */
    public DAO(Connection conn){
            this.connect = conn;
            try
    		{
    			sessionFactory =
    				new Configuration().configure().buildSessionFactory();
    		} catch(Exception e){
    			System.out.println(e.getMessage());
    		}
    }
    
    /**
     * Méthode de création
     * @param obj
     * @return
     */
    public abstract boolean create(T obj);
    /**
     * Méthode pour effacer
     * @param obj
     * @return
     */
    public abstract boolean delete(long id);
    /**
     * Méthode de mise à jour
     * @param obj
     * @return
     */
    public abstract boolean update(T obj);
    /**
     * Méthode de recherche des informations
     * @param id
     * @return
     */
    public abstract T find(long id);

}
