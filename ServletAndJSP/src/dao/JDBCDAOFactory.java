package dao;

import java.sql.Connection;

import domain.Address;
import domain.Contact;
import domain.ContactGroup;
import domain.PhoneNumber;

/**
 * @author Charles DUFOUR
 * @author Nicolas RIGNAULT
 * Factory associée à JDBC
 */
public class JDBCDAOFactory extends AbstractDAOFactory {
	
	/**
	 * Connexion
	 */
	protected static Connection conn;
	
	/**
	 * Constructeur qui initialise une connexion nulle
	 */
	public JDBCDAOFactory()
	{
		conn = null; 
	}

	/* (non-Javadoc)
	 * @see dao.AbstractDAOFactory#getDAOContact()
	 */
	@Override
	public DAO<Contact> getDAOContact() {
		return new DAOContact(conn);
	}

	/* (non-Javadoc)
	 * @see dao.AbstractDAOFactory#getDAOAddress()
	 */
	@Override
	public DAO<Address> getDAOAddress() {
		return new DAOAddress(conn);
	}

	/* (non-Javadoc)
	 * @see dao.AbstractDAOFactory#getDAOPhoneNumber()
	 */
	@Override
	public DAO<PhoneNumber> getDAOPhoneNumber() {
		return null;
	}

	/* (non-Javadoc)
	 * @see dao.AbstractDAOFactory#getDAOContactGroup()
	 */
	@Override
	public DAO<ContactGroup> getDAOContactGroup() {
		return new DAOContactGroup(conn);
	}

}
