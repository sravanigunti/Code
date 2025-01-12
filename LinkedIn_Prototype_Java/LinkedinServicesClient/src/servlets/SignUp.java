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
 * Servlet implementation class SignUp
 */
@WebServlet("/signup")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
      ServiceProxy proxy = new ServiceProxy();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUp() {
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
		String username;
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String qdone,userName;
		int userId;
		try{
			if(request.getParameter("last") != null)
				username = request.getParameter("first") + " " + request.getParameter("last");
			else
				username = request.getParameter("first");
			String email = request.getParameter("email");
			String pass = request.getParameter("pass");
			System.out.println("about to call web service");
			proxy.setEndpoint("http://localhost:8080/LinkedinServices/services/Service");
			qdone = proxy.signUp(username,email,pass);
			userId = proxy.getUserId(email, pass);
			userName= proxy.getUserNameById(userId);
			System.out.println("UserId after retrieving from service in signin"+userId);
			HttpSession session = request.getSession();
			if(qdone.substring(0,4).equals("true")){
				session.setAttribute("userSession", userId);
				session.setAttribute("username", userName);
				out.println("WELCOME to Linkedin : "+username);
				response.sendRedirect("createProfile.jsp");
			}
			else{
				out.println(qdone.substring(5));
				out.println("\n <a href=\"Login.jsp\"><br>Go back to signUp again</a>");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
