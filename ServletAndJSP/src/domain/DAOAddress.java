package domain;

import java.sql.Connection;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Transaction;

public class DAOAddress extends DAO<Address> {

	public DAOAddress(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(Address obj) {
		Transaction transaction = HibernateUtil.currentSession()
				.beginTransaction();
		HibernateUtil.currentSession().saveOrUpdate(obj);
		transaction.commit();

		return true;
	}

	@Override
	public boolean delete(long id) {
		Transaction transaction = HibernateUtil.currentSession()
				.beginTransaction();
		Address address = find(id);
		HibernateUtil.currentSession().delete(address);
		transaction.commit();

		return true;
	}

	@Override
	public boolean update(Address obj) {
		Transaction transaction = HibernateUtil.currentSession()
				.beginTransaction();
		HibernateUtil.currentSession().saveOrUpdate(obj);
		transaction.commit();

		return true;
	}

	@Override
	public Address find(long id) {
		Transaction transaction = HibernateUtil.currentSession()
				.beginTransaction();
		Address address = (Address) HibernateUtil.currentSession().get(
				Address.class, new Integer((int) id));
		transaction.commit();

		return address;
	}

	@Override
	public List<Address> getAll() {
		Transaction t = HibernateUtil.currentSession().beginTransaction();

		Query query = HibernateUtil.currentSession()
				.createQuery("from Address");
		@SuppressWarnings(value = "unchecked")
		List<Address> list = query.list();
		t.commit();

		return list;
	}

}
