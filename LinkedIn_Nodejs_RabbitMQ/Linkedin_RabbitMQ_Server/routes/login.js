//var clientUrl = "http://10.0.0.152:5564";
var mysql = require("./mysql");
var passwordHash = require("password-hash");


exports.handle_request = handle_request;

function handle_request(msg,callback){
			console.log("Entered in Server login module");
			var res = {};
			var getUser="select Password,User_ID,Last_Login from LinkedIn.User_Details where Email_ID='"+msg.username+"'";	
			
			mysql.fetchData(function(err,results){
				if(err){
					throw err;
				}else 
				{
					if((results.length > 0) && (passwordHash.verify(msg.password,results[0].Password))){
				
					
				 	
							res.code = "200";
							res.value = "Succes Login";
							res.lastlog = results[0].Last_Login;
							res.User_ID = results[0].User_ID;
							callback(null,res);
				 
					}
					else {    
							res.code = "0";
							console.log("Invalid Login");
							callback(null,res);
							
			}
		}  
	},getUser);
}







