/**
 * New node file
 */

var ejs = require("ejs");

exports.loadloginpage = loadloginpage;
exports.successLogin = successLogin;
exports.failLogin = failLogin;
exports.connections=connections;
exports.connectionSearchResult = connectionSearchResult;



function loadloginpage(req, res){
	ejs.renderFile('./views/LoginPage.html', function(err,result){
		if(!err){
			res.end(result);
		}
		else{
			res.end("Error Occured!!");
			console.log(result);
		}
	});
 
};	

function successLogin(request,response)
{
	
	ejs.renderFile('./views/homePage.html',function(err, result) {
        // render on success
        if (!err) {
            response.end(result);
        }
        // render or error
        else {
            response.end('An error occurred');
            console.log(err);
        }
    });
}

function failLogin(request,response)
{
	ejs.renderFile('./views/LoginPage.html',function(err, result) {
        // render on success
        if (!err) {
            response.end(result);
        }
        // render or error
        else {
            response.end('An error occurred');
            console.log(err);
        }
    });
}


function connections(req, res) {
	ejs.renderFile('./views/connections.html', function(err, result) {
		if (!err) {
			res.end(result);
		} else {
			res.end("An error occured");
			console.log(err);
		}
	}) ;
}


function connectionSearchResult(req, res) {
	ejs.renderFile('./views/connectionSearchResult.html', function(err, result) {
		if (!err) {
			res.end(result);
		} else {
			res.end("An error occured");
			console.log(err);
		}
	}) ;
}
