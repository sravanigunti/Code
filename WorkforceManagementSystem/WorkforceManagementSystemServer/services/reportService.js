var mysql = require('./mysql');

function handle_request(msg, callback) {
	
	var res,query;
	
	if(msg.url === "clientcriteria") {
		console.log(msg.userId);
		var userid = msg.userId;
		
		query = "select firstName, lastName, userId from userdetails where userId in(select clientId from client)";
		mysql.fetchData(function(err,results){
			if(err){
				console.log("err");
				callback(err,null);
			}
			else 
			{
				console.log(JSON.stringify(results));
				if(results.length > 0) {
					console.log("Valid client criteria");
					callback(null, results);
				}
				else {
					console.log("InValid client criteria");
					result = {"status":"fail"};
					callback(null, result);
				}
			}  
		},query);
	}
	
	if(msg.url === "buildingcriteria") {
		console.log(msg.clientId);
		var clientId = msg.clientId;
		
		query = "select buildingName, buildingId, clientId from building where clientId="+clientId;
		mysql.fetchData(function(err,results){
			if(err){
				console.log("err");
				callback(err,null);
			}
			else 
			{
				console.log(JSON.stringify(results));
				if(results.length > 0) {
					console.log("Valid building criteria");
					callback(null, results);
				}
				else {
					console.log("InValid building criteria");
					result = {"status":"fail"};
					callback(null, result);
				}
			}  
		},query);
	}
	
	if(msg.url === "searchreports") {

		var clientId = msg.clientId;
		var buildingId = msg.buildingId;
		var reportFromdate = msg.reportFromdate;
		var reportTodate = msg.reportTodate;
		
		
		console.log(clientId);
		console.log(buildingId);
		console.log(reportFromdate);
		console.log(reportTodate);
		
		query = "select * from reports r JOIN building b on r.buildingId=b.buildingId where " +
				"r.buildingId="+buildingId+" or b.clientId="+clientId+" or r.creationTime between '"+reportFromdate+"' and '"+reportTodate+"'";
		//query = "select * from reports where buildingId="+buildingId+" or buildingId in(select buildingId from Building where clientId="+clientId+")";
		mysql.fetchData(function(err,results){
			if(err){
				console.log("err");
				callback(err,null);
			}
			else 
			{
				console.log(JSON.stringify(results));
				if(results.length > 0) {
					console.log("Valid search reports");
					callback(null, results);
				}
				else {
					console.log("InValid search reports");
					result = {"status":"fail"};
					callback(null, result);
				}
			}  
		},query);
	}
}

exports.handle_request = handle_request;

