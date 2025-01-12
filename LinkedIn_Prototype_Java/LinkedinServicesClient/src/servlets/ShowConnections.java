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
 * Servlet implementation class ShowConnections
 */
@WebServlet("/showConnections")
public class ShowConnections extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServiceProxy proxy = new ServiceProxy();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowConnections() {
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
		 String displayConnections[];
		 try
		 {
			System.out.println("Calling webservice to create profile");
			proxy.setEndpoint("http://localhost:8080/LinkedinServices/services/Service");
			System.out.println("called web service");
			Integer userId = (Integer)session.getAttribute("userSession"); 
			System.out.println("UserID in searchProfile doPost"+ userId);
			displayConnections= proxy.displayConnections(userId);
			 for(int i =0; i<displayConnections.length;i++)
			 {
			 System.out.println("display connections:"+displayConnections[i]);
			 
			 }
			 request.setAttribute("displayConnections", displayConnections);
			 request.getRequestDispatcher("showConnections.jsp").forward(request, response);
		 }
		 catch(Exception e)
		 {
				e.printStackTrace();
		}
		 }
	}

 
