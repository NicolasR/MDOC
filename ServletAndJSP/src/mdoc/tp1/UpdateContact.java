package mdoc.tp1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import dao.DAO;
import dao.DAOContact;
import domain.Contact;

/**
 * Servlet implementation class UpdateContact
 */
public class UpdateContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateContact() {
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
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//try {
		//Class.forName("com.mysql.jdbc.Driver");
		

	      //Define URL of database server for
	      // database named mysql on the localhost
	      // with the default port number 3306.
	      //String url =
	      //      "jdbc:mysql://localhost:3306/mdoc";

	      //Get a connection to the database for a
	      // user named root with a blank password.
	      // This user is the default administrator
	      // having full privileges to do anything.
	      /*Connection con;
			con = DriverManager.getConnection(
			             url,"root", "root");*/
		

	      //Display URL and connection information
	      //System.out.println("URL: " + url);
	      //System.out.println("Connection: " + con);
	      
	      //DAOContact daoContact = new DAOContact(con);
		  
		  ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		  DAO<Contact> daoContact = (DAO<Contact>)context.getBean("DAOContact");
	      String firstName = request.getParameter("firstName");
	      String lastName = request.getParameter("lastName");
	      String email = request.getParameter("email");
	      String id = request.getParameter("id");
	      Contact contact = daoContact.find(Long.parseLong(id));
	      contact.setFirstName(firstName);
	      contact.setLastName(lastName);
	      contact.setEmail(email);
	      daoContact.update(contact);
	      /*con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

}
