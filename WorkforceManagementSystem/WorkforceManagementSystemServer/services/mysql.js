var ejs= require('ejs');
var mysql = require('mysql');

function getConnection(){	
	var connection=mysql.createConnection({
		host     : 'localhost',
		user     : 'root',
		password : 'SjSu@2015',
		database : 'wfms'
	});
	return connection;
}

exports.getConnection=getConnection;

exports.fetchData2 = function(callback, sqlQuery, param) {

	console.log("\nSQL Query::" + sqlQuery);

	var connection = getConnection();

	connection.query(sqlQuery, param, function(err, rows, fields) {

		if (err) {
			console.log("ERROR: " + err.message);
		} else { // return err or result

			callback(err, rows);

		}
	});
	console.log("\nConnection closed..");
	connection.end();
}

exports.fetchData = function(callback, sqlQuery) {

	console.log("\nSQL Query::" + sqlQuery);

	var connection = getConnection();

	connection.query(sqlQuery, function(err, rows, fields) {

		if (err) {
			callback(err);
		} else { // return err or result
			console.log(rows);
			callback(err, rows);

		}
	});
	console.log("\nConnection closed..");
	connection.end();
}