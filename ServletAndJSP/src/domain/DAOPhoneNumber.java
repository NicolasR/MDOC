package domain;

import java.sql.Connection;

public class DAOPhoneNumber extends DAO<PhoneNumber> {

	public DAOPhoneNumber(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(PhoneNumber obj) {
		// TODO Auto-generated method stub
		return false;
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
