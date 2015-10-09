exports.index = function(req, res){
  res.render('index');
};

exports.dashboard = function(req, res){
  res.render('dashboard');
};

exports.displayGuard = function(req, res){
	  res.render('displayGuard');
	};
	
exports.displayClient = function(req, res){
	  console.log("Client Id:",req.param("clientId"));
	  res.render('displayClient');
	};
	
exports.displayReport = function(req, res){
	  res.render('displayReport');
	};
	
exports.displayBuilding = function(req, res){
	  res.render('displayBuilding');
	};

exports.searchClients = function(req, res){
	  res.render('searchClients');
	};

exports.searchBuildings = function(req, res){
	  res.render('searchBuildings');
	};
	
exports.searchGuard = function(req, res){
	  res.render('searchGuard');
	};
	
exports.searchReports = function(req, res){
	  res.render('searchReports');
	};

exports.searchAlerts = function(req, res){
	  res.render('searchAlerts');
	};
	
exports.createGuard = function(req,res){
	res.render('createGuard');
};

exports.createClient = function(req,res){
	res.render('createClient');
};

exports.createBuilding = function(req,res){
	res.render('createBuilding');
};

exports.createReport = function(req,res){
	res.render('createReport');
};

exports.createAlertType = function(req,res){
	res.render('createAlertType');
};

exports.checkIn= function(req,res){
	res.render('checkIn');
};
	