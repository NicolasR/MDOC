package mdoc.tp1;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Address;
import domain.Contact;
import domain.DAOAddress;
import domain.DAOContact;
import domain.DAOPhoneNumber;
import domain.PhoneNumber;

/**
 * Servlet implementation class NewContact
 */
public class NewContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewContact() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		try {
//
//		      //Register the JDBC driver for MySQL.
//		      Class.forName("com.mysql.jdbc.Driver");
//
//		      //Define URL of database server for
//		      // database named mysql on the localhost
//		      // with the default port number 3306.
//		      String url =
//		            "jdbc:mysql://localhost:3306/mdoc";
//
//		      //Get a connection to the database for a
//		      // user named root with a blank password.
//		      // This user is the default administrator
//		      // having full privileges to do anything.
//		      Connection con =
//		                     DriverManager.getConnection(
//		                                 url,"root", "root");
//
//		      //Display URL and connection information
//		      System.out.println("URL: " + url);
//		      System.out.println("Connection: " + con);
//		      
//		      DAOContact daoContact = new DAOContact(con);
//		      Contact contact = new Contact(request.getParameter("firstName"), 
//		    		  request.getParameter("lastName"),
//		    		  request.getParameter("email"),
//		    		  Integer.parseInt(request.getParameter("id")));
//		      
//		      daoContact.create(contact);
//		      con.close();
//		}
//		catch (Exception e) {
//			e.printStackTrace();
//		}
		
		DAOAddress daoAddress = new DAOAddress(null);
		Address address = new Address();
		address.setCity(request.getParameter("city"));
		address.setStreet(request.getParameter("street"));
		address.setCountry(request.getParameter("country"));
		address.setZip(request.getParameter("zip"));
		daoAddress.create(address);
		
		DAOContact daoContact = new DAOContact(null);
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		Contact contact = new Contact(firstName, lastName, email);
		contact.setAddress(address);
		contact.setFirstName(firstName);
		contact.setLastName(lastName);
		contact.setFirstName(email);
		
		DAOPhoneNumber daophonenumber = new DAOPhoneNumber(null);
		PhoneNumber newphoneNumber = new PhoneNumber();
		String phoneKind = request.getParameter("phoneKind");
		String phoneNumber = request.getParameter("phoneNumber");
		newphoneNumber.setPhoneKind(phoneKind);
		newphoneNumber.setPhoneNumber(phoneNumber);
		ArrayList<PhoneNumber> listNumbers = new ArrayList<PhoneNumber>();
		listNumbers.add(newphoneNumber);
		contact.setPhones(listNumbers);
		daoContact.create(contact);
	}

}
