package dao;

import domain.Address;
import domain.Contact;
import domain.ContactGroup;
import domain.PhoneNumber;

/**
 * @author Charles DUFOUR
 * @author Nicolas RIGNAULT
 * Factory associée à Hibernate
 *
 */
public class HibernateDAOFactory extends AbstractDAOFactory {

	
	/* (non-Javadoc)
	 * @see dao.AbstractDAOFactory#getDAOContact()
	 */
	@Override
	public DAO<Contact> getDAOContact() {
		return new DAOContact(null);
	}

	/* (non-Javadoc)
	 * @see dao.AbstractDAOFactory#getDAOAddress()
	 */
	@Override
	public DAO<Address> getDAOAddress() {
		return new DAOAddress(null);
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
		return new DAOContactGroup(null);
	}

}
