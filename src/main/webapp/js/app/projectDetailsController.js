mainApp.controller("projectDetailsController", function($scope, $cookieStore,
		HttpService) {
	$scope.projectDetails = {};
	$scope.projectDetails.projectName = $cookieStore.get("projectName");
	
	$scope.load = function() {
		HttpService.get("storytask/list/"
				+ $scope.projectDetails.projectName)
				.success(function(projectDetailsList) {
					$scope.projectDetailsList = projectDetailsList;
				});
	}
	$scope.load();
	
});

