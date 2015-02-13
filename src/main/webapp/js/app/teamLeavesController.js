mainApp.controller("teamLeavesController", function($scope, $location, $cookieStore,
		HttpService) {
	$scope.flag = false;
	$scope.teamLeaves = {};
	$scope.teamLeaves.name = $cookieStore.get("name");
	
	$scope.load = function() {
		HttpService.get(
				"teamLeaves/list")
				.success(function(teamLeaveslist) {
					$scope.teamLeaveslist = teamLeaveslist;
				});
	}
	$scope.load();
	
	$scope.save = function() {
		HttpService.post("teamLeaves/save", $scope.teamLeaves).success(
				function(data) {
					$scope.load();
					alert("Leaves added successfull !!!");
					$scope.flag = false;
				}).error(function(data) {
			alert("Team Leaves is Not added!!!");
		});
	}
	
	
	$scope.add = function() {
		$scope.flag = true;
	}
	
	$scope.dateDifference = function(date1, date2) {
		var dt1 = date1.split('/');
		var dt2 = date2.split('/');
		var one = new Date(dt1[2], dt1[1], dt1[0]);
		var two = new Date(dt2[2], dt2[1], dt2[0]);

		var millisecondsPerDay = 1000 * 60 * 60 * 24;
		var millisBetween = two.getTime() - one.getTime();
		var days = millisBetween / millisecondsPerDay;
		return Math.floor(days);
	}
});
