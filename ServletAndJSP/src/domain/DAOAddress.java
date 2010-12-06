package domain;

import java.sql.Connection;

import org.apache.catalina.authenticator.SavedRequest;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DAOAddress extends DAO<Address> {
	Session session = null;

	public DAOAddress(Connection conn) {
		super(conn);
		try{
		SessionFactory sessionFactory =
		new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();
		} catch(Exception e){
		System.out.println(e.getMessage());
		}
	}

	@Override
	public boolean create(Address obj) {
		Transaction transaction = session.beginTransaction();
		session.save(obj);
		transaction.commit();
		return true;
	}

	@Override
	public boolean delete(long id) {
		Transaction transaction = session.beginTransaction();
		Address address = find(id);
		session.delete(address);
		transaction.commit();
		return true;
	}

	@Override
	public boolean update(Address obj) {
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(obj);
		transaction.commit();
		return true;
	}

	@Override
	public Address find(long id) {
		Address address = (Address)session.load(Address.class, new Integer((int)id));
		return address;
	}

}
