package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import javax.servlet.http.HttpSession;

import Connection.Education;
import Connection.Experience;
import Connection.ServiceProxy;
import Connection.Skills;
import Connection.Users;
/**
 * Servlet implementation class CreateProfile
 */
@WebServlet("/createProfile")
public class CreateProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServiceProxy proxy = new ServiceProxy();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		System.out.println("Session : "+session);
		
		Education education = new Education();
		
		System.out.println("Calling webservice to create profile");
		proxy.setEndpoint("http://localhost:8080/LinkedinServices/services/Service");
		System.out.println("called web service");
					
		
		//System.out.println("session.getAttribute(UserSession) "+Integer.parseInt(session.getAttribute("UserSession"));
		Integer userId = (Integer)session.getAttribute("userSession"); 
		System.out.println("UserID in createprofile doPost"+ userId);
		education = proxy.getEducationById(userId);
		request.setAttribute("education",education);
		
		System.out.println("Request for education:"+request);
		System.out.println("Response for education:"+response);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("displayProfile.jsp");
		requestDispatcher.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		System.out.println("Session : "+session);
		
		 PrintWriter out = response.getWriter();
		 response.setContentType("text/html");
		 String qdone,experience,userSummary,userSkills;
		 Education qdone1;
		 Experience experience1;
		 Users user1;
		 //String[] username;
		 Skills skills1;
		 
			try{
				//Summary Details
				String summary = request.getParameter("summary");
				System.out.println("");
				
				//Experience Details
				String companyName = request.getParameter("companyName");
				System.out.println("");
				String title = request.getParameter("title");
				System.out.println("");
				String location = request.getParameter("location");
				System.out.println("");
			//	Date startDate = new SimpleDateFormat("MM/dd/yyyy").parse(request.getParameter("startDate"));
			//  Date endDate =  new SimpleDateFormat("MM/dd/yyyy").parse(request.getParameter("endDate"));
				String expDescription = request.getParameter("expDescription");
				System.out.println("");
				
				
				//Education Details
				String level = request.getParameter("level");
				System.out.println("");
				String univname = request.getParameter("univname");
				System.out.println("");
				String field = request.getParameter("field");
				System.out.println("");
				int grade = Integer.parseInt(request.getParameter("grade"));
				System.out.println("");
				String description = request.getParameter("description");
				System.out.println("");
				
						
				
				//Skills
				String skills = request.getParameter("skills");
				System.out.println("");
				
				//Search data
				String text = request.getParameter("text");
				System.out.println("Calling webservice to create profile");
				proxy.setEndpoint("http://localhost:8080/LinkedinServices/services/Service");
				System.out.println("called web service");
							
				
				//System.out.println("session.getAttribute(UserSession) "+Integer.parseInt(session.getAttribute("UserSession"));
				Integer userId = (Integer)session.getAttribute("userSession"); 
				System.out.println("UserID in createprofile doPost"+ userId);
				// To Insert Profile details
				qdone = proxy.insertEducation(field, level, univname, grade, description, userId) ;
				experience = proxy.insertExperience(companyName, userId, title, location, expDescription);
				userSummary = proxy.insertSummary(summary, userId);
				userSkills = proxy.insertSkills(skills, userId);
				
				//To Retrieve Profile Details
				qdone1 = proxy.getEducationById(userId);
				experience1 = proxy.getExperienceById(userId);
				user1 = proxy.getSummaryById(userId);
				skills1 = proxy.getSkillsById(userId);
				
				
				//To retrive search data
			//	username = proxy.getAllUsers(text);
				
				if(qdone.substring(0,4).equals("true")){
					session.setAttribute("userSession", session);
					request.setAttribute("education",qdone1);
					request.setAttribute("experience", experience1);
					request.setAttribute("userSummary",user1);
					request.setAttribute("skills", skills1);
					
					request.getRequestDispatcher("displayProfile.jsp").forward(request, response);
					//out.println("WELCOME to DISPLAY PROFILE: "+ univname);
					 //response.sendRedirect("displayProfile.jsp");
				}
				else{
					out.println(qdone.substring(5));
					out.println("\n <a href=\"Login.jsp\"><br>Go back to signIn again</a>");
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			}
		 
	}

 
