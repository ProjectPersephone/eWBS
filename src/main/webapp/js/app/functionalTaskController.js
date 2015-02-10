mainApp.controller("functionalTaskController", function($scope, $http,
		$cookieStore) {

	$scope.flag = false;

	$scope.functionalTask = {};
	$scope.functionalTask.projectName = "";
	var projectName = $cookieStore.get("projectName");
	load();
	function load() {
		alert("/eWBS/resources/FunctionalTask/findByProject?projectName="
				+ projectName);
		$http.get(
				"/eWBS/resources/FunctionalTask/findByProject?projectName="
						+ projectName).success(function(data, status) {

			$scope.functionalTask = data;
		}).error(function(data) {
			alert(data);
		});

	}
	$scope.submit = function() {
		$http.post(
				'/eWBS/resources/FunctionalTask/save?projectName='
						+ projectName, $scope.functionalTask).success(
				function(data, status) {
					if (status == 200) {
						alert("data entered into database successfully");
						load();
						$scope.flag = false;
					} else
						alert(status);
				}).error(function(data, status) {
			alert(status);
		});

	}
	$scope.add = function() {
		$scope.flag = true;
	}

	$scope.back = function() {
		$scope.flag = false;
	}

});