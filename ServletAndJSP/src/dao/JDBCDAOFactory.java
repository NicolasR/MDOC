package dao;

import java.sql.Connection;

import domain.Address;
import domain.Contact;
import domain.ContactGroup;
import domain.PhoneNumber;

public class JDBCDAOFactory extends AbstractDAOFactory {
	
	protected static Connection conn;
	
	public JDBCDAOFactory()
	{
		conn = null; 
	}

	@Override
	public DAO<Contact> getDAOContact() {
		return new DAOContact(conn);
	}

	@Override
	public DAO<Address> getDAOAddress() {
		return new DAOAddress(conn);
	}

	@Override
	public DAO<PhoneNumber> getDAOPhoneNumber() {
		return null;
	}

	@Override
	public DAO<ContactGroup> getDAOContactGroup() {
		return new DAOContactGroup(conn);
	}

}
