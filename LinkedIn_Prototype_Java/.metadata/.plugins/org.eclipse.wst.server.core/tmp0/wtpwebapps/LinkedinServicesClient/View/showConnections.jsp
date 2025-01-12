<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<title>Show Connections</title>
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
 
<c:forEach var="data" items="${displayConnections}" >
       <div id="top-card" class="profile-details">    
		<div class="container">
		<div class="col-md-3">    	
			<div id="profile" class="profile-card profile-picture">
				<img src="../resources/images/empty.jpg" height="150" width="150"> 
			</div>
		</div>			
		 <div>
		 <h3><c:out value="${data}">  </c:out>   </h3>
		 </div>
		 </div>	
 		</div> 
</c:forEach>   
</body>
</html>