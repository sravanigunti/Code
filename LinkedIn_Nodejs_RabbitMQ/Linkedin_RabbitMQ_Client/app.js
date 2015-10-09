
var express = require('express')
  , routes = require('./routes')
  , user = require('./routes/user')
  , login = require('./routes/login')
  , loginService = require('./routes/loginservice')
  , profile = require('./routes/profileservice')
  , memberService = require('./routes/memberservice')
  , http = require('http')
  , path = require('path');

var app = express();

// all environments
app.set('port', process.env.PORT || 5564);
app.set('views', __dirname + '/views');
app.set('view engine', 'ejs');
app.use(express.favicon());
app.use(express.logger('dev'));
app.use(express.bodyParser());

app.use(express.cookieParser());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
app.use(express.session({secret: 'name it', cookie: { maxAge: 600000}}));

app.use(express.methodOverride());

app.use(express.static(path.join(__dirname, 'public')));
app.use('/js',express.static(path.join(__dirname, '/js')));
app.use('/routes',  express.static(__dirname + '/routes'));
app.use('/bower_components',  express.static(__dirname + '/bower_components'));
app.use(app.router);

// development only
if ('development' === app.get('env')) {
  app.use(express.errorHandler());
}

function check_session(req,res,next){
	console.log("Session : " + req.session.userid);
	if(req.session.userid)
	{
		console.log("ok");
		next();
	}
	else{
		res.end('401');
	}
}


app.get('/', routes.index);
app.get('/login',login.loadloginpage);
app.post('/login',loginService.after_sign_in);
app.post('/signUp',loginService.signup);

app.get('/homepage',login.successLogin);
app.get('/getUserInfo',check_session,profile.getProfile);
app.get('/signout',loginService.signout);

app.get('/getLastLogin',loginService.getLastLogin);
app.get('/getEduInfo',profile.getEducation);
app.get('/getExpInfo',profile.getExperience);
app.get('/getSkillInfo',profile.getSkill);
app.post('/addEducationDetail',profile.addEducation);
app.post('/addExperienceDetail',profile.addExperience);
app.post('/addSkillDetail',profile.addSkill);
app.post('/updateUser',profile.updateUser);
app.post('/updateUserEdu',profile.updateUserEdu);
app.post('/updateUserExp',profile.updateUserExp);
app.get('/connections',login.connections);


app.get('/conn',check_session,memberService.showConnections);
app.get('/pendingConn',memberService.pendingConnections);
app.get('/connectionSearchResult', login.connectionSearchResult);
app.post('/searchUsers',memberService.searchMember);
app.post('/acceptinvitation',memberService.acceptInvitation);
app.post('/sendinvite',memberService.sendInvitation);

app.get('/users', user.list);

http.createServer(app).listen(app.get('port'), function(){
  console.log('Express server listening on port ' + app.get('port'));
});
