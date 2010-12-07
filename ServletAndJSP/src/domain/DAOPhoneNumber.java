package domain;

import java.sql.Connection;

import org.hibernate.Transaction;

public class DAOPhoneNumber extends DAO<PhoneNumber> {

	public DAOPhoneNumber(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(PhoneNumber obj) {
		Transaction transaction = HibernateUtil.currentSession().beginTransaction();
		HibernateUtil.currentSession().save(obj);
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
	public boolean update(PhoneNumber obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public PhoneNumber find(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
