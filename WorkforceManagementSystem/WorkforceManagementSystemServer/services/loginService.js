var mysql = require('./mysql');

function handle_request(msg, callback){
	
	var res = {};
	/*************************************************************Login Validation******************************************************************************/	
	if(msg.url==="login"){

		var email = msg.email, password = msg.password;
		/************** Create Connection******************************************/
		var connection = mysql.getConnection();
		/*************************************************************************/
		var query = connection.query("select * from user where email=? and password=?", [email,password], function(err, rows){	 			
			if(err){
				console.log(err);
				res.error=err;	
			}
			else if(rows.length>0){	 				
						res.userId = rows[0].userId;
						res.roleId = rows[0].roleId;
						/************** End Connection******************************************/	
						connection.end();		
						/*********************************************************************/
						callback(null, res);																					
				}				
			else{
				res.error="Invalid User";
				callback(null, res);	
			}
		});
	}
	/***********************************************************************************************************************************************************/
}
	
exports.handle_request = handle_request;