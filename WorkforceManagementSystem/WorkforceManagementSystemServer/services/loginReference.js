var mysql = require('../mysql');

function handle_request(msg, callback) {
	
	var res,query,email,pwd;
	
	if(msg.url === "signIn") {
		email = msg.email;
		pwd = msg.pwd;
		query = "select * from users where emailId='" +email +"' and password = '" +pwd +"'";
		mysql.fetchData(function(err,results){
			if(err){
				throw err;
			}
			else 
			{
				if(results.length > 0) {
					console.log("Valid Login");
					res = {"code":200,"userEmail":results[0].emailId,"userId":results[0].userId};
					callback(null, res);
				}
				else {
					console.log("Invalid Login");
					res = {"code":401};
					callback(null, res);
				}
			}  
		},query);
	}
	
	else if(msg.url==="signUp") {
		email = msg.email;
		pwd = msg.pwd;
		var fName = msg.fName;
		var lName = msg.lName;
		query="select * from users where emailId='"+email+"'";
		mysql.fetchData(function(err,results){
			if(err){ throw err; }
			else {
				if(results.length === 0) {
					query = "insert into users (emailId, password, firstName, lastName) values ('" +email +"','" +pwd +"','" +fName +"','" +lName +"')";
					mysql.fetchData(function(err,results){
						if(err){ throw err; }
						else {
							res = {"code":200};
							callback(null, res);
						}
					},query);
				}
				else {
					res = {"code":401};
					callback(null, res);
				}
			}
		},query);
	}
	
	else if(msg.url==="signOut") {
		var userId = msg.userId;
		var lastLogin = msg.lastLogin;
		query = "update users set lastLogin = '" +lastLogin +"' where userId = '" +userId +"'";
		mysql.fetchData(function(err,results){
			if(err) { throw err; }
			else {
				res = {"code":200};
				callback(null, res);
			}  
		},query);
	}
	
	else {
		console.log("Invalid URL");
		res = {"code":401};
		callback(null, res);
	}	
	
	//callback(null, res);
}

exports.handle_request = handle_request;