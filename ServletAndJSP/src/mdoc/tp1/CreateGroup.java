package mdoc.tp1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AbstractDAOFactory;
import dao.DAO;
import domain.ContactGroup;

/**
 * Servlet implementation class CreateGroup
 */
public class CreateGroup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateGroup() {
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
		AbstractDAOFactory adf = AbstractDAOFactory
				.getFactory(AbstractDAOFactory.HIBERNATE_DAO_FACTORY);
		DAO<ContactGroup> daoContactGroup = adf.getDAOContactGroup();

		boolean needToCreate = true;
		for (ContactGroup group : daoContactGroup.getAll()) {
			if (group.getGroupName().equals(request.getParameter("newGroup")))
			{
				needToCreate = false;
				break;
			}
		}
		if (needToCreate)
		{
			ContactGroup contactGroup = new ContactGroup();
			contactGroup.setGroupName(request.getParameter("newGroup"));
			daoContactGroup.create(contactGroup);
		}
		request.getRequestDispatcher("addContact.jsp").forward(request, response);
	}

}
