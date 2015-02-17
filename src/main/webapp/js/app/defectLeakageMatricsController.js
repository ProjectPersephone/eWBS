mainApp.controller("defectLeakageMatricsController", function($scope, $cookieStore,
		HttpService) {

	$scope.flag = false;

	$scope.dbLeakage = {};
	$scope.dbLeakage.projectName = "";
	$scope.dbLeakage.requirements = [ 0, 0, 0, 0, 0, 0 ];
	$scope.dbLeakage.analysis = [ 0, 0, 0, 0, 0, 0 ];
	$scope.dbLeakage.design = [ 0, 0, 0, 0, 0, 0 ];
	$scope.dbLeakage.coding = [ 0, 0, 0, 0, 0, 0 ];
	$scope.dbLeakage.testing = [ 0, 0, 0, 0, 0, 0 ];
	$scope.dbLeakage.production = [ 0, 0, 0, 0, 0, 0 ];
	var projectName = $cookieStore.get("projectName");
	
	$scope.load = function() {
		HttpService.get(
				"DefectLeakageMetric/findByProject?projectName="+ projectName)
				.success(function(dbLeakage) {
					$scope.dbLeakage = dbLeakage;
				});
	}
	$scope.load();
	
	$scope.submit = function(dbLeakage) {
		$scope.dbLeakage = dbLeakage;
		HttpService.post("DefectLeakageMetric/save?projectName="+ projectName, $scope.dbLeakage).success(function(data, status) {
			if (status == 200) {
				alert("data entered into database successfully");
				$scope.load();
				$scope.flag = false;
			} else
				alert(status);
		}).error(function(data, status) {
			alert(status);
		});

	}
	$scope.add = function() {
		$scope.flag = true;
	}

	$scope.back = function() {
		$scope.flag = false;
	}

});
