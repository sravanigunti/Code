var express = require('express')
  , home = require('./routes/home')
  , reports = require('./routes/reports')
  , alerts = require('./routes/alerts')
  , login = require('./routes/login') 
  , http = require('http')    
  , path = require('path');
  //, con = require('./routes/mysql_connpool');


var app = express();

// all environments
app.set('port', process.env.PORT || 4000);
app.set('views', __dirname + '/views');
app.set('view engine', 'ejs');
app.use(express.cookieParser());
app.use(express.session({ secret: 'i study', cookie: { maxAge: 60000000 }}));
app.use(express.favicon());
app.use(express.logger('dev'));
app.use(express.bodyParser());
app.use(express.methodOverride());
app.use(app.router);
app.use(express.static(path.join(__dirname, 'public')));

// development only
if ('development' == app.get('env')) {
  app.use(express.errorHandler());
}

//user
app.get('/', home.index);
app.post('/', login.login);
app.get('/dashboard', home.dashboard);


//display
app.get('/displayGuard/:guardId', home.displayGuard);
app.get('/displayClient/:clientId', home.displayClient);
app.get('/displayReport/:reportId', home.displayReport);
app.get('/displayBuilding/:buildingId', home.displayBuilding);

//search
app.get('/searchClients', home.searchClients);
app.get('/searchBuildings', home.searchBuildings);
app.get('/searchGuard', home.searchGuard);

app.get('/searchReports', home.searchReports);
app.post('/searchReportsresult', reports.searchReports);
app.get('/clientcriteria', reports.clientcriteria);
app.post('/buildingcriteria', reports.buildingcriteria);
app.post('/alertcriteria', alerts.alertcriteria);

app.get('/searchAlerts', home.searchAlerts);
app.post('/searchAlertsResults', alerts.searchAlerts);

//create
app.get('/createGuard', home.createGuard);
app.get('/createClient', home.createClient);
app.get('/createBuilding', home.createBuilding);
app.get('/createReport', home.createReport);
app.get('/createAlertType', home.createAlertType);

app.get('/checkIn',home.checkIn);

http.createServer(app).listen(app.get('port'), function(){
	  console.log('Express server listening on port ' + app.get('port'));
	});
