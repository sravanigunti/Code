
var mysql = require("./mysql");

exports.getLastlogin = getLastlogin;

function getLastlogin(msg,callback){
		console.log("Entered in Server lastlogin module");
		var res = {};
	 
		var updateQuery="UPDATE LinkedIn.User_Details SET Last_Login='"+getdatetime()+"' WHERE User_ID='"+msg.User_ID+"'";
		mysql.fetchData(function(err,results){
			if(err){
				throw err;
			}else 
			{			
				 	
						res.code = "200";
						 
						callback(null,res);
				 
		}  
	},updateQuery);
}

function getdatetime(){
	var currentdate = new Date(); 
	var datetime = currentdate.getFullYear() + "-"
	                + (currentdate.getMonth()+1)  + "-" 
	                + currentdate.getDate() + " "  
	                + currentdate.getHours() + ":"  
	                + currentdate.getMinutes() + ":" 
	                + currentdate.getSeconds();
	return datetime;
}