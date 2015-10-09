
var ejs = require("ejs");
var mq_client = require('../rpc/client');

exports.after_sign_in=after_sign_in;
exports.signup=signup;
exports.signout=signout;
exports.getLastLogin=getLastLogin;


function after_sign_in(req,res)
{
	// check user already exists
	//var getUser="select * from users where emailid='"+req.param("username")+"'";
	var username = req.param("username");
	var password = req.param("password");
	var msg_payload = { "type":"signin","username": username, "password": password };
		
	console.log("In POST Request = UserName:"+ username+" "+password);
	
	mq_client.make_request('login_queue',msg_payload, function(err,results){
		
		console.log(results);
		if(err){
			throw err;
		}
		else 
		{
			if(results.code == 200){
				console.log("valid Login");
				req.session.userid = results.User_ID;
				console.log(req.session.userid);
				res.send({"login":"Success","User_ID":results.User_ID,"lastlog":results.lastlog});
			}
			else {    
				
				console.log("Invalid Login");
				res.send({"login":"Fail"});
			}
		}  
	});	
}

function signup(req,res)
{
	var name = req.param("name");
	var newUserEmail = req.param("newUserEmail");
	var newUserPassword = req.param("newUserPassword");
	
	var msg_payload = {"type":"signup","name":name , "newUserEmail":newUserEmail,"newUserPassword":newUserPassword};
	
	console.log("POST Request for signup :"+name +" "+newUserEmail+" "+newUserPassword);
	
	mq_client.make_request('login_queue',msg_payload,function(err,results){
		console.log(results);
		
		if(err){
			throw err;
		}else{
			if(results.code == 200){
				console.log("User account created.");
				res.send({"status":"Success"});
			}
			else{
				console.log("User account not created");
				res.send({"status":"Fail"});
			}
		}
	});
}


function getLastLogin(req,res)
{
	var msg_payload = { "type":"lastlogin","User_ID": req.session.userid };
	
	console.log("Last login for " + req.session.userid);
	mq_client.make_request('login_queue',msg_payload, function(err,results){
		console.log(results);
		if(err){
			throw err;
		}
		else 
		{
			if(results.code == 200){
				console.log(results.lastlog);
				res.send({"status":"Success"});
			}
			else {    
				res.send({"status":"Fail"});
			}
		}  
	});	
}

function signout(req,res){
	
	if(req.session.userid)
	{	
	var msg_payload = { "type":"signout","useremail":req.session.userid};
	
	console.log("Signout Request:" + req.session.userid);
	
	mq_client.make_request('login_queue',msg_payload, function(err,results){
		
		console.log(results);
		if(err){
			throw err;
		}
		else 
		{
			if(results.code == 200){
				console.log("User logged out");
				//req.session.userid=null;
				req.session.destroy();
				
				res.send({"status":"Success"});
				
			}
			else {    
				
				console.log("logged out error");
				res.send({"status":"Fail"});
			}
		}  
	});	
	}
	else
	{
		res.end('401');
	}
}