<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<title>Display profile</title>
</head>
<body style="background-color: #EBEFF2">
<nav class="navbar navbar-inverse navbar-fixed-top">  
 <div class="container-fluid">
    <div class="navbar-header">
      <img src="../resources/images/download.gif" style="margin-left: 150px;margin-top: 7px;">
    </div>
 
 <table>   
 <tr>
   
	  <td>   
	   <form id="form3" method="post" action="displayProfile">
		 <div class="form-row"><input class="submit" type="submit" value="ViewProfile"/></div>
	 	</form>
	  </td>
   
	  <td>  
	      <form id="form3" method="post" action="searchUser">
		  <div class="form-row"> <input type="text" name="text"/> 	 
	 <input class="submit" type="submit" value="Search"/></div>
	 	 </form>
	  </td>
  
	  <td>
	 	  <form id="form3" method="post" action="showInvitations">
		   	  <div class="form-row"><input class="submit" type="submit" value="Invitations"/></div>
	 	 </form>
	  </td>
	  
	  <td>
	     <form id="form3" method="post" action="showConnections">
		   	   <input class="submit" type="submit" value="Connections"/> 
	 	 </form>
	  </td>
	    
	  <td>
	  <ul class="nav navbar-nav navbar-right">
        <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Out</a></li>
        
      </ul>
	  </td>
    
 </tr>
 
  </table>
  </div>
 </nav>  
  <br>
 <br> <br>
 <br>
   <!-- --------Top card--------- -->
    <div id="top-card" class="profile-details">    
		<div class="container">
		<div class="col-md-3">    	
			<div id="profile" class="profile-card profile-picture">
				<img src="../resources/images/srav.JPG" height="150" width="150">
			</div>
		</div>			
		<div  >
			 <h3>Sravani Gunti</h3>
		</div>
		</div>			
	</div>
  		  	
  	<br> 
   
    <form>
   		<div class="container">			
	  	    <div class="well" style="margin-left: 20px;">
				<div><h3>Summary</h3></div>  	
					<div align = center>
			                <p>${userSummary.summary}</p>
			        </div>	
				</div>		 
			</div>
	 	</div>	
			 
	   	<br>      
	   	
	   	 <div class="container">
	   	 <div class="well" style="margin-left: 20px;">
    	<div ><h3>Experience</h3></div>  
		<br>
		<!-- Text input-->
		<div align = center> 
		<label  class="control-label col-sm-2"  for="textinput">Company Name:</label>
		 <p>${experience.company_name}</p>
		</div>  
         <br><br>
		<div align = center> 
		<label class="control-label col-sm-2" for="textinput">Title:</label>
		<p>${experience.title}</p>
		</div>
		<br><br>
		<div align = center> 
		<label class="control-label col-sm-2"  for="textinput">Location:</label>
		  <p>${experience.location}</p>
		</div>
		<br><br>
		<div align = center> 
		<label  class="control-label col-sm-2"  for="textinput">Description:</label>		   
        <p>${experience.description}</p>  
		</div>
		<br><br>	  
        	<div align = center>			<label></label>			</div>			<div align = center>			<label></label>			</div>			<div align = center>			<label></label>			</div>			<div align = center>			<label></label>			</div>			<div align = center>			<label></label>			</div>			<div align = center>			<label></label>			</div>			<div align = center>			<label></label>			</div>			<div align = center>			<label></label>			</div>				<div align = center>			<label></label>			</div>			<div align = center>			<label></label>			</div>			<div align = center>			<label></label>			</div>			<div align = center>			<label></label>			</div>		</div>		</div>				<br><br>        
          <div class="container">
	   	 <div class="well" style="margin-left: 20px;">
		<div ><h3>Education</h3></div>  		
		<br>
		<div align = center> 
		<label class="control-label col-sm-2"  for="textinput">Level:</label>
		  <p> ${education.level}</p>   
		</div>
			<br><br>
		<div align = center> 
		<label class="control-label col-sm-2" for="textinput">University Name:</label>
		     <p>${education.univ_name}</p>
		</div>
			<br><br>
		<div align = center> 
		<label class="control-label col-sm-2" for="textinput">Field:</label>
		   <p>${education.field}</p>
		</div>
		<br><br>
		<div align = center> 
		<label class="control-label col-sm-2" for="textinput">Grade:</label>
		 <p>${education.grade}</p>
		</div>
			<br><br>
		<div align = center> 
		<label class="control-label col-sm-2" for="textinput">Description:</label><br>
		<p>${education.description}</p>
		</div>
			<br><br>	      
         <div align = center>			<label></label>			</div>			<div align = center>			<label></label>			</div>			<div align = center>			<label></label>			</div>			<div align = center>			<label></label>			</div>			<div align = center>			<label></label>			</div>			<div align = center>			<label></label>			</div>			<div align = center>			<label></label>			</div>			<div align = center>			<label></label>			</div>			<div align = center>			<label></label>			</div>			<div align = center>			<label></label>			</div>			<div align = center>			<label></label>			</div>		</div>		</div>		<br>
		<div class="container">
	   	 <div class="well" style="margin-left: 20px;">
			<!-- <div ><h3>Skills</h3></div>	<br> -->
			<label class="control-label col-sm-2" for="textinput"> Skills:</label> 
			                <p>${skills.skillset}</p>
			<div align = center>			<label></label>			</div>
		</div>
			 	
		</div>
		<br>   			 
               
       </form>            
</body>
</html>