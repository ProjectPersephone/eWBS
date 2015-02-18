mainApp
		.controller(
				"UserAllocationToProjectController",
				function($scope, $cookieStore, $routeParams, HttpService) {
					$scope.flag = false;
					$scope.savebtn = true;
					$scope.showLabel = false;
					$scope.selection = [];
					$scope.user = {};
					$scope.users = [];
					$scope.user.project = [];

					if ($cookieStore.get("role") == 'Admin') {
						$scope.role = true;
					} else {
						$scope.role = false;
					}

					$scope.load = function() {
						HttpService.get(
								"userController/projectUsers?projectName="
										+ $routeParams.projectName).success(
								function(data) {
									$scope.projectUsers = data;
								});

						HttpService.get("userController/users").success(
								function(data) {
									$scope.userList = data;
								});

						HttpService.get(
								"userController/otherUsers?projectName="
										+ $routeParams.projectName).success(
								function(data) {
									$scope.otherUsers = data;
								});
					}

					$scope.load();

					$scope.save = function() {
						var total = 0;
						$scope.user.project = [];
						for (var i = 0, len = $scope.selection.length; i < len; i++) {
							for (var j = 0, le = $scope.otherUsers.length; j < le; j++) {
								if ($scope.otherUsers[j].name == $scope.selection[i]) {
									$scope.otherUsers[j].project
											.push($routeParams.projectName);

									var idx = $scope.otherUsers[j].project
											.indexOf("BENCH");
									if (idx > -1) {
										$scope.otherUsers[j].project.splice(
												idx, 1);
									}
									$scope.users.push($scope.otherUsers[j]);
								}
							}
						}
						HttpService.post("userController/updateAll",
								$scope.users).success(function(data) {
							alert("Records Updated");
							$scope.back();
						}).error(function(data) {
							alert("Action unsuccessfull !!!");
						});
					}

					$scope.remove = function(employee) {
						for (var j = 0, le = $scope.projectUsers.length; j < le; j++) {
							if ($scope.projectUsers[j].name == employee) {
								var idx = $scope.projectUsers[j].project
										.indexOf($routeParams.projectName);
								if (idx > -1) {
									$scope.projectUsers[j].project.splice(idx,
											1);
								}
								if ($scope.projectUsers[j].project.length == 0) {
									$scope.projectUsers[j].project
											.push("BENCH");
								}

								$scope.user = $scope.projectUsers[j];
								HttpService.post("userController/updateUser",
										$scope.user).success(function(data) {
									alert("User Removed !");
									$scope.load();
								}).error(function(data) {
									alert("Action unsuccessfull !");
								});
							}
						}
					}

					$scope.toggleSelection = function(employeeName) {
						var idx = $scope.selection.indexOf(employeeName);
						// is currently selected
						if (idx > -1) {
							$scope.selection.splice(idx, 1);
						}

						// is newly selected
						else {
							$scope.selection.push(employeeName);
						}
					}

					$scope.add = function() {
						$scope.flag = true;
						$scope.savebtn = true;
					}

					$scope.back = function() {
						$scope.flag = false;
						$scope.load();
					}
				});
