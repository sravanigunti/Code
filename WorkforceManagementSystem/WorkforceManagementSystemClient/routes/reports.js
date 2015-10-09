var ejs = require("ejs");
var mq_client = require('../rpc/client');

exports.clientcriteria = function(req,res){		
		
	var msg_payload={ "url": "clientcriteria", "userId": req.session.userId };

			
		console.log("In POST Request = userid:"+ req.session.userId);
	
		mq_client.make_request('report_queue', msg_payload, function(err, result){
			console.log("result at clientcriteria:" +JSON.stringify(result));
					//res.send({"Status" : "Success", "userId": result.userId, "firstName": result.firstName});
			res.send(result);
				
		});
};

exports.buildingcriteria = function(req,res){		
	var clientId = req.param("clientId");

	console.log(req.param("clientId"));
		console.log(clientId);
	var msg_payload={ "url": "buildingcriteria", "clientId": clientId};

	
		mq_client.make_request('report_queue', msg_payload, function(err, result){
			console.log("result at buildingcriteria:" +JSON.stringify(result));
					//res.send({"Status" : "Success", "userId": result.userId, "firstName": result.firstName});
			res.send(result);
				
		});
};

exports.searchReports = function(req,res){		
	var clientId = req.param("clientId");
	var buildingId = req.param("buildingId");
	var reportFromdate = req.param("reportFromdate");
	var reportTodate = req.param("reportTodate");
console.log(clientId);
console.log(buildingId);
console.log(reportFromdate);
console.log(reportTodate);
	var msg_payload={"url": "searchreports", "clientId": clientId, "buildingId": buildingId, 
			"reportFromdate" : reportFromdate, "reportTodate" : reportTodate};

	
		mq_client.make_request('report_queue', msg_payload, function(err, result){
			console.log("result at searchReports:" +JSON.stringify(result));
					//res.send({"Status" : "Success", "userId": result.userId, "firstName": result.firstName});
			res.send(result);
				
		});
};
