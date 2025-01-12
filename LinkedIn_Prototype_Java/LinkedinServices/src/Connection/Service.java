package Connection;

import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.jws.WebService;

@WebService
public class Service {
	Connection con;
	Statement stat;
	//Sign Up Scenario
	public String signUp(String username,String email, String password){	
		int rowcount;
		System.out.println("Inside Signup");
		con = DatabaseConnection.getConnection();
		String result = "";
		System.out.println("Username:"+username +"email:"+email+"password:"+password);
		
		password = getMD5(password);
				
		try{	
			String query = "Insert into users (username,email_id,password) values ('"+username+"','"+email+"','"+password+"')";
			stat = con.createStatement();
			rowcount = stat.executeUpdate(query);
			System.out.println(rowcount);
			if(rowcount > 0){
				result = "true";
				System.out.println("Insert Successfully");
			}
			else{
				result="false: The data could not be inserted in the database.";
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	
		return result;
	}
	
	
	//Password hashing
	public String getMD5(String data) {
		System.out.println("Password in MD5:"+data);
        String result = null;
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
            md.update(data.getBytes(Charset.forName("UTF-8")));
            result = String.format(Locale.ROOT, "%032x", new BigInteger(1, md.digest()));
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e);
        }
        return result;
	}

	//Sign In Scenario
	public String signIn(String username,String password) throws SQLException{
		System.out.println("Inside SignIn"+password);
		ResultSet rs=null;
		
		con = DatabaseConnection.getConnection();
		String result = "false";
		int rowcount;		
		try{
			
			String query = "Select password from users where email_id='" + username +"'" ;
			System.out.println("Query : "+query);
			stat = con.createStatement();
			rs = stat.executeQuery(query);
			while(rs.next()){
				String pass = rs.getString("password");
				System.out.println("Password from db:"+pass);
				password = getMD5(password);
				System.out.println("Password AFTER getMD5:"+password);
				if(password.equals(pass)){
					System.out.println(password.equals(pass));
					result = "true";
				}
			}
			rs.close();
		}catch(SQLException e){
			e.printStackTrace();
		}

			
		return result;	
	}
 
