mainApp.controller("reviewCommentsAndBugsController", function($scope,
		$cookieStore, HttpService) {

	$scope.dbBugs = {};
	$scope.dbBugs.requirementsDefects = [ 0, 0, 0, 0 ];
	$scope.dbBugs.analysisDefects = [ 0, 0, 0, 0 ];
	$scope.dbBugs.designDefects = [ 0, 0, 0, 0 ];
	$scope.dbBugs.codeReviewsDefects = [ 0, 0, 0, 0 ];
	$scope.dbBugs.unitTestingDefects = [ 0, 0, 0, 0 ];
	$scope.dbBugs.integrationTestingDefects = [ 0, 0, 0, 0 ];
	$scope.dbBugs.systemTestingDefects = [ 0, 0, 0, 0 ];
	$scope.dbBugs.productionDefects = [ 0, 0, 0, 0 ];
	$scope.dbBugs.projectName = $cookieStore.get("projectName");

	$scope.get = function() {
		$scope.flag = true;
	}

	$scope.back = function() {
		$scope.flag = false;
	}

	$scope.load = function(projectName) {
		HttpService
				.get(
						"defect/findByProject?projectName="
								+ $scope.dbBugs.projectName).success(
						function(data) {
							$scope.dbBugs = data;
						});
	}

	$scope.load();

	$scope.submit = function() {
		HttpService.post('defect/save', $scope.dbBugs).success(

		function(data) {
			alert("reviewAndBugs data entered into database successfully");
			$scope.load();
			$scope.flag = false;
		});
	}
});