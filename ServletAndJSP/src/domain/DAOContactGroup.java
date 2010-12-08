package domain;

import java.sql.Connection;

import org.hibernate.Transaction;

public class DAOContactGroup extends DAO<ContactGroup> {

	public DAOContactGroup(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(ContactGroup obj) {
		Transaction transaction = HibernateUtil.currentSession().beginTransaction();
		HibernateUtil.currentSession().saveOrUpdate(obj);
		transaction.commit();
		HibernateUtil.closeSession();
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

}
