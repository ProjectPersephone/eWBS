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

mainApp.controller("causalAnalysisController", function($scope, $http,
		$cookieStore) {
	$scope.flag = false;
	$scope.flagUpdate = false;
	$scope.flagSave = true;

	if ($cookieStore.get("role") == 'Admin') {
		$scope.role = true;
	} else {
		$scope.role = false;
	}

	$scope.causalAnalysis = {};
	load();
	function load() {
		$http.get(
				"/eWBS/resources/causalAnalysis/findByProject?projectName="
						+ $cookieStore.get("projectName")).success(
				function(causeList) {
					$scope.causalAnalysisList = causeList;
				});
	}

	$scope.save = function() {
		$http.post(
				'/eWBS/resources/causalAnalysis/save?projectName='
						+ $cookieStore.get("projectName"),
				$scope.causalAnalysis).success(function(data, status) {
			load();
			alert("Cause added successfully.");
			$scope.flag = false;
		});
	}
	$scope.add = function() {
		$scope.flag = true;
	}

	$scope.back = function() {
		$scope.flag = false;
	}

	$scope.update = function(causeOfBug) {
		$http.get(
				"/eWBS/resources/causalAnalysis/findCauseByName/"
						+ $cookieStore.get("projectName") + "/" + causeOfBug)
				.success(function(cause) {
					$scope.causalAnalysis = cause;
					$scope.flag = true;
					$scope.flagUpdate = true;
					$scope.flagSave = false;
				});
	}

	$scope.updateValue = function(causeOfBug) {
		$http.post(
				'/eWBS/resources/causalAnalysis/update/'
						+ $cookieStore.get("projectName"),
				$scope.causalAnalysis).success(function(data, status) {
			load();
			alert("Cause updated successfully.");
			$scope.flag = false;
			$scope.flagSave = true;
			$scope.flagUpdate = false;
		}).error(function(data, status) {
			alert("Cause not updated" + status);
		});
	}
});

mainApp.controller("addUserController", function($scope, $http, $cookieStore) {
	$scope.flag = false;
	$scope.flagUpdate = false;
	$scope.flagSave = true;
	$scope.showLabel = false;

	if ($cookieStore.get("role") == 'admin') {
		$scope.role = true;
	} else {
		$scope.role = false;
	}

	$scope.user = {};
	load();
	function load() {
		$http.get("/eWBS/resources/userController/users").success(
				function(userList) {
					$scope.userList = userList;
				});
	}

	$scope.save = function() {
		$scope.showLabel = true;
		$http.post('/eWBS/resources/userController/user', $scope.user).success(
				function(data, status) {
					load();
					alert("User added successfully.");
					$scope.flag = false;
					$scope.user = "";
					$scope.showLabel = false;
				}).error(function(data, status) {
			if (status == 409)
				alert("User e-mail Id already present");
			else
				alert("User not added" + status);
			$scope.showLabel = false;
		});

	}
	$scope.add = function() {
		$scope.flag = true;
	}

	$scope.back = function() {
		$scope.flag = false;
	}

	$scope.update = function(emailId) {
		$http.get("/eWBS/resources/userController/getUser?emailId=" + emailId)
				.success(function(user) {
					$scope.user = user;
					$scope.flag = true;
					$scope.flagUpdate = true;
					$scope.flagSave = false;
				}).error(function(data, status) {
					alert("Error" + status);
				});
	}

	$scope.updateValue = function(emailId) {
		$http.post('/eWBS/resources/userController/updateUser', $scope.user)
				.success(function(data, status) {
					load();
					alert("User updated successfully.");
					$scope.flag = false;
					$scope.flagSave = true;
					$scope.flagUpdate = false;
				}).error(function(data, status) {
					alert("User not updated" + status);
				});
	}
});

mainApp.controller("defectPreventionPlanController", function($scope, $http,
		$cookieStore) {
	$scope.flag = false;
	$scope.flagUpdate = false;
	$scope.flagSave = true;

	if ($cookieStore.get("role") == 'Admin') {
		$scope.role = true;
	} else {
		$scope.role = false;
	}

	$scope.defectPreventionPlan = {};
	load();
	function load() {
		$http.get(
				"/eWBS/resources/defectPreventionPlan/findByProject?projectName="
						+ $cookieStore.get("projectName")).success(
				function(defectList) {
					// alert(JSON.stringify(causeList));
					$scope.defectPreventionPlanList = defectList;
				});
	}

	$scope.save = function() {
		$http.post(
				'/eWBS/resources/defectPreventionPlan/save?projectName='
						+ $cookieStore.get("projectName"),
				$scope.defectPreventionPlan).success(function(data, status) {
			load();
			alert("defect added successfully.");
			$scope.flag = false;
		});
	}
	$scope.add = function() {
		$scope.flag = true;
	}

	$scope.back = function() {
		$scope.flag = false;
	}

	$scope.update = function(defectTypeAndDetails) {
		$http.get(
				"/eWBS/resources/defectPreventionPlan/findDefectByName/"
						+ $cookieStore.get("projectName") + "/"
						+ defectTypeAndDetails).success(function(defect) {
			$scope.defectPreventionPlan = defect;
			$scope.flag = true;
			$scope.flagUpdate = true;
			$scope.flagSave = false;
		});
	}

	$scope.updateValue = function(defectTypeAndDetails) {

		$http.post(
				'/eWBS/resources/defectPreventionPlan/update/'
						+ $cookieStore.get("projectName"),
				$scope.defectPreventionPlan).success(function(data, status) {
			load();
			alert("defect updated successfully.");
			$scope.flag = false;
			$scope.flagSave = true;
			$scope.flagUpdate = false;
		}).error(function(data, status) {
			alert("defect not updated" + status);
		});
	}
});