mainApp.controller("defectPreventionPlanController", function($scope, $cookieStore,
		HttpService) {
	$scope.flag = false;
	$scope.flagUpdate = false;
	$scope.flagSave = true;

	if ($cookieStore.get("role") == 'Admin') {
		$scope.role = true;
	} else {
		$scope.role = false;
	}

	$scope.defectPreventionPlan = {};
	$scope.load = function() {
		HttpService.get(
				"defectPreventionPlan/findByProject?projectName="
						+ $cookieStore.get("projectName")).success(
				function(defectList) {
					// alert(JSON.stringify(causeList));
					$scope.defectPreventionPlanList = defectList;
				});
	}
    $scope.load();
	$scope.save = function() {
		HttpService.post(
				"defectPreventionPlan/save?projectName="
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
		HttpService.get(
				"defectPreventionPlan/findDefectByName/"
						+ $cookieStore.get("projectName") + "/"
						+ defectTypeAndDetails).success(function(defect) {
			$scope.defectPreventionPlan = defect;
			$scope.flag = true;
			$scope.flagUpdate = true;
			$scope.flagSave = false;
		});
	}

	$scope.updateValue = function(defectTypeAndDetails) {

		HttpService.post(
				"defectPreventionPlan/update/"
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