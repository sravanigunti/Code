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
 * Servlet implementation class Invitations
 */
@WebServlet("/sendInvitation")
public class Invitations extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServiceProxy proxy = new ServiceProxy();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Invitations() {
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
		 String sendInvitation;
		 try
		 {
			 System.out.println("Entered to send an invitation"); 
			 String toIdname = request.getParameter("toIdname");
			 System.out.println("To id user Name:"+toIdname);
			  int toId = proxy.getUserIdByName(toIdname);
			 System.out.println("To ID:"+toId);
			 
			Integer userId =(Integer)session.getAttribute("userSession");
			System.out.println("User Id in invi:"+userId);
			 sendInvitation = proxy.sendInvitations(userId, toId);
			System.out.println("Invi sent... am back in do Post");
			 
		 	request.getRequestDispatcher("sendInvitation.jsp").forward(request, response);
		 }
		 catch(Exception e)
		 {
				e.printStackTrace();
		}
	}

}
