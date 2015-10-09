var mysql = require('mysql');
exports.fetchData=fetchData;
var pool = [];
var waitlist = [];
var queueItem = {cb:"",sqlQuery:""}
var count=0;

function getConnection(){
	var connection = mysql.createConnection({
		host     : 'localhost',
	    user     : 'root',
	    password : '',
	    database : 'LinkedIn'
	});
	return connection;
}

var PoolOfConnection = new createConnectionsInPool(25);

function createConnectionsInPool(numberOfConnections){
	console.log(pool);
	for(var i=0;i<numberOfConnections;i++){
		pool.push(getConnection());	
	}
}

createConnectionsInPool.prototype.getConnectionFromPool = function(){
	var connection = pool.pop();
	 
	return connection;	
}

function checkWaitList(){
		if(waitlist.length > 0){
				pendingQuery = waitlist.shift();
				console.log("Request fetched from queue");
				fetchData(pendingQuery.cb,pendingQuery.sqlQuery);
		}
}

function fetchData(callback,sqlQuery){
 
	
	if(pool.length === 0){
			 
					queueItem.cb = callback;
					queueItem.sqlQuery = sqlQuery;
					waitlist.push(queueItem);
			 
	}
	else{
			var connection = PoolOfConnection.getConnectionFromPool();
		
			connection.query(sqlQuery, function(err, rows, fields) {
			if(err){
				console.log("FetchData ERROR: " + err.message);
			}
			else {	 	
				pool.push(connection);
			 
				checkWaitList();
				callback(err, rows);
			}
		});		
	}
}	

 