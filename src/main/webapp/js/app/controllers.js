mainApp.controller("Profile", function($scope, $cookieStore) {
	$scope.resource = $cookieStore.get("resource");
	if ($cookieStore.get("username") == null) {
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
	$scope.flag = false;
	$scope.project = {};
	$http.get("/eWBS/resources/project/list").success(function(projectList) {
		$scope.projectList = projectList;
	});

	$scope.save = function() {
		$http.post('/eWBS/resources/project/add', $scope.project).success(
				function(data, status) {
					alert("Project added successfully.");
					$scope.flag = false;
				});
	}
	$scope.add = function() {
		$scope.flag = true;
	}
});

mainApp.controller("reviewCommentsAndBugsController", function($scope, $http,
		$cookieStore) {
	$scope.dbBugs = {};
	$scope.dbBugs.requirementsDefects = [ 0, 0, 0, 0 ];
	$scope.dbBugs.analysisDefects = [ 0, 0, 0, 0 ];
	$scope.dbBugs.designDefects = [ 0, 0, 0, 0 ];
	$scope.dbBugs.codeReviewsDefects = [ 0, 0, 0, 0 ];
	$scope.dbBugs.unitTestingDefects = [ 0, 0, 0, 0 ];
	$scope.dbBugs.integrationTestingDefects = [ 0, 0, 0, 0 ];
	$scope.dbBugs.systemTestingDefects = [ 0, 0, 0, 0 ];
	$scope.dbBugs.productionDefects = [ 0, 0, 0, 0 ];


	$scope.submit = function() {
		alert("data bug" + JSON.stringify($scope.dbBugs));
		$http.post('/eWBS/resources/defect/save', $scope.dbBugs).success(

		function(data, status) {
			if (status == 200) {
				alert("dbBugs data entered into database successfully");

			}
		});
	}

});