	//Retrieve user Id only 
public int getUserId(String username,String password)throws SQLException 
{	 
ResultSet rs=null;
con = DatabaseConnection.getConnection();
  
int userId = 0;
try{
	String pwd = getMD5(password);
	String userIdDB = "Select user_id from users where email_id='" + username + "' and password='"+pwd+ "'";
	System.out.println("Query : "+userIdDB);
	stat = con.createStatement();
	rs = stat.executeQuery(userIdDB);
	while(rs.next())
	{
		  userId = rs.getInt("user_id");
		  System.out.println("UserID in getUserId:"+ userId); 
		return userId;
	}
	 
	rs.close();
}catch(SQLException e){
	e.printStackTrace();
}
	return userId;
}


//retrieve username
public String getUserNameById(int userId)throws SQLException 
{	 
ResultSet rs=null;
con = DatabaseConnection.getConnection();
  
String userName = "";
try{
 
	String user = "Select username from users where user_id='" +userId+ "'";
	System.out.println("Query : "+user);
	stat = con.createStatement();
	rs = stat.executeQuery(user);
	while(rs.next())
	{
		userName = rs.getString("username");
		  System.out.println("UserID in getUserId:"+ userName); 
		return userName;
	}
	 
	rs.close();
}catch(SQLException e){
	e.printStackTrace();
}
	return userName;
}
//Inserting education
public String insertEducation(String field,String level, String univname,int grade,String description,int userId)throws SQLException {	
	int rowcount;
	System.out.println("Inside inserting education");
	con = DatabaseConnection.getConnection();
	String result = "";
	System.out.println("field:"+field +"level :"+level+"univ name:"+univname); 
			
	try{	
		String query = "Insert into education (level,univ_name,field,grade,description, user_id) values ('"+level+"','"+univname+"','"+field+"','"+grade+"','"+description+ "','"+userId+"')";
		stat = con.createStatement();
		rowcount = stat.executeUpdate(query);
		System.out.println(rowcount);
		if(rowcount > 0){
			result = "true";
			System.out.println("Insert Successfully education");
		}
		else{
			result="false: The data could not be inserted in the database.";
		}
	}catch(SQLException e){
		e.printStackTrace();
	}

	return result;
}

//Inserting experience
public String insertExperience(String companyName, int userId, String title, String location, String description)throws SQLException{
	int rowcount;
	System.out.println("Inside inserting experience");
	con = DatabaseConnection.getConnection();
	String result ="";
	System.out.println("CompanyName:"+companyName+"UserId:"+userId+"title:"+title+"location:"+location );
	try{
		String query ="Insert into experience(company_name, user_id,title,location, description) values ('"+companyName+"','"+userId+"','"+title+"','"+location+ "','"+description+"')";
		System.out.println("Query to insert experience:"+query);
		stat =  con.createStatement();
		rowcount = stat.executeUpdate(query);
		System.out.println(rowcount);
		if(rowcount>0)
		{
			result ="true";
			System.out.println("Insert education successfully");
		}
		else{
			result="false: The data could not be inserted in the database.";
		}
	}
	catch(SQLException e){
		e.printStackTrace();
	}
	return result;
}

//Inserting summary
public String insertSummary(String summary,int userId)throws SQLException
{
	int rowcount;
	System.out.println("Inside inserting summary");
	con = DatabaseConnection.getConnection();
	String result ="";
	System.out.println("Summary:"+summary+"UserId:"+userId);
	try
	{
		String query = "update users set summary = '"+summary+"' where user_id = '"+userId+"';";
		System.out.println("QUery to insert summary:"+query);
		stat=con.createStatement();
		rowcount = stat.executeUpdate(query);
		System.out.println(rowcount);
		if(rowcount>0)
		{
			result = "true";
			System.out.println("Insert summary successfully");
		}
		else{
			result="false: The data could not be inserted in the database.";
		}
	}
	catch(SQLException e){
		e.printStackTrace();
	}
	return result;
}

//inserting skills
public String insertSkills(String skills, int userId)throws SQLException
{
	int rowcount;
	System.out.println("Inside inserting skills");
	con = DatabaseConnection.getConnection();
	String result ="";
	System.out.println("Skills:"+skills+"UserId:"+userId);
	try
	{
		String query = "insert into skills(user_id,skillset) values ('"+userId+"','"+skills+"')";
		System.out.println("QUery to insert summary:"+query);
		stat=con.createStatement();
		rowcount = stat.executeUpdate(query);
		System.out.println(rowcount);
		if(rowcount>0)
		{
			result = "true";
			System.out.println("Insert Skills successfully");
		}
		else{
			result="false: The data could not be inserted in the database.";
		}
	}
	catch(SQLException e){
		e.printStackTrace();
	}
	return result;
}

//retrieving education by id
public Education getEducationById(int userId)throws SQLException
{
	ResultSet rs=null;
	System.out.println("Retrieve education by id ");
	con = DatabaseConnection.getConnection();
	Education edu =  new Education();
	try{
	String getEdu = "select * from education where user_id='"+ userId +"'";
	System.out.println("Query for getEducationById:"+getEdu);
	stat = con.createStatement();
	rs = stat.executeQuery(getEdu);
	 
	while(rs.next())
	{
		edu.setLevel(rs.getString("level"));
		edu.setUniv_name(rs.getString("univ_name"));
		edu.setField(rs.getString("field"));
		edu.setGrade(rs.getInt("grade"));
		edu.setDescription(rs.getString("description"));
		edu.setStart_date(rs.getDate("start_date"));
		edu.setEnd_date(rs.getDate("end_date"));
		edu.setUser_id(rs.getInt("user_id"));
	}
	
	return edu;
	}
	catch(SQLException e){
		e.printStackTrace();
	}
	return edu;
}

//retrieving experience by Id 
public Experience getExperienceById(int userId)throws SQLException
{
	ResultSet rs=null;
	System.out.println("Retrieve experience By ID");
	con = DatabaseConnection.getConnection();
	Experience exp =  new Experience();
	try{
	String getEx = "select * from experience where user_id='"+ userId +"';";
	System.out.println("Query for getExperienceById:"+getEx);
	stat = con.createStatement();
	rs = stat.executeQuery(getEx);
	 
	while(rs.next())
	{
		exp.setCompany_name(rs.getString("company_name"));
		exp.setUser_id(rs.getInt("user_id"));
		exp.setTitle(rs.getString("title"));
		exp.setLocation(rs.getString("location"));
		//exp.setStart_date(rs.getDate("start_date"));
		//exp.setEnd_date(rs.getDate("end_date"));
		exp.setDescription(rs.getString("description"));
		exp.setUser_id(rs.getInt("user_id"));
    }
	return exp;
	}
	catch(SQLException e){
		e.printStackTrace();
	}
	return exp;
	}


//retrieving summary by id
public Users getSummaryById(int userId)throws SQLException 
{
	ResultSet rs=null;
	System.out.println("Retrieve summary by getSummaryById");
	con = DatabaseConnection.getConnection();
	Users users= new Users();
	String summary ="";
try
{
	//"select * from education where user_id='"+ userId +"'";
	 summary = "select summary from users where user_id='"+userId+"';";
	System.out.println("Query for getSummaryByID:"+summary);
	 
	stat= con.createStatement();
	rs=stat.executeQuery(summary);
	while(rs.next())
	{
		users.setSummary(rs.getString("summary"));
		users.setUser_id(userId);
		return users;
	}
	
}
catch(SQLException e){
	e.printStackTrace();
}
return users;
}

//retrieving skills by id
public Skills getSkillsById(int userId)throws SQLException 
{
	ResultSet rs=null;
	System.out.println("Retrieve skills by Id");
	con = DatabaseConnection.getConnection();
	Skills skills = new Skills();
	String skillset ="";
try
{
	skillset = "select skillset from skills where user_id='"+userId+"'";
	System.out.println("Query for getSkillsByID:"+skillset);
	stat= con.createStatement();
	rs=stat.executeQuery(skillset);
	while(rs.next())
	{
		skills.setSkillset(rs.getString("skillset"));
		skills.setUser_id(userId);
		return skills;
	}
 
}
catch(SQLException e){
	e.printStackTrace();
}
return skills;
}

//Search member function
 public String[] getAllUsers(String text) throws SQLException{
	 ResultSet rs=null;
		System.out.println("Retrieve searched Users by text");
		con = DatabaseConnection.getConnection();
	 ArrayList<String> allUsers = new ArrayList<String>();
	 try{
	String users = "select username,user_id from users where username like '%"+text+"%' or email_id like '%"+text+"%'";
	System.out.println("Usrs:"+users);
	stat= con.createStatement();
	rs=stat.executeQuery(users);
	while(rs.next())
	{		
		allUsers.add(rs.getString(1));	
		System.out.println(rs.getString(1));
		//allUsers.add(rs.getString(2));	
		//System.out.println(rs.getString(2));
	}	
  
	for(int i =0; i< allUsers.size();i++){
 System.out.println("Username arrays:"+allUsers.get(i));
	}
 	return allUsers.toArray(new String[allUsers.size()]);
 	}
	catch(SQLException e){
		e.printStackTrace();
	}
	return  allUsers.toArray(new String[allUsers.size()]);
} 
 
