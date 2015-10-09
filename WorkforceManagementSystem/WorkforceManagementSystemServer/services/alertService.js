var mysql = require('./mysql');

function handle_request(msg, callback) {
	
	var res,query;
	
	if(msg.url === "alertcriteria") {
		 
		query = "select alertTypeId,alertName from alertType"
		mysql.fetchData(function(err,results){
			if(err){
				console.log("err");
				callback(err,null);
			}
			else 
			{
				console.log(JSON.stringify(results));
				if(results.length > 0) {
					console.log("Valid alert criteria");
					callback(null, results);
				}
				else {
					console.log("InValid alert criteria");
					result = {"status":"fail"};
					callback(null, result);
				}
			}  
		},query);
	}
	
	if(msg.url === "searchalerts") {
		
		 var alertFromdate = msg.alertFromdate;
		var alertTodate = msg.alertTodate;
		
		if(msg.clientId === undefined)
			{var clientId = null;}
		else{ var clientId = msg.clientId;}
		
		if(msg.buildingId === undefined)
		{var buildingId = null;}
	else{ var buildingId = msg.buildingId;}
		
		if(msg.alertTypeId === undefined)
		{var alertTypeId = null;}
	else{ var alertTypeId = msg.alertTypeId;}
		
		if(msg.severity === undefined)
		{var severity = null;}
	else{ var severity = msg.severity;}

		 
		
		console.log("buildingId:"+buildingId);
		console.log("clientId:"+clientId);
		console.log("alertTypeId:"+alertTypeId);
		console.log("severity:"+severity);
		console.log("alertFromdate:"+alertFromdate);
		console.log("alertTodate:"+alertTodate);
		
		query = "select ud.firstName, ud.lastName, b.buildingName, a.description, at.alertName, a.severity, a.alertTime from userdetails ud, client c, building b, alerts a, alerttype at " +
				"where ud.userId=c.clientId and b.buildingId=a.buildingId and a.alertTypeId=at.alertTypeId";
		 
		var userData = [clientId,buildingId,alertTypeId,severity];
		
		for(var i=0;i<userData.length;i++){
			 if(userData[i]!==null){
			  switch(i){
			  case 0: query+=" and c.clientId="+userData[0];	break;
			  case 1: query+=" and b.buildingId ="+userData[1];	break;
			  case 2: query+=" and at.alertTypeId ="+userData[2];	break;
			  case 3: query+=" and a.severity like '%"+userData[3]+"%'";	break;

			  }
			 }
		  }
		
		if(alertFromdate !== undefined && alertFromdate!==null && alertTodate !== undefined && alertTodate!==null)
			{
			query+=" and a.alertTime between '"+alertFromdate+"' and '"+alertTodate+"'";
			}
		console.log(query);
		mysql.fetchData(function(err,results){
			if(err){
				console.log("err");
				callback(err,null);
			}
			else 
			{
				console.log(JSON.stringify(results));
				if(results.length > 0) {
					console.log("Valid alert criteria");
					callback(null, results);
				}
				else {
					console.log("InValid alert criteria");
					result = {"status":"fail"};
					callback(null, result);
				}
			}  
		},query);
	}
}

exports.handle_request = handle_request;