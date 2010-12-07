package mdoc.tp1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.ContactGroup;
import domain.DAOContactGroup;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOContactGroup daoContactGroup = new DAOContactGroup(null);
		ContactGroup contactGroup = new ContactGroup();
		contactGroup.setGroupName(request.getParameter("newGroup"));
		daoContactGroup.create(contactGroup);
		request.getRequestDispatcher("accueil.jsp").forward(request,
				response);
	}

}