 //Get user id by name.
 public int getUserIdByName(String username)
 {
	 ResultSet rs=null;
	 con = DatabaseConnection.getConnection();
	   
	 int userId = 0;
	 try{
	 	 
	 	String userIdDB = "Select user_id from users where username='" + username +"'";
	 	System.out.println("Query : "+userIdDB);
	 	stat = con.createStatement();
	 	rs = stat.executeQuery(userIdDB);
	 	while(rs.next())
	 	{
	 		  userId = rs.getInt("user_id");
	 		  System.out.println("UserID in getUserId:"+ userId); 
	 		return userId;
	 	}
	 	 
	 	rs.close();
	 }catch(SQLException e){
	 	e.printStackTrace();
	 }
	 	return userId;
 }
 
 
//Sending Invitations
 public String sendInvitations(int fromId,int toId){
	 ResultSet rs=null;
		int rowcount;
		//int toIdInt = 0;
		System.out.println("Inside sending invitations");
		con = DatabaseConnection.getConnection();
		String result = "";
		System.out.println("From user Id:"+fromId +"To user Id:"+toId);
				 			
		try{
		   
			String query = "Insert into connection (from_user_id,to_user_id) values ('"+fromId+"','"+toId+"')";
			stat = con.createStatement();
			rowcount = stat.executeUpdate(query);
			System.out.println(rowcount);
			if(rowcount > 0){
				result = "true";
				System.out.println("Sent invitation Successfully");
			}
			else{
				result="false: The data could not be inserted in the database.";
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	
		return result;
	}
 
 
 public int getConnectionID(int userId)
 {
	 ResultSet rs=null;
	 con = DatabaseConnection.getConnection();
	   int connectionID=0;	 
	 try{
	 	 
	 	String connId = "Select id from connection where from_user_id='" + userId +"' or to_user_id='"+userId+"'";
	 	System.out.println("Query : "+connId);
	 	stat = con.createStatement();
	 	rs = stat.executeQuery(connId);
	 	while(rs.next())
	 	{
	 		connectionID = rs.getInt("id");
	 		System.out.println("connection is in get connectionid:"+ connectionID); 
	 		return connectionID;
	 	}
	 	 
	 	rs.close();
	 }catch(SQLException e){
	 	e.printStackTrace();
	 }
	 	return connectionID;
 }
 
 
 
 //Display Invitations
 
 public String[]  displayInvitation(int userId){
	  
	 ResultSet rs=null;
		System.out.println("display invitations for a user");
		con = DatabaseConnection.getConnection();
	 ArrayList<String> invitations = new ArrayList<String>();
	 try{
	String getinvitations = "select u.user_id,u.username,c.id from users u, connection c where  c.from_user_id = u.user_id and c.status = 0 and c.to_user_id= '"+ userId +"'";
	System.out.println("Usrs:"+getinvitations);
	stat= con.createStatement();
	rs=stat.executeQuery(getinvitations);
	while(rs.next())
	{		
		/*invitations.add(rs.getString(1));	
		System.out.println(rs.getString(1));*/
	 	invitations.add(rs.getString(2));
		System.out.println(rs.getString(2));
	/*	invitations.add(rs.getString(3));
		System.out.println(rs.getString(3));*/
	}	

	for(int i =0; i< invitations.size();i++){
System.out.println("Username arrays:"+invitations.get(i));
	}
	return invitations.toArray(new String[invitations.size()]);
	}
	catch(SQLException e){
		e.printStackTrace();
	}
	return  invitations.toArray(new String[invitations.size()]);
 }
 
 public String acceptInvitations(int connectionId)
 {
	 int rowcount;
		System.out.println("Inside accepting invitations");
		con = DatabaseConnection.getConnection();
		String result ="";
		System.out.println("Connection:"+connectionId);
		try
		{
			String query = "update connection set status = 1 where id = '"+connectionId+"';";
			System.out.println("QUery to accept invitations:"+query);
			stat=con.createStatement();
			rowcount = stat.executeUpdate(query);
			System.out.println(rowcount);
			if(rowcount>0)
			{
				result = "true";
				System.out.println("Accepted Invitation successfully");
			}
			else{
				result="false: Couldn't accept the invitation.";
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return result;
 }
 
 
 public String rejectInvitations(int connectionId)
 {
	 int rowcount;
		System.out.println("Inside rejecting invitations");
		con = DatabaseConnection.getConnection();
		String result ="";
		System.out.println("Connection id in reject invi:"+connectionId);
		try
		{
			String query = "delete from connection where id = '"+connectionId+"';";
			System.out.println("Query to reject invitations:"+query);
			stat=con.createStatement();
			rowcount = stat.executeUpdate(query);
			System.out.println(rowcount);
			if(rowcount>0)
			{
				result = "true";
				System.out.println("Rejected Invitation successfully");
			}
			else{
				result="false: Couldn't reject the invitation.";
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return result;
 }
 
 public String[] displayConnections(int userId){
	  
	 ResultSet rs=null;
		System.out.println("displaying connections for user ");
		con = DatabaseConnection.getConnection();
	 ArrayList<String> connections = new ArrayList<String>();
	 try{
	String getconnections = "select u.user_id,u.username,c.id from users u, connection c where  c.from_user_id = u.user_id and c.status = 1 and c.to_user_id= '"+ userId +"'";
	System.out.println("Usrs in get connections:"+getconnections);
	stat= con.createStatement();
	rs=stat.executeQuery(getconnections);
	while(rs.next())
	{		
		connections.add(rs.getString(1));	
		System.out.println(rs.getString(1));
		connections.add(rs.getString(2));
		System.out.println(rs.getString(2));
		connections.add(rs.getString(3));
		System.out.println(rs.getString(3));
	}	

	for(int i =0; i< connections.size();i++){
System.out.println("Username arrays:"+connections.get(i));
	}
	return connections.toArray(new String[connections.size()]);
	}
	catch(SQLException e){
		e.printStackTrace();
	}
	return  connections.toArray(new String[connections.size()]);
 }
}