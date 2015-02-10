mainApp.controller("storyMetricReportController", function($scope, $http,
		$cookieStore) {
	$scope.storyMetricReport = {};
	$scope.storyMetricReport.projectName = $cookieStore.get("projectName");
	get();
	function get() {
		$http.get(
				"/eWBS/resources/storytask/group/"
						+ $scope.storyMetricReport.projectName).success(
				function(data) {
					$scope.storyMetricReportList = data;
					load();
				}).error(function(data) {
			alert(data);
		});
	}
	function load() {
		$http.get(
				"/eWBS/resources/storytask/list/"
						+ $scope.storyMetricReport.projectName).success(
				function(data) {
					$scope.storyMetricReportList1 = data;
				}).error(function(data) {
			alert(data);
		});
	}
	$scope.getStatus = function() {
		for (var j = 0; j < $scope.storyMetricReportList.length; j++) {
			for (var i = 0; i < $scope.storyMetricReportList1.length; i++) {
				if ($scope.storyMetricReportList[i]._id == $scope.storyMetricReportList1[i].storyId) {
					if ($scope.storyMetricReportList1[i].status == "Completed") {
						i= $scope.storyMetricReportList1.length;
						return "YES";
						
					} else {
						return "NO";
					}
				}
			}
		}
	}
});
