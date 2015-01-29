mainApp.controller("Profile", function($scope, $cookieStore) {
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
		window.location = "/eWBS/";
	}
});

loginApp.controller("LoginController", function($scope, $http, $cookieStore) {
	$scope.submit = function() {
		$http.post('/eWBS/resources/login', $scope.user).success(
				function(data, status) {
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

mainApp.controller("ProjectController", function($scope, $location, $http,
		$cookieStore) {
	$scope.flag = false;

	if ($cookieStore.get("role") == 'admin') {
		$scope.role = true;
	} else {
		$scope.role = false;
	}

	$scope.project = {};
	load();
	function load() {
		$http.get("/eWBS/resources/project/list").success(
				function(projectList) {
					$scope.projectList = projectList;
				});
	}

	$scope.save = function() {
		$http.post('/eWBS/resources/project/add', $scope.project).success(
				function(data, status) {
					load();
					alert("Project added successfully.");
					$scope.flag = false;
				}).error(function(data, status) {
			alert("Project added successfully.");
		});
	}
	$scope.add = function() {
		$scope.flag = true;
	}

	$scope.back = function() {
		$scope.flag = false;
	}

	$scope.update = function(projectName) {
		alert(projectName);
	}

	$scope.select = function(projectName) {
		alert("Selected Project : " + projectName);
		$cookieStore.put("projectName", projectName);
		$location.reload();
	}
});

mainApp.controller("StoryController", function($scope, $http, $cookieStore) {
	$scope.flag = false;
});

mainApp.controller("StoryTaskController",
		function($scope, $http, $cookieStore) {
			alert("Hello");
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

mainApp
		.controller(
				"defectLeakageMatricsController",
				function($scope, $http, $cookieStore) {
					$scope.flag = false;
					$scope.dbLeakage = {};
					$scope.dbLeakage.requirements = [ 0, 0, 0, 0, 0, 0 ];
					$scope.dbLeakage.analysis = [ 0, 0, 0, 0, 0, 0 ];
					$scope.dbLeakage.design = [ 0, 0, 0, 0, 0, 0 ];
					$scope.dbLeakage.coding = [ 0, 0, 0, 0, 0, 0 ];
					$scope.dbLeakage.testing = [ 0, 0, 0, 0, 0, 0 ];
					$scope.dbLeakage.production = [ 0, 0, 0, 0, 0, 0 ];

					load();
					function load() {
						$http
								.get(
										"/eWBS/resources/DefectLeakageMetric/findByProject?projectName=a")
								.success(function(dbLeakage) {
									$scope.dbLeakage = dbLeakage;
								});

					}
					$scope.submit = function() {
						$http
								.post(
										'/eWBS/resources/DefectLeakageMetric/save',
										$scope.dbLeakage)
								.success(
										function(data, status) {
											if (status == 200) {
												alert("data entered into database successfully");
												load();
												$scope.flag = false;
											}
										});
					}
					$scope.add = function() {
						$scope.flag = true;
					}

					$scope.back = function() {
						$scope.flag = false;
					}

				});
