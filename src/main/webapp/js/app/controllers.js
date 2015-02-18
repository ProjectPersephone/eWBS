mainApp.controller("TopBarController", function($scope, $rootScope,
		$cookieStore) {
	$scope.name = $cookieStore.get("name");
	$scope.projectName = $cookieStore.get("projectName");
	if ($cookieStore.get("emailId") == null) {
		window.location = "/eWBS/";
	}
	$scope.logout = function() {
		$cookieStore.remove('emailId');
		$cookieStore.remove('name');
		$cookieStore.remove('isLogged');
		$cookieStore.remove('role');
		$cookieStore.remove('projectName');
		window.location = "/eWBS/";
	}

	$rootScope.setProjectName = function(projectName) {
		$scope.projectName = projectName;
	}
});

loginApp.controller("LoginController", function($scope, $http, $cookieStore) {
	if ($cookieStore.get("isLogged") == true) {
		window.location = "/eWBS/home.html";
	}
	$scope.submit = function() {
		$http.post('/eWBS/resources/userController/login', $scope.user)
				.success(function(data, status) {
					if (status == 200) {
						alert("Login successfully.");
						$cookieStore.put("emailId", data["emailId"]);
						$cookieStore.put("name", data["name"]);
						$cookieStore.put("role", data["role"]);
						$cookieStore.put("isLogged", true);
						window.location = "/eWBS/home.html";
					} else {
						alert("Unathourised credential.");
					}
				}).error(function() {
					alert("Unathourised credential.");
				});
	}
});


