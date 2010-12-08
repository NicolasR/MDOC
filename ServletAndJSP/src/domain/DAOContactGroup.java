package domain;

import java.sql.Connection;
import java.util.List;

import org.hibernate.Query;
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

	@Override
	public List<ContactGroup> getAll() {
		Transaction t = HibernateUtil.currentSession().beginTransaction();
		
		Query query = HibernateUtil.currentSession().createQuery("from ContactGroup");
		@SuppressWarnings(value="unchecked")
		List<ContactGroup> list = query.list();
		t.commit();
		return list;
	}

}
