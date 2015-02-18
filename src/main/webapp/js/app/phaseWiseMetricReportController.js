mainApp.controller("phaseWiseMetricReportController", function($scope,
		$cookieStore, HttpService) {
	$scope.storyMetricReport = {};
	$scope.storyMetricReport.projectName = $cookieStore
			.get("projectName");
	$scope.get = function() {
		HttpService
				.get(
						"storytask/groupByPhase/"
								+ $scope.storyMetricReport.projectName)
				.success(
						function(data) {
							$scope.storyMetricReportList = data;
						});
	}
	$scope.get();

});
