package domain;

import java.sql.Connection;

import org.hibernate.Transaction;

public class DAOAddress extends DAO<Address> {

	public DAOAddress(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(Address obj) {
		Transaction transaction = HibernateUtil.currentSession().beginTransaction();
		HibernateUtil.currentSession().save(obj);
		transaction.commit();
		HibernateUtil.closeSession();
		return true;
	}

	@Override
	public boolean delete(long id) {
		Transaction transaction = HibernateUtil.currentSession().beginTransaction();
		Address address = find(id);
		HibernateUtil.currentSession().delete(address);
		transaction.commit();
		HibernateUtil.closeSession();
		return true;
	}

	@Override
	public boolean update(Address obj) {
		Transaction transaction = HibernateUtil.currentSession().beginTransaction();
		HibernateUtil.currentSession().saveOrUpdate(obj);
		transaction.commit();
		HibernateUtil.closeSession();
		return true;
	}

	@Override
	public Address find(long id) {
		Transaction transaction = HibernateUtil.currentSession().beginTransaction();
		Address address = (Address)HibernateUtil.currentSession().load(Address.class, new Integer((int)id));
		transaction.commit();
		HibernateUtil.closeSession();
		return address;
	}

}
