package domain;

import java.sql.Connection;

public abstract class DAO<T> {

	protected Connection connect = null;

	/**
	 * Constructeur
	 * 
	 * @param conn
	 */
	public DAO(Connection conn) {
		this.connect = conn;
	}

	/**
	 * Méthode de création
	 * 
	 * @param obj
	 * @return
	 */
	public abstract boolean create(T obj);

	/**
	 * Méthode pour effacer
	 * 
	 * @param obj
	 * @return
	 */
	public abstract boolean delete(long id);

	/**
	 * Méthode de mise à jour
	 * 
	 * @param obj
	 * @return
	 */
	public abstract boolean update(T obj);

	/**
	 * Méthode de recherche des informations
	 * 
	 * @param id
	 * @return
	 */
	public abstract T find(long id);

}
