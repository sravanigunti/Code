

var login = angular.module('linkedinLogin',[]);
login.controller('signInController',signIn);
login.controller('signUpController',signUp);

function signIn($scope,$http,$location,$window) {
	
	if($window.localStorage.token)
	{
		window.location='/homepage';	
	}
	else{
		
		$scope.login = function () {
			$http({
	            method: 'POST',
	            url: '/login',
	            data: { "username": $scope.email, "password": $scope.password },
				withCredentials: true
	         }).success(function(response){
	          // alert(JSON.stringify(response)); 
	            if(response.login == "Success")
	            {
	            	$window.localStorage.clear();
	            	//$window.localStorage.token=response.Token;
	            	$window.localStorage.token = $scope.email;
	            	//alert(response.lastlog);
	            	$window.localStorage.lastLog = Date.parse(response.lastlog);
	            	$window.localStorage.userID= response.User_ID;
	           		window.location = '/homepage';
	            }
	            else
	            {
	            	$scope.invalidUser = "Invalid Username or Password";
	            	//window.location = '/failLogin';
	            }
	        }).error(function(error){
	            alert("sign in - error");
	        }); 
		};	
	}
}
     
     function signUp($scope,$http,$location){
    	 $scope.submit = function(){	   		 
    		 var request = {
    				 method: 'POST',
    				 url: '/signUp',
    				 data: {"name":$scope.firstName+' '+$scope.lastName,
    					
    					 "newUserEmail":$scope.newUserEmail,
    					 "newUserPassword":$scope.newUserPassword},
    					 withCredentials: true	 
    		 }
    		 $http(request).success(function(response){
    			 if(response.status == 'Success')
    			 {	 			 
    				 $scope.accountCreated = "Account Created. Please signin.";
    			 }
    			 else
    			 {
    				 $scope.existingUser = "Account already exists.";
    			 }
    		 }).error(function(error){
    			 alert("SignUp: " + error);
    		 });
    	 }
     }
