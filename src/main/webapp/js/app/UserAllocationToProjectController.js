mainApp.controller("UserAllocationToProjectController", function($scope,
		$cookieStore, $routeParams, HttpService) {
	$scope.flag = false;
	$scope.savebtn = true;
	$scope.showLabel = false;
	$scope.user = {};

	if ($cookieStore.get("role") == 'Admin') {
		$scope.role = true;
	} else {
		$scope.role = false;
	}

	$scope.load = function() {
		HttpService.get("userController/users").success(function(data) {
			$scope.userList = data;
		});
	}

	$scope.load();

	$scope.save = function() {
		$scope.showLabel = true;
		HttpService.post('userController/user', $scope.user).success(
				function(data, status) {
					$scope.load();
					alert("Action successfull !!!");
					$scope.flag = false;
					$scope.showLabel = false;
				}).error(function(data) {
			alert("Action unsuccessfull !!!");
			$scope.showLabel = false;
		});

	}

	$scope.update = function(index) {
		$scope.user = $scope.userList[index];
		$scope.flag = true;
		$scope.savebtn = false;
	}

	$scope.edit = function() {
		HttpService.post("userController/updateUser", $scope.user).success(
				function(data) {
					$scope.load();
					alert("Action successfull !!!");
					$scope.flag = false;
					$scope.savebtn = true;
				}).error(function(data) {
			alert("Action unsuccessfull !!!");
		});
	}

	$scope.add = function() {
		$scope.user = {};
		$scope.flag = true;
		$scope.savebtn = true;
	}

	$scope.back = function() {
		$scope.flag = false;
	}

});
