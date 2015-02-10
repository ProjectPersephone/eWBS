
mainApp.controller("reviewCommentsAndBugsController", function($scope, $http,
		$cookieStore ) {
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

	load($cookieStore.get("projectName"));

	function load(projectName) {
		$http.get(
				"/eWBS/resources/defect/findByProject?projectName="
						+ projectName).success(function(data, status) {
			$scope.dbBugs = data;
		});
	}
	$scope.get = function() {
		$scope.flag = true;
	}

	$scope.submit = function() {

		$http.post('/eWBS/resources/defect/save', $scope.dbBugs).success(

		function(data, status) {
			if (status == 200) {
				alert("dbBugs data entered into database successfully");
				load($cookieStore.get("projectName"));
				$scope.flag = false;
			}
		});
	}

});