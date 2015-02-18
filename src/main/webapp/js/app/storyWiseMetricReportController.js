mainApp
		.controller(
				"storyWiseMetricReportController",
				function($scope, $cookieStore, HttpService) {

					$scope.storyMetricReport = {};
					$scope.storyMetricReport.projectName = $cookieStore
							.get("projectName");
					$scope.get = function() {
						HttpService
								.get(
										"storytask/group/"
												+ $scope.storyMetricReport.projectName)
								.success(
										function(storyMetricReportList) {
											$scope.storyMetricReportList = storyMetricReportList;
											$scope.load();
										});
					}
					$scope.get();
					$scope.load = function() {
						HttpService
								.get(
										"storytask/list/"
												+ $scope.storyMetricReport.projectName)
								.success(
										function(storyMetricReportList1) {
											$scope.storyMetricReportList1 = storyMetricReportList1;
										});
					}
					$scope.getStatus = function() {
						for (var j = 0; j < $scope.storyMetricReportList.length; j++) {
							for (var i = 0; i < $scope.storyMetricReportList1.length; i++) {
								if ($scope.storyMetricReportList[i]._id == $scope.storyMetricReportList1[i].storyId) {
									if ($scope.storyMetricReportList1[i].phase == "Milestone") {
										i = $scope.storyMetricReportList1.length;
										return "YES";
									} else {
										return "NO";
									}
								}
							}
						}
					}
				});
