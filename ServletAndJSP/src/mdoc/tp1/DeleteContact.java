package mdoc.tp1;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import dao.AbstractDAOFactory;
import dao.DAO;
import domain.Address;
import domain.Contact;
import domain.ContactGroup;

/**
 * Servlet implementation class deleteContact
 */
public class DeleteContact extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteContact() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// Register the JDBC driver for MySQL.
		/*
		 * try { Class.forName("com.mysql.jdbc.Driver");
		 * 
		 * 
		 * //Define URL of database server for // database named mysql on the
		 * localhost // with the default port number 3306. String url =
		 * "jdbc:mysql://localhost:3306/mdoc";
		 * 
		 * //Get a connection to the database for a // user named root with a
		 * blank password. // This user is the default administrator // having
		 * full privileges to do anything. Connection con =
		 * DriverManager.getConnection( url,"root", "root");
		 * 
		 * //Display URL and connection information System.out.println("URL: " +
		 * url); System.out.println("Connection: " + con);
		 * 
		 * DAOContact daoContact = new DAOContact(con);
		 * daoContact.delete(Long.parseLong((request.getParameter("id"))));
		 * con.close(); } catch (ClassNotFoundException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); } catch (SQLException
		 * e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 */

		
		
		//Spring
		//AbstractDAOFactory adf = AbstractDAOFactory
		//		.getFactory(AbstractDAOFactory.HIBERNATE_DAO_FACTORY);
		//DAO<Contact> daoContact = adf.getDAOContact();
		//DAO<Address> daoAddress = adf.getDAOAddress();
		ApplicationContext context =
			WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		DAO<Contact> daoContact = (DAO<Contact>)context.getBean("DAOContact");
		DAO<Address> daoAddress = (DAO<Address>)context.getBean("DAOAddress");
		//end Spring
		
		for (Contact c : daoContact.getAll()) {
			String s = request.getParameter(c.getId().toString());
			if (s != null && s.equals("on")) {
				long addressId = c.getAddress().getId();
				c.setAddress(null);
				List<Contact> list = daoContact.query("from Contact where address="+addressId);
				if (list.size() == 1)
					daoAddress.delete(addressId);
				daoContact.delete(c.getId());
			}
		}
	}

}
