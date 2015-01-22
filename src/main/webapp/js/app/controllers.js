mainApp.controller("Profile", function($scope, $cookieStore) {
	$scope.resource = $cookieStore.get("resource");
	if ($cookieStore.get("resource") == null) {
		window.location = "/eWBS/";
	}
	$scope.logout = function() {
		$cookieStore.remove('username');
		$cookieStore.remove('resource');
		$cookieStore.remove('isLogged');
		$cookieStore.remove('role');
		window.location = "/eWBS/";
	}
});

loginApp.controller("LoginController", function($scope, $http, $cookieStore) {
	$scope.submit = function() {
		$http.post('/eWBS/resources/login', $scope.user).success(
				function(data, status) {
					if (status == 200) {
						alert("Login successfully.");
						$cookieStore.put("username", data["username"]);
						$cookieStore.put("resource", data["resource"]);
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

mainApp.controller("ProjectController", function($scope, $http, $cookieStore) {
});
