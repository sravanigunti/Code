var userID;
var connectionPageApp = angular.module('connectionPageApp', ['xeditable']);
connectionPageApp.run(function(editableOptions) {
	  editableOptions.theme = 'bs3'; // bootstrap3 theme. Can be also 'bs2', 'default'
});

function connectionPageController($scope, $http, $location, $window) {
	if ($window.localStorage.token) { 
	$scope.last_Login = $window.localStorage.lastLog; 
	var req = {
			method : 'GET',
			url : '/conn'
		};
		
		$http(req).success(function(response) {
			if (response.status === "Success") {
				//alert(response.connectedPeopleList);		
				$scope.connections = JSON.parse(response.connectedPeopleList);
			}
			else
			{
				$window.location = '/login';
			}
		}).error(function(error) {
			alert("Error in getting Connections");
	});
	
	var req = {
				method : 'GET',
				url : '/pendingConn'		
			};
		$http(req).success(function(response) {
			if (response.status === "Success") {
				$scope.pendingConnectionList = JSON.parse(response.pendingConnectionList);
			}
		}).error(function(error) {
			alert("Error in getting pending connections");
	});	
		
	$scope.search = function () {
		$window.localStorage.search = $scope.searchString;
		$window.location = '/connectionSearchResult';
	};
	
	$scope.connect = function (userID) {
			//alert("Invitation Accepted " + user);
			var req = {
					method : 'POST',
					url : '/acceptinvitation',	
					data: {
						'acceptedInvitationId':userID
					}
				};
			$http(req).success(function(response) {
				//alert(JSON.stringify(response));
				if (response.status === "Success") {
					alert("Invitation Accepted ");
					//$scope.pendingConnectionList = JSON.parse(response.pendingConnectionList);
					//alert($scope.connections);
					$window.location = '/connections';
				}
			}).error(function(error) {
				alert("Accept Invitation failed");
			});
		}
	
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
			alert("Error in Logging Out");
		});
	}
	}else {
		$window.location = '/login';
	}
};

connectionPageApp.controller('connectionPageController', connectionPageController);