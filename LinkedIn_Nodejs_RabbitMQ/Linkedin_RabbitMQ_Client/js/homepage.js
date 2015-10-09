
var successLogin = angular.module('homePageApp', ['xeditable','ui.bootstrap']);
successLogin.run(function(editableOptions) {
	  editableOptions.theme = 'bs3'; // bootstrap3 theme. Can be also 'bs2', 'default'
});

successLogin.controller('homePageController', homePageController);

function homePageController($scope, $http, $location, $window) {
	if($window.localStorage.token)
	{
		$scope.last_Login = $window.localStorage.lastLog;
	
	var reqUserInfo = {
			method : 'GET',
			url : '/getUserInfo'
		};
		$http(reqUserInfo).success(function(response) {
			if (response.status === "Success") {					
				$scope.userV = {
					    name: response.user.User_Name,
					    professional_headline: response.user.Professional_Headline,
					    city: response.user.City,
					    state: response.user.State,
					    summary: response.user.Summary
				};
				
			} else {
				$window.localStorage.clear();
				$window.location = '/login';
			}	
		}).error(function(error) {
			alert("Error in getting profile");
		});
		
		var reqLastLogin={
				method: 'GET',
				url: '/getLastLogin'
		};
		$http(reqLastLogin).success(function(response) {
			if (response.status === "Success") {	
				//alert("Last login updated");
				//$window.localStorage.lastLog = Date.parse(response.lastlog);
				//$scope.last_Login = $window.localStorage.lastLog;
			} else {
				$window.localStorage.clear();
				$window.location = '/login';
			}	
		}).error(function(error) {
			alert("Error in getting last login");
		});
		
		var reqEducationDetails = {
				method : 'GET',
				url : '/getEduInfo'
			};
		$http(reqEducationDetails).success(function(response) {
			if (response.status === "Success") {					
				//alert(JSON.stringify(response.educationDetail));
				$scope.eduationDetail = JSON.parse(response.educationDetail);
				$scope.eduationDetail.Year_of_Joining = Date.parse($scope.eduationDetail.Year_of_Joining);
				$scope.eduationDetail.Year_of_Ending = Date.parse($scope.eduationDetail.Year_of_Ending);
			} else {
				$window.localStorage.clear();
				$window.location = '/login';
			}	
		}).error(function(error) {
			alert("Error in getting education Info");
		});
		
		var reqExperienceDetails = {
				method : 'GET',
				url : '/getExpInfo'	
			};
		$http(reqExperienceDetails).success(function(response) {
			if (response.status === "Success") {					
				//alert(JSON.stringify(response.educationDetail));
				$scope.experienceDetail = JSON.parse(response.experienceDetail);
				$scope.experienceDetail.Start_Date = Date.parse(response.experienceDetail.Start_Date);
				$scope.experienceDetail.End_Date = Date.parse(response.experienceDetail.End_Date);
			} else {
				$window.localStorage.clear();
				$window.location = '/login';
			}	
		}).error(function(error) {
			alert("Error in getting experience details");
		});
		
		
		
		var reqSkillDetails = {
				method : 'GET',
				url : '/getSkillInfo'
			};
		$http(reqSkillDetails).success(function(response) {
			if (response.status === "Success") {					
				//alert(JSON.stringify(response.educationDetail));
				$scope.skillDetail = JSON.parse(response.skillDetail);
			} else {
				$window.localStorage.clear();
				$window.location = '/login';
			}	
		}).error(function(error) {
			alert("Error in getting skill details");
		});
		//UPDATE FIELD
		$scope.updateUser = function(data, field) {
			var fieldName;
			if (field === "name") {
				fieldName = "User_Name";
			} else if (field === "prof_heading") {
				fieldName = "Professional_Headline";
			} else if (field === "state") {
				fieldName = "State";
			} else if (field === "city") {
				fieldName = "City";
			} else if (field === "summary") {
				fieldName = "Summary";
			} 
			var req = {
					method : 'POST',
					url : '/updateUser',	
					data: {
						"User_ID": $window.localStorage.userID, "name": data, "field": fieldName
					}
				};
		    return $http(req);
		};
		//UPDATE User Education Details
		$scope.updateUserEdu=function(data,field,eduID){
			var fieldName;
			switch(field){
				case 'uniname':
					fieldName = "University_Name";
					break;
				case 'degree':
					fieldName = "Graduation";
					break;
				case 'courses':
					fieldName = "Courses";
					break;
				case 'yoj':
					fieldName = "Year_of_Joining";
					break;
				case 'yoe':
					fieldName = "Year_of_Ending";
					break;
			}
			var req = {
					method : 'POST',
					url : '/updateUserEdu',	
					data: {
						"name": data, "field": fieldName,"eduID":eduID
					}
				};
		    return $http(req);
		}
		
		//Update User Experience Details
		$scope.updateUserExp=function(data,field,expID){
			var fieldName;
			switch(field){
				case 'companyname':
					fieldName = "Company_Name";
					break;
				case 'jobtitle':
					fieldName = "Job_Title";
					break;
				case 'jobprofile':
					fieldName = "Job_Profile";
					break;
				case 'startdate':
					fieldName = "Start_Date";
					break;
				case 'enddate':
					fieldName = "End_Date";
					break;
			}
			var req = {
					method : 'POST',
					url : '/updateUserExp',	
					data: {
						"name": data, "field": fieldName,"expID":expID
					}
				};
		    return $http(req);
		}
		
		//OPEN EDUCATION PANEL 
		$scope.addEducationToggle = function () {
			$scope.educationDiv = !$scope.educationDiv;
		};
		//ADD EDUCATION 
		$scope.addEducationDetail = function () {
			var reqAddEduDetails = {
					method : 'POST',
					url : '/addEducationDetail',
					data: {
						"User_ID": $window.localStorage.userID,
						"Degree": $scope.degree,
						"University_Name": $scope.school,
							"Courses": $scope.courses,
						"YOJ" : $scope.yoj,
						"YOE" : $scope.yoe
					}
				};
			$http(reqAddEduDetails).success(function(response) {
				if (response.status === "Success") {					
					$window.location = '/homePage';
				} else {
					$window.localStorage.clear();
					$window.location = '/login';
				}	
			}).error(function(error) {
				alert("Error in adding education details");
			});
		};
		
		$scope.addExperienceToggle = function () {
			$scope.experienceDiv = !$scope.experienceDiv;
		};
		
		$scope.addExperienceDetail = function () {
			var reqAddEduDetails = {
					method : 'POST',
					url : '/addExperienceDetail',
					data: {
						"User_ID": $window.localStorage.userID,
						"Company": $scope.company,
						"JobTitle": $scope.jobTitle,
						"JobDesc": $scope.jobDesc,
						"StartDate" : $scope.startDate,
						"EndDate" : $scope.endDate
					}
				};
			$http(reqAddEduDetails).success(function(response) {
				if (response.status === "Success") {					
					$window.location = '/homePage';
				} else {
					$window.localStorage.clear();
					$window.location = '/login';
				}	
			}).error(function(error) {
				alert("Error in adding experience details");
			});
		};
		
		$scope.addSkillToggle = function () {
			$scope.skillDiv = !$scope.skillDiv;
		};
		
		$scope.addSkillDetail = function () {
			var reqAddSkillDetail = {
					method : 'POST',
					url : '/addSkillDetail',
					data: {
						"User_ID": $window.localStorage.userID,
						"Skill": $scope.skill
					}
				};
			$http(reqAddSkillDetail).success(function(response) {
				if (response.status === "Success") {					
					$window.location = '/homePage';
				} else {
					$window.localStorage.clear();
					$window.location = '/login';
				}	
			}).error(function(error) {
				alert("Error in adding skill details");
			});
		};
		
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
					//alert("reached");
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

