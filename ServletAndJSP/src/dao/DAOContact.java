package dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import util.HibernateUtil;

import domain.Contact;
import domain.ContactGroup;
import domain.PhoneNumber;

/**
 * @author Charles DUFOUR
 * @author Nicolas RIGNAULT
 * DAO qui gère les contacts
 */
public class DAOContact extends DAO<Contact> {
	
	/**
	 * Constructeur
	 * @param conn la connexion à la base de données
	 */
	public DAOContact(Connection conn) {
		super(conn);
	}
	
	
	/**
	 * Constructeur vide (nécessaire pour spring)
	 */
	public DAOContact()
	{
		super(null);
	}

	/** (non-Javadoc)
	 * @see dao.DAO#create(java.lang.Object)
	 * Crée le contact dans la base de données
	 * @param obj le contact à créer
	 * @return le résultat de l'opération
	 */
	@Override
	public boolean create(Contact contact) {
		/*long id = contact.getId();
		String firstName = contact.getFirstName();
		String lastName = contact.getLastName();
		String email = contact.getEmail();
		try {
			Statement state = this.connect.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			String query = "INSERT INTO contact (firstName, lastName, email, id) VALUES ('" + firstName + "','" + lastName + "','" + email + "','" + id + "')";
			state.executeUpdate(query);
			state.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;*/
		/*Transaction transaction = HibernateUtil.currentSession().beginTransaction();
		HibernateUtil.currentSession().saveOrUpdate(contact);
		transaction.commit();*/
		this.getHibernateTemplate().saveOrUpdate(contact);
		return true;
	}

	/** (non-Javadoc)
	 * @see dao.DAO#delete(long)
	 * Supprime le contact ayant l'id associé de la base de données
	 * @param id l'identifiant du contact à supprimer
	 * @return le résultat de l'opération
	 */
	@Override
	public boolean delete(long id) {
		/*try {
			Statement state = this.connect.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			String query = "DELETE FROM contact WHERE id = '"+id+"'";
			state.execute(query);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}*/
		Contact contact = find(id);
		System.out.println("COUCOU"+contact.getFirstName());
		//Transaction transaction = HibernateUtil.currentSession().beginTransaction();
		
		// Suppression de la reference du contact dans tous ses numéros de téléphone :
		// Cela empeche Hibernate de tenter de re-sauvegarder le contact (par cascade) alors qu'il est supprimé
		for (PhoneNumber phone : contact.getPhones()) {
			phone.setContact(null);
		}
		
		// Suppression de la reference du contact dans tous ses groupes :
		// Cela empeche Hibernate de tenter de re-sauvegarder le contact (par cascade) alors qu'il est supprimé
		for (ContactGroup group : contact.getGroups())
		{
			group.getContacts().remove(contact);
		}
		
		/*HibernateUtil.currentSession().delete(contact);
		transaction.commit();*/
		this.getHibernateTemplate().delete(contact);
		return true;
	}

	/** (non-Javadoc)
	 * @see dao.DAO#update(java.lang.Object)
	 * Met à jour le contact dans la base de données
	 * @param obj le contact à mettre à jour
	 * @return le résultat de l'opération
	 */
	@Override
	public boolean update(Contact obj) {
		/*try {
			Statement state = this.connect.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			String firstName = obj.getFirstName();
			String lastName = obj.getLastName();
			String email = obj.getEmail();
			long id = obj.getId();
			String query = "UPDATE contact SET firstName = '" + firstName + "', lastName='" + lastName + "', "
				+ "email='"+email+"', id='"+id+"'";
			System.out.println(query);
			state.executeUpdate(query);
			state.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}*/
		/*Transaction transaction = HibernateUtil.currentSession().beginTransaction();
		HibernateUtil.currentSession().saveOrUpdate(obj);
		transaction.commit();*/
		this.getHibernateTemplate().saveOrUpdate(obj);
		
		return true;
	}

	/** (non-Javadoc)
	 * @see dao.DAO#find(long)
	 * Cherche le contact ayant l'id associé dans la base de données
	 * @param id l'identifiant du contact
	 * @return le contact associé à l'identifiant
	 */
	@Override
	public Contact find(long id) {
		/*try {
			Statement state = this.connect.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			String query = "SELECT * FROM contact WHERE id = '"+id+"'";
			ResultSet rs = state.executeQuery(query);
			
			//on place le curseur sur le dernier tuple
			rs.last();
			//on récupère le numéro de la ligne
			int nblines = rs.getRow();
			rs.beforeFirst();
			
			if (nblines == 0)
			{
				state.close();
				return null;
			}
			rs.next();
			Contact contact = new Contact(rs.getString("firstName"), rs.getString("lastName"), rs.getString("email"), rs.getInt("id"));
			state.close();
			return contact;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}*/
		/*Transaction transaction = HibernateUtil.currentSession().beginTransaction();
		Contact contact = (Contact)HibernateUtil.currentSession().get(Contact.class, id);
		transaction.commit();*/
		
		return this.getHibernateTemplate().get(Contact.class, new Long(id));
	}
	
	/** (non-Javadoc)
	 * @see dao.DAO#getAll()
	 * Renvoie tous les contacts se trouvant dans la base de données
	 * @return la liste des contacts
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Contact> getAll() {
		//Transaction t = HibernateUtil.currentSession().beginTransaction();
		
//		Query query = HibernateUtil.currentSession().createQuery("from Contact");
//		@SuppressWarnings(value="unchecked")
//		List<Contact> list = query.list();
		
		/*@SuppressWarnings(value="unchecked")
		List<Contact> list = HibernateUtil.currentSession().createCriteria(Contact.class).addOrder(Order.asc("lastName")).list();
		
		t.commit();*/
		
		return this.getHibernateTemplate().find("from Contact");
	}
}
