var ejs = require("ejs");
var mq_client = require('../rpc/client');

exports.login = function(req,res){		
	var email = req.param("email");
	var password = req.param("password");		
	var msg_payload={ "url": "login", "email": email, "password": password };

	if((password !== undefined && email !== undefined) && (password !== "" && email !== ""))
	{		
		console.log("In POST Request = Email:"+ email+" "+password);
	
		mq_client.make_request('login_queue', msg_payload, function(err, result){						
			if(result.error !== undefined && result.error !== ""){
				console.log("error:"+result.error);
				res.send({"Status":result.error});
			}
			else
			{								
				if(result.userId !== undefined && result.userId !== "")
				{					
					req.session.userId = result.userId;	    	  	
					req.session.roleId = result.roleId;
					res.send({"Status" : "Success", "userId": result.userId, "roleId": result.roleId});   											
				}
				else
				{										
					res.send({"Status" : "Error"});
				}
			}
		});
	}		
	else
	{		
		res.send({"Status" : "Error"});
	}	
};
