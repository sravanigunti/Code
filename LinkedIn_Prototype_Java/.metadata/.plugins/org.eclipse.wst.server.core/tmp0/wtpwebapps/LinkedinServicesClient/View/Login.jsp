<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css"> 
<style>
p{
    color:black;
    font-family:Arial;
    font-size:50;
    margin-left: 120px;
}
</style>
 
<title>LinkedIn</title>  
</head>
<body>
<center>
<nav style="padding-bottom: 10px;box-shadow: 3px 3px 5px #888888; background-color: #F5F5F5;">

 
<form id="form2" method="post" action="signin">
<fieldset style="width: 800px">  
                <table>  
                <tr>  
               <td> <img src="../resources/images/linkedin2.jpg" alt="LinkedIn" style="margin-left:-20px; margin-top: 5px;width:90px;height:40px"></td>
                    <td>Email Address</td> 
                    <td><input type="text" name="username" required="required" style="margin-left: 10px;"/></td>  
                  
                    <td> Password</td>
                    <td><input type="password" name="password" required="required" style="margin-left: 10px;"/></td>  
                         
                    <td><input type="submit" value="Sign In" style="margin-left: 100px;"/></td> 
                     <td><input type ="hidden" name="userid" value="<%=request.getParameter("userid")%>"/></td>  
                </tr>  
            </table>  
        </fieldset>  
	<!-- <div class="form-row"><span class="label">Username </span><input type="text" name="username"/></div>
	<div class="form-row"><span class="label">Password </span><input type="password" name="password"/></div>
	<div class="form-row"><input class="submit" type="submit" value="submit"/></div> -->
</form>
</nav>
 
<h1 style="margin-left: 100px; font-size: 35px; margin-bottom:100px;">Connect, share ideas, and discover opportunities.</h1> 
   <div>
   <form id="form1" method="post" action="signup">
				<table>
				<tr>
					<th rowspan = "7">
						<img src="../resources/images/img1.png" width="150" height="150" alt="Male Headshot">
						<img src="../resources/images/img2.png" width="150" height="150" alt="Female Headshot">
						<img src="../resources/images/img3.png" width="150" height="150" alt="Male Headshot"><br> <br>
						<img src="../resources/images/img4.png" width="150" height="150" alt="Male Headshot">
						<img src="../resources/images/img5.png" width="150" height="150" alt="Male Headshot">
						<img src="../resources/images/img6.png" width="150" height="150" alt="Male Headshot">
					</th>
					<tr>
					<h2 style="margin-top:1px;margin-left:400px;width: 400px;">Get Started - it's free.</h2>
					</tr>
					<tr>
					<h4 style="margin-top:1px;margin-left:400px;width: 400px;">Registration takes less than 2 minutes.</h4>
					</tr>
					<td>
					<div class="col-sm-2">				 
				        <input   type="text" placeholder="First Name" name="first" required ="required" style="margin-top: 15px;margin-left: -400px;width: 200px;" >
				   		</div>
				   		
				   		<div class="col-sm-2">				 
				        <input   type="text" placeholder="Last Name" name="last" required ="required" style="margin-top: 15px;margin-left: -200px;width: 200px;" >
				   		</div> 
				   	</td>	
				   	</tr>
				<tr>
					<td>
				   		<div class="col-sm-4">				 
				        <input   type="text" placeholder="Email Address" name="email" required ="required" style="margin-top:1px;margin-left:-400px;width: 400px;" >
				   		</div> 
			   		</td>
			   	</tr>
			   	<tr>
			   		<td>
				   		<div class="col-sm-4">				 
				        <input   type="text" placeholder="Password (6 or more characters)" name="pass" required ="required" style="margin-top:1px;margin-left:-400px;width: 400px;" >
				   		</div>
			   		</td>
			   	</tr>
			   	<tr>
				   	<td>
				   		<p style="margin-top:1px;margin-left:-400px;width: 400px;"> By clicking Join Now, you agree to LinkedIn's User Agreement,</br> Privacy Policy and Cookie Policy.</p>
				   	</td>
			   	</tr>
				<tr>	
					<td>
					<input class="submit" type="submit" value="Join Now" style="margin-top:0px;margin-left:600px;width: 400px;height: 35px;font-weight: bold;background-color: #FFD700;border: 0 none; "/>
						<!-- <button type="submit" value="Join Now" style="margin-top:1px;margin-left: 120px;width: 400px;height: 35px;font-weight: bold;background-color: #FFD700;border: 0 none; ">Join Now </button>-->
					</td>
				</tr>
				
				
			</table>
	</form>	 
		 	</div>
    
 </center>
<!-- <div>SignUp for New Account</div>
<form id="form1" method="post" action="signup">
	<div class="form-row"><span class="label">First Name </span><input type="text" name="first"/></div>
	<div class="form-row"><span class="label">Last Name </span><input type="text" name="last"/></div>	
	<div class="form-row"><span class="label">Email </span><input type="email" name="email"/></div>
	<div class="form-row"><span class="label">Password </span><input type="password" name="pass"/></div>
	<div class="form-row"><input class="submit" type="submit" value="submit"/></div>
</form>
 -->



</body>
</html>