mainApp.controller("causalAnalysisController", function($scope,
		$cookieStore,HttpService) {
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
		HttpService.get(
				"causalAnalysis/findByProject?projectName="
						+ $cookieStore.get("projectName")).success(
				function(causeList) {
					$scope.causalAnalysisList = causeList;
				});
	}

	$scope.save = function() {
		HttpService.post(
				'causalAnalysis/save?projectName='
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
		HttpService.get(
				"causalAnalysis/findCauseByName/"
						+ $cookieStore.get("projectName") + "/" + causeOfBug)
				.success(function(cause) {
					$scope.causalAnalysis = cause;
					$scope.flag = true;
					$scope.flagUpdate = true;
					$scope.flagSave = false;
				});
	}

	$scope.updateValue = function(causeOfBug) {
		HttpService.post(
				'causalAnalysis/update/'
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
