mainApp.controller("ProjectController", function($rootScope, $scope,
		$cookieStore, HttpService) {
	$scope.savebtn = true;
	$scope.flag = false;
	$scope.project = {};

	if ($cookieStore.get("role") == 'admin') {
		$scope.role = true;
	} else {
		$scope.role = false;
	}

	$scope.load = function() {
		HttpService.get("project/list").success(function(projectList) {
			$scope.projectList = projectList;
		});
	}

	$scope.load();

	$scope.save = function() {
		HttpService.post("project/save", $scope.project).success(
				function(data) {
					$scope.load();
					alert("Action successfull !!!");
					$scope.flag = false;
				}).error(function(data) {
			alert("Action unsuccessfull !!!");
		});
	}

	$scope.edit = function() {
		HttpService.post("project/update", $scope.project).success(
				function(data) {
					$scope.load();
					alert("Action successfull !!!");
					$scope.flag = false;
					$scope.savebtn = true;
				}).error(function(data) {
			alert("Action unsuccessfull !!!");
		});
	}

	$scope.add = function() {
		$scope.project = {};
		$scope.flag = true;
		$scope.savebtn = true;
	}

	$scope.back = function() {
		$scope.flag = false;
	}

	$scope.select = function(projectName) {
		alert("Selected Project : " + projectName);
		$cookieStore.put("projectName", projectName);
		$scope.setProjectName(projectName);
	}

	$scope.update = function(index) {
		$scope.project = $scope.projectList[index];
		$scope.flag = true;
		$scope.savebtn = false;
	}
});
