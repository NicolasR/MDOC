package dao;

import java.sql.Connection;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * @author Charles DUFOUR
 * @author Nicolas RIGNAULT
 * DAO gérant les opérations avec la base de données
 * @param <T>
 */
public abstract class DAO<T> extends HibernateDaoSupport{

	protected Connection connect = null;

	/**
	 * Constructeur
	 * 
	 * @param conn la connexion à la base de données
	 */
	public DAO(Connection conn) {
		this.connect = conn;
	}

	/**
	 * Méthode de création
	 * 
	 * @param obj l'objet à créer
	 * @return resultat de l'opération
	 */
	public abstract boolean create(T obj);

	/**
	 * Méthode pour effacer
	 * 
	 * @param obj l'objet à effacer
	 * @return résultat de l'opération
	 */
	public abstract boolean delete(long id);

	/**
	 * Méthode de mise à jour
	 * 
	 * @param obj l'objet à mettre à jour
	 * @return résultat de l'opération
	 */
	public abstract boolean update(T obj);

	/**
	 * Méthode de recherche des informations
	 * 
	 * @param id l'identifiant de l'objet à rechercher
	 * @return résultat de l'opération
	 */
	public abstract T find(long id);
	
	/**
	 * Renvoie la liste des éléments
	 * 
	 * @return la liste de tous les éléments
	 */
	public abstract List<T> getAll();

	/**
	 * Renvoie la liste des éléments obtenus suite à la requête query
	 * 
	 * @return la liste des éléments
	 */
	public abstract List<T> query(String query);
}
