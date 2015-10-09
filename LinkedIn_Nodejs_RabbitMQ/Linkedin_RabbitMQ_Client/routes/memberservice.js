var ejs = require("ejs");
var mq_client = require('../rpc/client');

exports.showConnections = showConnections;
exports.pendingConnections = pendingConnections;
exports.searchMember=searchMember;
exports.acceptInvitation=acceptInvitation;
exports.sendInvitation=sendInvitation;

function sendInvitation(req,res)
{
	var invitedUserid = req.param("invitedUserid");
	var msg_payload = {"type":"sendinvitation","User_ID":req.session.userid,
			"invitedUserid":invitedUserid}
	
	mq_client.make_request('member_queue',msg_payload, function(err,results){
		console.log(results);
		if(err){
			throw err;
		}
		else 
		{
			if(results.code == 200){
				console.log("Request sent successfully ");
				res.send({"status":"Success"});
			}
			else {    
				console.log("Error in sending request");
				res.send({"status":"Fail"});
			}
		}  
	});	
}

function pendingConnections(req,res)
{
	var msg_payload = {"type":"pendingconnection","User_ID":req.session.userid}
	
	mq_client.make_request('member_queue',msg_payload, function(err,results){
		console.log(results);
		if(err){
			throw err;
		}
		else 
		{
			if(results.code == 200){
				console.log("Pending connection Members");
				res.send({"status":"Success","pendingConnectionList":results.pendingConnectionList});
			}
			else {    
				console.log("Pending connection Members not found");
				res.send({"status":"Fail"});
			}
		}  
	});	
}
function acceptInvitation(req,res)
{
	var accepteduserID = req.param("acceptedInvitationId");
	var msg_payload = {"type":"acceptinvitation","User_ID":req.session.userid,"acceptedInvitationId":accepteduserID}
	
	mq_client.make_request('member_queue',msg_payload, function(err,results){
		console.log(results);
		if(err){
			throw err;
		}
		else 
		{
			if(results.code == 200){
				console.log("Request accepted ");
				res.send({"status":"Success"});
			}
			else {    
				console.log("Error in accepting request");
				res.send({"status":"Fail"});
			}
		}  
	});	
}

function searchMember(req,res)
{	
	var searchString = req.param("searchString");
	var msg_payload = {"type":"finduser","User_ID":req.session.userid,"searchString":searchString}
	
	mq_client.make_request('member_queue',msg_payload, function(err,results){
		console.log(results);
		if(err){
			throw err;
		}
		else 
		{
			if(results.code == 200){
				console.log("Search Members");
				res.send({"status":"Success","search":results.searchPeopleList});
			}
			else {    
				console.log("Search Members not found");
				res.send({"status":"Fail"});
			}
		}  
	});	
}



function showConnections(req,res)
{
	var msg_payload = {"type":"showconnection","User_ID":req.session.userid}
	
	mq_client.make_request('member_queue',msg_payload, function(err,results){
		console.log(results);
		if(err){
			throw err;
		}
		else 
		{
			if(results.code == 200){
				console.log("Members searched");
				res.send({"status":"Success","connectedPeopleList":results.connectedPeopleList});
			}
			else {    
				console.log("Members not searched");
				res.send({"status":"Fail"});
			}
		}  
	});	
}