package servlets;

import Connection.ServiceProxy;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SignIn
 */
@WebServlet("/signin")
public class SignIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  ServiceProxy proxy = new ServiceProxy();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignIn() {
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
		System.out.println("ENtered do Post of signin");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String qdone,userName;
		int userId;
		try{
			String user = request.getParameter("username");
			String pass = request.getParameter("password");
			 
			System.out.println("about to call web service for signIn");
			proxy.setEndpoint("http://localhost:8080/LinkedinServices/services/Service");
			qdone = proxy.signIn(user, pass);
			userId = proxy.getUserId(user, pass);
			userName= proxy.getUserNameById(userId);
			System.out.println("UserId and name after retrieving from service in signin"+userId+" :: "+ userName);
			HttpSession session = request.getSession();
			if(qdone.equals("true")){
				 System.out.println("inside sessions"+qdone.equals("true"));
				session.setAttribute("userSession", userId);
				 session.setAttribute("username", userName);
				 System.out.println("Usrname:"+userName);
				//out.println("WELCOME to Linkedin "+user);
				response.sendRedirect("createProfile.jsp");
			}
			else{
				response.sendRedirect("Login.jsp");
				out.println("\n <a href=\"Login.jsp\"><br>Go back to signUp again</a>");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
