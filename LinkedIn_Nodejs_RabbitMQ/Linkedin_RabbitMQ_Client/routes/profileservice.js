var ejs = require("ejs");
var mq_client = require('../rpc/client');

exports.getProfile=getProfile;
exports.getEducation=getEducation;
exports.getExperience=getExperience;
exports.getSkill=getSkill;
exports.addEducation=addEducation;
exports.addExperience=addExperience;
exports.addSkill=addSkill;
exports.updateUser=updateUser;
exports.updateUserEdu=updateUserEdu;
exports.updateUserExp=updateUserExp;


function updateUserExp(req,res){
	var name = req.param("name");
	var field = req.param("field");
	var expID = req.param("expID");
	
	var msg_payload = {"type":"updateExp","User_ID":req.session.userid,
			"name":name,"field":field,"expID":expID		
	}
	mq_client.make_request('profile_queue',msg_payload, function(err,results){
		console.log(results);
		if(err){
			throw err;
		}
		else 
		{
			if(results.code == 200){
				console.log("Experience updated");
				res.send({"status":"Success"});
			}
			else {    
				console.log("Experience not updated");
				res.send({"status":"Fail"});
			}
		}  
	});	
}


function updateUserEdu(req,res){
	var name = req.param("name");
	var field = req.param("field");
	var eduid = req.param("eduID");
	var msg_payload = {"type":"updateEdu","User_ID":req.session.userid,
			"name":name,"field":field,"eduID":eduid		
	}
	mq_client.make_request('profile_queue',msg_payload, function(err,results){
		console.log(results);
		if(err){
			throw err;
		}
		else 
		{
			if(results.code == 200){
				console.log("Education updated");
				res.send({"status":"Success"});
			}
			else {    
				console.log("Education not updated");
				res.send({"status":"Fail"});
			}
		}  
	});	
}

function updateUser(req,res)
{
	var name = req.param("name");
	var field = req.param("field");
	
	var msg_payload = {"type":"updatefield","User_ID":req.session.userid,
			"name":name,"field":field		
	}
	mq_client.make_request('profile_queue',msg_payload, function(err,results){
		console.log(results);
		if(err){
			throw err;
		}
		else 
		{
			if(results.code == 200){
				console.log("field updated");
				res.send({"status":"Success"});
			}
			else {    
				console.log("field not updated");
				res.send({"status":"Fail"});
			}
		}  
	});	
}


function addSkill(req,res)
{
	var uid = req.param("User_ID");
	var skill = req.param("Skill");
	var msg_payload = {"type":"AddSkill","User_ID":uid,
				"Skill":skill
	}
	
	console.log("Add Skill : " + msg_payload.User_ID);
	mq_client.make_request('profile_queue',msg_payload, function(err,results){
		console.log(results);
		if(err){
			throw err;
		}
		else 
		{
			if(results.code == 200){
				console.log("Skill Added");
				res.send({"status":"Success"});
			}
			else {    
				console.log("Skill not added");
				res.send({"status":"Fail"});
			}
		}  
	});	
}

function addExperience(req,res)
{
	var uid = req.param("User_ID");
	var company = req.param("Company");
	var jt = req.param("JobTitle");
	var jd = req.param("JobDesc");
	var sd = req.param("StartDate").slice(0,10);
	var ed = req.param("EndDate").slice(0,10);
	
	var msg_payload = { "type":"AddExp","User_ID":uid,
			"Company":company,"JobTitle":jt,"JobDesc":jd,
			"StartDate":sd,"EndDate":ed
	}
	
	console.log("Add Experience Request:" + msg_payload.User_ID);
	mq_client.make_request('profile_queue',msg_payload, function(err,results){
		console.log(results);
		if(err){
			throw err;
		}
		else 
		{
			if(results.code == 200){
				console.log("Experience Added");
				res.send({"status":"Success"});
			}
			else {    
				console.log("Experience not added");
				res.send({"status":"Fail"});
			}
		}  
	});	
}

function addEducation(req,res)
{
	var uid = req.param("User_ID");
	var degree = req.param("Degree");
	var uni_name = req.param("University_Name");
	var courses = req.param("Courses");
	var yoj = req.param("YOJ").slice(0,10);
	var yoe = req.param("YOE").slice(0,10);
	
	var msg_payload = { "type":"AddEdu","User_ID":uid,
			"Degree":degree,"University_Name":uni_name,
			"Courses":courses,"YOJ":yoj,"YOE":yoe};
	
	console.log("Add Education Request:" + msg_payload.YOJ);
	
	mq_client.make_request('profile_queue',msg_payload, function(err,results){
		
		console.log(results);
		if(err){
			throw err;
		}
		else 
		{
			if(results.code == 200){
				console.log("Education Added");
				res.send({"status":"Success"});
			}
			else {    
				console.log("Education not added");
				res.send({"status":"Fail"});
			}
		}  
	});	
}

function getSkill(req,res)
{
	var msg_payload = { "type":"Skills","userId":req.session.userid};
	console.log("Skill Request:" + req.params.userId);
	
	mq_client.make_request('profile_queue',msg_payload, function(err,results){
		
		console.log(results);
		if(err){
			throw err;
		}
		else 
		{
			if(results.code == 200){
				console.log("Skill fetched");
				res.send({"status":"Success","skillDetail":results.skillDetails});
			}
			else {    
				
				console.log("Skill not fetched");
				res.send({"status":"Fail"});
			}
		}  
	});	
}
function getExperience(req,res)
{
var msg_payload = { "type":"Experience","userId":req.session.userid};
	
	console.log("Experience Request:" + req.params.userId);
	
	mq_client.make_request('profile_queue',msg_payload, function(err,results){
		
		console.log(results);
		if(err){
			throw err;
		}
		else 
		{
			if(results.code == 200){
				console.log("Experience fetched");
				res.send({"status":"Success","experienceDetail":results.experienceDetails});
			}
			else {    
				
				console.log("Experience not fetched");
				res.send({"status":"Fail"});
			}
		}  
	});	
}

function getEducation(req,res)
{
	var msg_payload = { "type":"Education","userId":req.session.userid};
	
	console.log("Education Request:" + req.params.userId);
	
	mq_client.make_request('profile_queue',msg_payload, function(err,results){
		
		console.log(results);
		if(err){
			throw err;
		}
		else 
		{
			if(results.code == 200){
				console.log("Education fetched");
				res.send({"status":"Success","educationDetail":results.educationDetails});
			}
			else {    
				
				console.log("Education not fetched");
				res.send({"status":"Fail"});
			}
		}  
	});	
}

function getProfile(req,res)
{
	var msg_payload = { "type":"Profile","userid":req.session.userid};
	
	console.log("GET profile Request" + req.session.userid);
	
	mq_client.make_request('profile_queue',msg_payload, function(err,results){
		
		console.log(results);
		if(err){
			throw err;
		}
		else 
		{
			if(results.code == 200){
				console.log("Profile fetched");
				
				res.send({"status":"Success","user":results.userRecord});
			}
			else {    
				
				console.log("Profile has some issue");
				res.send({"status":"Fail"});
			}
		}  
	});	
}


