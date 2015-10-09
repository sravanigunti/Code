var searchPageApp = angular.module('searchPageApp', ['xeditable']);
searchPageApp.run(function(editableOptions) {
	  editableOptions.theme = 'bs3'; // bootstrap3 theme. Can be also 'bs2', 'default'
});
var userID;
function searchPageController($scope, $http, $location, $window) {
	if ($window.localStorage.token) { 
	$scope.last_Login = $window.localStorage.lastLog;
	//alert($window.localStorage.search);
	var req = {
			method : 'POST',
			url : '/searchUsers',
			data: {
				'searchString': $window.localStorage.search,
				'User_ID': $window.localStorage.userID
			}
		};
	$http(req).success(function(response) {
		//alert(JSON.stringify(response));
		if (response.status === "Success") {
			$scope.peoples = JSON.parse(response.search);
			//$window.location = '/connectionSearchResult';
		}
	}).error(function(error) {
		alert("Error Searching For Result");
	});	
	
	$scope.connect = function (requestedUserid) {
		alert("Request Sent Successfully" + requestedUserid);
		var req = {
				method : 'POST',
				url : '/sendinvite',
				data: {
					'invitedUserid': requestedUserid,
				}
			};
		$http(req).success(function(response) {
			//alert(JSON.stringify(response));
			if (response.status === "Success") {
				//$scope.peoples = JSON.parse(response.search);
				$window.location = '/connectionSearchResult';
			}
		}).error(function(error) {
			alert("Error Searching For Result");
		});	
	}
	
	$scope.search = function () {
		$window.localStorage.search = $scope.searchString;
		$window.location = '/connectionSearchResult';
	};
	
	$scope.signOut = function() {
		var req = {
				method : 'GET',
				url : '/signout'
		};
		
		$http(req).success(function(response){
			if(response.status === "Success"){
				$window.localStorage.clear();
				$window.location = '/login';
			}
			
		}).error(function(error){
			alert("Error Logging Out");
		});
	}
	}else {
		$window.location = '/login';
	}
}

searchPageApp.controller('searchPageController', searchPageController);