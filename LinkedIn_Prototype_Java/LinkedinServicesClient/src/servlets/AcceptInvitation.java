package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Connection.ServiceProxy;

/**
 * Servlet implementation class AcceptInvitation
 */
@WebServlet("/acceptInvitation")
public class AcceptInvitation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServiceProxy proxy = new ServiceProxy();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AcceptInvitation() {
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
		HttpSession session = request.getSession(false);
		System.out.println("Session : "+session);
		
		 PrintWriter out = response.getWriter();
		 response.setContentType("text/html");
		 String acceptInvitations;
		 try
		 {
			 System.out.println("Entered to accept an invitation");
			 String fromIdname = request.getParameter("name");
			 System.out.println("To id user Name:"+fromIdname);
			 int  userIdConn= proxy.getUserIdByName(fromIdname);
			 int connectionID = proxy.getConnectionID(userIdConn);
			 System.out.println("user id for connections"+userIdConn);
			 
			 Integer userId =(Integer)session.getAttribute("userSession");
			 System.out.println("User ID who is accepting invitations"+userId);
			 acceptInvitations= proxy.acceptInvitations(connectionID);
			 System.out.println("Connection is accepted successfully");
			 
			 request.getRequestDispatcher("acceptInvitation.jsp").forward(request, response);
		 }
		 catch(Exception e)
		 {
			e.printStackTrace();
		 }
		 }
	}


