package domain;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DAOContact extends DAO<Contact> {
	Session session = null;
	
	public DAOContact(Connection conn) {
		super(conn);
		try
		{
			SessionFactory sessionFactory =
				new Configuration().configure().buildSessionFactory();
			session = sessionFactory.openSession();
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

	@Override
	public boolean create(Contact contact) {
		/*long id = contact.getId();
		String firstName = contact.getFirstName();
		String lastName = contact.getLastName();
		String email = contact.getEmail();
		try {
			Statement state = this.connect.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			String query = "INSERT INTO contact (firstName, lastName, email, id) VALUES ('" + firstName + "','" + lastName + "','" + email + "','" + id + "')";
			state.executeUpdate(query);
			state.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;*/
		Transaction transaction = session.beginTransaction();
		session.save(contact);
		transaction.commit();
		return true;
	}

	@Override
	public boolean delete(long id) {
		try {
			Statement state = this.connect.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			String query = "DELETE FROM contact WHERE id = '"+id+"'";
			state.execute(query);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean update(Contact obj) {
		try {
			Statement state = this.connect.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			String firstName = obj.getFirstName();
			String lastName = obj.getLastName();
			String email = obj.getEmail();
			long id = obj.getId();
			String query = "UPDATE contact SET firstName = '" + firstName + "', lastName='" + lastName + "', "
				+ "email='"+email+"', id='"+id+"'";
			System.out.println(query);
			state.executeUpdate(query);
			state.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Contact find(long id) {
		/*try {
			Statement state = this.connect.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			String query = "SELECT * FROM contact WHERE id = '"+id+"'";
			ResultSet rs = state.executeQuery(query);
			
			//on place le curseur sur le dernier tuple
			rs.last();
			//on récupère le numéro de la ligne
			int nblines = rs.getRow();
			rs.beforeFirst();
			
			if (nblines == 0)
			{
				state.close();
				return null;
			}
			rs.next();
			Contact contact = new Contact(rs.getString("firstName"), rs.getString("lastName"), rs.getString("email"), rs.getInt("id"));
			state.close();
			return contact;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}*/
		return null;
	}

}
