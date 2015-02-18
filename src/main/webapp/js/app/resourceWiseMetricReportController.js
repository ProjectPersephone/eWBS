mainApp.controller("resourceWiseMetricReportController", function($scope,
		$cookieStore, HttpService) {
	$scope.storyMetricReport = {};
	$scope.storyMetricReport.projectName = $cookieStore
			.get("projectName");
	$scope.get = function() {
		HttpService
				.get(
						"storytask/groupByResource/"
								+ $scope.storyMetricReport.projectName)
				.success(
						function(data) {
							$scope.storyMetricReportList = data;
						});
	}
	$scope.get();

});