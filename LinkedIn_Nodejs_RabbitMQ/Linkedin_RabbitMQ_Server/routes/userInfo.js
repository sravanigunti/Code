var user;
var mysql = require("./mysql");

exports.userInfo = userInfo;
function userInfo (msg, callback) {
	var res={};
 
	console.log("Entered in server userInfo module");
	var getUser = "SELECT * FROM LinkedIn.User_Details where User_ID='"+msg.userid+"'";
	 
		
	mysql.fetchData(function(err,results){
		if(err) {
			console.log(err);
			console.log(results);
			console.log(err.code);			
		} else {
				
			if (results.length > 0){					
				console.log(results);
				res.userRecord = results[0];		
				res.code = "200";					
				callback(null,res);		
			}
		}
	}, getUser);
	
}


