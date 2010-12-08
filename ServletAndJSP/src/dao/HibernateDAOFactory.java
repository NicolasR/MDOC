package dao;

import domain.Address;
import domain.Contact;
import domain.ContactGroup;
import domain.PhoneNumber;

public class HibernateDAOFactory extends AbstractDAOFactory {

	@Override
	public DAO<Contact> getDAOContact() {
		return new DAOContact(null);
	}

	@Override
	public DAO<Address> getDAOAddress() {
		return new DAOAddress(null);
	}

	@Override
	public DAO<PhoneNumber> getDAOPhoneNumber() {
		return null;
	}

	@Override
	public DAO<ContactGroup> getDAOContactGroup() {
		return new DAOContactGroup(null);
	}

}
