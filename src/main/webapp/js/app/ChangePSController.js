mainApp.controller("ChangePSController", function($scope, $cookieStore,
		HttpService) {

	var emailId = $cookieStore.get("emailId");
	$scope.user = {};
	$scope.load = function() {
		HttpService.get("userController/getUser?emailId=" + emailId).success(
				function(data) {
					$scope.user = data;
				});
	}

	$scope.update = function() {
		$scope.user.emailId = emailId;
		$scope.user.password = $scope.newpwd;
		HttpService.post("userController/updateUser", $scope.user).success(
				function(data) {
					$scope.load();
					alert("Password updated successfully.");
					window.location = "/eWBS/home.html";
				});
	}

	$scope.load();

	$scope.$watch("password", function() {
		if ($scope.password) {
			$scope.userForm.password.$setValidity("pwdOldMatch",
					$scope.password == $scope.user.password);
		}
	});

	$scope.$watch("newpwd", function() {
		if ($scope.newpwd) {
			$scope.userForm.newpwd.$setValidity("minLength",
					$scope.newpwd.length >= 4);
		}
	});

	$scope.$watch("newpwdcofirm", function() {
		if ($scope.newpwd && $scope.newpwdcofirm) {
			$scope.userForm.newpwdcofirm.$setValidity("pwdMatch",
					$scope.newpwd == $scope.newpwdcofirm);
		}
	});

});
