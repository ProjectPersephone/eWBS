mainApp.controller("metricReportController", function($scope, $http, $document,
		$location, $cookieStore) {
	$(document).ready(function() {
		$("button").click(function() {
			$("div").scrollLeft();
		});
	});

	var projectName = $cookieStore.get("projectName");
	load();
	function load() {
		$http.get("/eWBS/resources/storytask/list/" + projectName).success(
				function(data) {
					$scope.storyTask = data;
				}).error(function(data) {
		});
	}

	$scope.sum = function(property) {
		var total = 0;
		for (var i = 0, len = $scope.storyTask.length; i < len; i++) {
			total += $scope.storyTask[i][property];
		}
		return total;
	}

	$scope.total = function(obj, property) {
		var total = 0;
		alert($scope[obj][property].length);
		for (var i = 0, len = $scope[obj][property].length; i < len; i++) {
			total += $scope[obj][property][i];
		}
		return total;
	}

	$scope.sumByPhase = function(property, phase) {
		var total = 0;
		for (var i = 0, len = $scope.storyTask.length; i < len; i++) {
			if ($scope.storyTask[i].phase == phase) {
				total += $scope.storyTask[i][property];
			}
		}
		return total;
	}

	$scope.sumByPhaseType = function(property, phaseType) {
		var total = 0;
		for (var i = 0, len = $scope.storyTask.length; i < len; i++) {
			if ($scope.storyTask[i].phase.indexOf(phaseType) > -1) {
				total += $scope.storyTask[i][property];
			}
		}
		return total;
	}

	$scope.percent = function(property) {
		var total = 0, i = 0;
		for (i, len = $scope.storyTask.length; i < len; i++) {
			total += $scope.storyTask[i][property];
		}
		var percent = total / i;
		return +(Math.round(percent + "e+3") + "e-3");
	}

});
