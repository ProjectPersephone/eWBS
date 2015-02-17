mainApp
		.controller(
				"UserAllocationToProjectController",
				function($scope, $cookieStore, $routeParams, HttpService) {
					$scope.flag = false;
					$scope.savebtn = true;
					$scope.showLabel = false;
					$scope.selection = [];
					$scope.user = {};
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
									$scope.user = $scope.otherUsers[j];
									$scope.user.project
											.push($routeParams.projectName);
									
									HttpService.post(
											"userController/updateUser",
											$scope.user).success(
											function(data) {
												total++;
												if (total == $scope.selection.length) {
													$scope.next();
												}
											}).error(function(data) {
										alert("Action unsuccessfull !!!");
									});
								}
							}
						}
						$scope.next = function() {
								alert(total);
								alert("Records Updated...");
								$scope.back();
								$scope.load();
						}
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
