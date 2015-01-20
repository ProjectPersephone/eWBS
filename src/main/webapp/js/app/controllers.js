mainApp.controller("LoginController", function($scope, $http, $location,
		UserService) {
	$scope.submit = function() {
		$http.post('/eWBS/resources/login', $scope.user).success(
				function(data, status) {
					if (status == 200) {
						alert("Login successfully.");
						var username = data["username"];
						var resource = data["resource"];
						var role = data["role"];
						UserService
								.setUserField(username, resource, role, true);
						$location.path("/projects");
					} else {
						alert("Unathourised credential.");
					}
				}).error(function() {
			alert("Unathourised credential.");
		});
	}
});

mainApp.controller("Profile", function($scope, UserService) {
	$scope.msg = UserService.getUser().username;
});

mainApp.controller("ProjectController", function($scope, $http, UserService) {
	alert("Welcome");
});
