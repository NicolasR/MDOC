package mdoc.tp1;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AbstractDAOFactory;
import dao.DAO;
import domain.Address;
import domain.Contact;
import domain.ContactGroup;
import domain.Entreprise;
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
		// try {
		//
		// //Register the JDBC driver for MySQL.
		// Class.forName("com.mysql.jdbc.Driver");
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
		// Contact contact = new Contact(request.getParameter("firstName"),
		// request.getParameter("lastName"),
		// request.getParameter("email"),
		// Integer.parseInt(request.getParameter("id")));
		//
		// daoContact.create(contact);
		// con.close();
		// }
		// catch (Exception e) {
		// e.printStackTrace();
		// }
		AbstractDAOFactory adf = AbstractDAOFactory
				.getFactory(AbstractDAOFactory.HIBERNATE_DAO_FACTORY);

		/**
		 * Définition de l'adresse
		 */
		Address address = new Address();
		address.setCity(request.getParameter("city"));
		address.setStreet(request.getParameter("street"));
		address.setCountry(request.getParameter("country"));
		address.setZip(request.getParameter("zip"));

		/**
		 * Récupération du nom, prénom et email
		 */
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		
		DAO<Contact> daoContact = adf.getDAOContact();
		
		/**
		 * Définition des numéros de téléphone
		 */
		PhoneNumber newphoneNumber = new PhoneNumber();
		String phoneKind = request.getParameter("phoneKind");
		String phoneNumber = request.getParameter("phoneNumber");
		newphoneNumber.setPhoneKind(phoneKind);
		newphoneNumber.setPhoneNumber(phoneNumber);
		
		/**
		 * Ajout d'une liste de numéros
		 */
		HashSet<PhoneNumber> listNumbers = new HashSet<PhoneNumber>();
		listNumbers.add(newphoneNumber);
		
		/**
		 * Définie si le contact est une entreprise ou non
		 */
		Contact contact;
		String isEntreprise = request.getParameter("isEntreprise");
		String numSiret = request.getParameter("numSiret");
		if (isEntreprise != null && isEntreprise.equals("on")) {
			contact = new Entreprise();
			((Entreprise) contact).setNumSiret(Integer.parseInt(numSiret));
			newphoneNumber.setContact(contact);
		} else {
			contact = new Contact();
		}
	
		/**
		 * Ajout des informations diverses
		 */
		contact.setAddress(address);
		contact.setEmail(email);
		contact.setFirstName(firstName);
		contact.setLastName(lastName);
		contact.setPhones(listNumbers);
		contact.setPhones(listNumbers);
		
		/**
		 * Ajout des groupes associés au contact
		 */
		DAO<ContactGroup> daoContactGroup = adf.getDAOContactGroup();
		List<ContactGroup> groups = daoContactGroup.getAll();
		HashSet<ContactGroup> set = new HashSet<ContactGroup>();
		for (ContactGroup group : groups) {
			String groupString = request.getParameter(group.getGroupName());
			if (groupString != null && groupString.equals("on")) {
				group.getContacts().add(contact);
				set.add(group);
			}
		}
		contact.setGroups(set);
		
		/**
		 * Création du contact
		 */
		daoContact.create(contact);
	}

}
