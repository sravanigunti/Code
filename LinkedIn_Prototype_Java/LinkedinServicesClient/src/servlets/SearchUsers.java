package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Connection.ServiceProxy;

/**
 * Servlet implementation class SearchUsers
 */
@WebServlet("/searchUser")
public class SearchUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServiceProxy proxy = new ServiceProxy();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchUsers() {
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
		String[] username =  {};
		 try{
			 System.out.println("Entered Search user");
			//Search data
				String text = request.getParameter("text");
				System.out.println("Calling webservice to create profile");
				proxy.setEndpoint("http://localhost:8080/LinkedinServices/services/Service");
				System.out.println("called web service");
								
				 
				Integer userId = (Integer)session.getAttribute("userSession"); 
				System.out.println("UserID in searchProfile doPost"+ userId);
				//To retrive search data
			 username = proxy.getAllUsers(text);
			 for(int i =0; i<username.length;i++)
			 {
			 System.out.println("Searcher users:"+username[i]);
			 }
			 	request.setAttribute("searchedUsers", username);
				
				request.getRequestDispatcher("searchUser.jsp").forward(request, response);
		 }
		 catch(Exception e){
				e.printStackTrace();
			}
	}

	}

 
