package dao;

import domain.Address;
import domain.Contact;
import domain.ContactGroup;
import domain.PhoneNumber;

/**
 * @author Charles DUFOUR
 * @author Nicolas RIGNAULT
 * Factory pour les différents DAO
 *
 */
public abstract class AbstractDAOFactory {
	
	/**
	 * Communication de type JDBC
	 */
	public static final int JDBC_DAO_FACTORY = 0;
	
	/**
	 * Communication de type Hibernate
	 */
	public static final int HIBERNATE_DAO_FACTORY = 1;


	/**
	 * Renvoie le DAO de gestion des contacts
	 * @return dao de gestion des contacts
	 */
	public abstract DAO<Contact> getDAOContact();

	/**
	 * Renvoie le DAO de gestion des adresses
	 * @return dao de gestion des adresses
	 */
	public abstract DAO<Address> getDAOAddress();

	/**
	 * Renvoie le DAO de gestion des numéros de téléphone
	 * @return dao de gestion des numéros de téléphones
	 */
	public abstract DAO<PhoneNumber> getDAOPhoneNumber();

	/**
	 * Renvoie le DAO de gestion des groupes
	 * @return dao de gestion des groupes
	 */
	public abstract DAO<ContactGroup> getDAOContactGroup();
	
	/**
	 * Renvoie la factory avec le type de connexion associé
	 * @param type le type de communication demandé
	 * @return la factory associée
	 */
	public static AbstractDAOFactory getFactory(int type){
		switch(type){
			case JDBC_DAO_FACTORY :
				return new JDBCDAOFactory();
			case HIBERNATE_DAO_FACTORY: 
				return new HibernateDAOFactory();
			default:
				return null;
		}
	}
}
