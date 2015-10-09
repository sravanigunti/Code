package Connection;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
//import java.beans.Statement;
import java.sql.*;
//import com.sun.corba.se.pept.transport.Connection;
import java.util.Locale;

public class DatabaseConnection {
	
	static Connection con = null;
	//static ResultSet rs;
	
	
	public static Connection getConnection(){
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/linkedinservices","root","SjSu@2015");
			
		}catch(SQLException e){
			e.printStackTrace();
		}catch(InstantiationException e){
			e.printStackTrace();
		}catch(IllegalAccessException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		return con;
	}
 

}
