package dao;

import domain.Address;
import domain.Contact;
import domain.ContactGroup;
import domain.PhoneNumber;

public abstract class AbstractDAOFactory {
	public static final int JDBC_DAO_FACTORY = 0;
	public static final int HIBERNATE_DAO_FACTORY = 1;


	public abstract DAO<Contact> getDAOContact();

	public abstract DAO<Address> getDAOAddress();

	public abstract DAO<PhoneNumber> getDAOPhoneNumber();

	public abstract DAO<ContactGroup> getDAOContactGroup();
	
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
