package mdoc.tp1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AbstractDAOFactory;
import dao.DAO;
import domain.Contact;

/**
 * Servlet implementation class SearchContact
 */
public class SearchContact extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchContact() {
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
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// //Register the JDBC driver for MySQL.
		// try {
		// Class.forName("com.mysql.jdbc.Driver");
		//
		//
		// //Define URL of database server for
		// // database named mysql on the localhost
		// // with the default port number 3306.
		// String url =
		// "jdbc:mysql://localhost:3306/mdoc";
		//
		// //Get a connection to the database for a
		// // user named root with a blank password.
		// // This user is the default administrator
		// // having full privileges to do anything.
		// Connection con =
		// DriverManager.getConnection(
		// url,"root", "root");
		//
		// //Display URL and connection information
		// System.out.println("URL: " + url);
		// System.out.println("Connection: " + con);
		//
		// DAOContact daoContact = new DAOContact(con);
		// Contact contact =
		// daoContact.find((Long.parseLong((request.getParameter("id")))));
		// con.close();

		AbstractDAOFactory adf = AbstractDAOFactory
		.getFactory(AbstractDAOFactory.HIBERNATE_DAO_FACTORY);
		
		DAO<Contact> daoContact = adf.getDAOContact();
		long id = Long.parseLong(request.getParameter("id"));
		Contact contact = daoContact.find(id);

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		if (contact == null) {
			out.println("<h1>Pas de contact avec cet id</h1>");
		} else {
			out.println("Nom: " + contact.getLastName() + "<br>");
			out.println("Prenom: " + contact.getFirstName() + "<br>");
			out.println("email: " + contact.getEmail() + "<br>");
			String urlargs = "id=" + contact.getId() + "&firstname="
					+ contact.getFirstName() + "&lastname="
					+ contact.getLastName() + "&email=" + contact.getEmail();
			out.println("<a href='updateContact.jsp?" + urlargs
					+ "'>Modifier</a>");
		}
		out.println("</body></html>");
	}

}
