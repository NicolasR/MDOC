package dao;

import java.sql.Connection;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Transaction;

import util.HibernateUtil;

import domain.Address;

/**
 * @author Charles DUFOUR
 * @author Nicolas RIGNAULT
 * DAO associé à la gestion des adresses des contacts
 *
 */
public class DAOAddress extends DAO<Address> {

	
	/**
	 * Constructeur
	 * @param conn la connexion à la base de données
	 */
	public DAOAddress(Connection conn) {
		super(conn);
	}

	/** (non-Javadoc)
	 * @see dao.DAO#create(java.lang.Object)
	 * Crée l'adresse dans la base de données
	 * @param obj l'adresse à créer
	 * @return le résultat de l'opération
	 */
	@Override
	public boolean create(Address obj) {
		Transaction transaction = HibernateUtil.currentSession()
				.beginTransaction();
		HibernateUtil.currentSession().saveOrUpdate(obj);
		transaction.commit();

		return true;
	}

	/** (non-Javadoc)
	 * @see dao.DAO#delete(long)
	 * Supprime l'adresse ayant l'id associé de la base de données
	 * @param id l'identifiant de l'adresse à supprimer
	 * @return le résultat de l'opération
	 */
	@Override
	public boolean delete(long id) {
		Transaction transaction = HibernateUtil.currentSession()
				.beginTransaction();
		Address address = find(id);
		HibernateUtil.currentSession().delete(address);
		transaction.commit();

		return true;
	}

	/** (non-Javadoc)
	 * @see dao.DAO#update(java.lang.Object)
	 * Met à jour l'adresse dans la base de données
	 * @param obj l'adresse à mettre à jour
	 * @return le résultat de l'opération
	 */
	@Override
	public boolean update(Address obj) {
		Transaction transaction = HibernateUtil.currentSession()
				.beginTransaction();
		HibernateUtil.currentSession().saveOrUpdate(obj);
		transaction.commit();

		return true;
	}

	/** (non-Javadoc)
	 * @see dao.DAO#find(long)
	 * Cherche l'adresse ayant l'id associé dans la base de données
	 * @param id l'identifiant de l'adresse
	 * @return l'adresse associée à l'identifiant
	 */
	@Override
	public Address find(long id) {
		Transaction transaction = HibernateUtil.currentSession()
				.beginTransaction();
		Address address = (Address) HibernateUtil.currentSession().get(
				Address.class, new Integer((int) id));
		transaction.commit();

		return address;
	}

	/** (non-Javadoc)
	 * @see dao.DAO#getAll()
	 * Renvoie toutes les adresses se trouvant dans la base de données
	 * @return la liste des adresses
	 */
	@Override
	public List<Address> getAll() {
		Transaction t = HibernateUtil.currentSession().beginTransaction();

		Query query = HibernateUtil.currentSession()
				.createQuery("from Address");
		@SuppressWarnings(value = "unchecked")
		List<Address> list = query.list();
		t.commit();

		return list;
	}

}
