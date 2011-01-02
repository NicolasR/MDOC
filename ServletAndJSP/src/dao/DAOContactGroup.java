package dao;

import java.sql.Connection;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Transaction;

import util.HibernateUtil;

import domain.ContactGroup;

/**
 * @author Charles DUFOUR
 * @author Nicolas RIGNAULT
 * DAO qui gère les groupes de contact
 *
 */
public class DAOContactGroup extends DAO<ContactGroup> {

	
	/**
	 * Initialise la connexion SQL
	 * @param conn la connection à la base de données
	 */
	public DAOContactGroup(Connection conn) {
		super(conn);
	}
	
	/**
	 * Constructeur vide (nécessaire pour spring)
	 */
	public DAOContactGroup()
	{
		super(null);
	}

	/** (non-Javadoc)
	 * @see dao.DAO#create(java.lang.Object)
	 * Crée le groupe
	 * @param obj le groupe à ajouter dans la base de données
	 */
	@Override
	public boolean create(ContactGroup obj) {
		Transaction transaction = HibernateUtil.currentSession().beginTransaction();
		HibernateUtil.currentSession().saveOrUpdate(obj);
		transaction.commit();
		return true;
	}

	@Override
	public boolean delete(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(ContactGroup obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ContactGroup find(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	/** (non-Javadoc)
	 * @see dao.DAO#getAll()
	 * Renvoie tous les groupes se trouvant dans la base de données
	 * @return la liste des groupes
	 */
	@Override
	public List<ContactGroup> getAll() {
		Transaction t = HibernateUtil.currentSession().beginTransaction();
		
		Query query = HibernateUtil.currentSession().createQuery("from ContactGroup");
		@SuppressWarnings(value="unchecked")
		List<ContactGroup> list = query.list();
		t.commit();
		return list;
	}

}
