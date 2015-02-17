mainApp.controller("functionalTaskController", function($scope, $cookieStore,
		HttpService) {
	$scope.flag = false;
	$scope.functionalTask = {};
	$scope.functionalTask.projectName = "";

	var projectName = $cookieStore.get("projectName");

	$scope.load = function() {
		HttpService.get(
				"FunctionalTask/findByProject?projectName=" +projectName)
				.success(function(functionalTask) {
					$scope.functionalTask = functionalTask;
				});
	}
	$scope.load();

	$scope.submit = function() {
		HttpService.post("FunctionalTask/save?projectName=" + projectName,
				$scope.functionalTask).success(function(data) {
					$scope.load();
			alert("Action successfull !!!");
			$scope.flag = false;
		
		}).error(function(data) {
			alert("Action unsuccessfull !!!");
			$scope.load();
		});
	}

	$scope.update = function() {
		$scope.flag = true;
	}

	$scope.back = function() {
		$scope.flag = false;
	}

});