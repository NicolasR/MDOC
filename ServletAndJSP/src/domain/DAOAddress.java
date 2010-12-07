package domain;

import java.sql.Connection;

import org.apache.catalina.authenticator.SavedRequest;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DAOAddress extends DAO<Address> {

	public DAOAddress(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(Address obj) {
		this.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(obj);
		transaction.commit();
		this.closeSession();
		return true;
	}

	@Override
	public boolean delete(long id) {
		this.openSession();
		Transaction transaction = session.beginTransaction();
		Address address = find(id);
		session.delete(address);
		transaction.commit();
		this.closeSession();
		return true;
	}

	@Override
	public boolean update(Address obj) {
		this.openSession();
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(obj);
		transaction.commit();
		this.closeSession();
		return true;
	}

	@Override
	public Address find(long id) {
		Transaction transaction = session.beginTransaction();
		Address address = (Address)session.load(Address.class, new Integer((int)id));
		transaction.commit();
		return address;
	}

}
