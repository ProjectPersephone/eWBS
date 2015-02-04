mainApp.controller("Profile", function($scope, $cookieStore) {
	$scope.name = $cookieStore.get("name");
	$scope.projectName = $cookieStore.get("projectName");
	if ($cookieStore.get("emailId") == null) {
		window.location = "/eWBS/";
	}
	$scope.logout = function() {
		$cookieStore.remove('emailId');
		$cookieStore.remove('name');
		$cookieStore.remove('isLogged');
		$cookieStore.remove('role');
		window.location = "/eWBS/";
	}
});

loginApp.controller("LoginController", function($scope, $http, $cookieStore) {
	$scope.submit = function() {
		$http.post('/eWBS/resources/login', $scope.user).success(
				function(data, status) {
					if (status == 200) {
						alert("Login successfully.");
						$cookieStore.put("emailId", data["emailId"]);
						$cookieStore.put("name", data["name"]);
						$cookieStore.put("role", data["role"]);
						$cookieStore.put("isLogged", true);
						window.location = "/eWBS/home.html";
					} else {
						alert("Unathourised credential.");
					}
				}).error(function() {
			alert("Unathourised credential.");
		});
	}
});

mainApp.controller("ProjectController", function($scope, $location, $http,
		$cookieStore) {
	$scope.flag = false;

	if ($cookieStore.get("role") == 'admin') {
		$scope.role = true;
	} else {
		$scope.role = false;
	}

	$scope.project = {};
	load();
	function load() {
		$http.get("/eWBS/resources/project/list").success(
				function(projectList) {
					$scope.projectList = projectList;
				});
	}

	$scope.save = function() {
		$http.post('/eWBS/resources/project/add', $scope.project).success(
				function(data, status) {
					load();
					alert("Project added successfully.");
					$scope.flag = false;
				}).error(function(data, status) {
			alert("Project added successfully.");
		});
	}
	$scope.add = function() {
		$scope.flag = true;
	}

	$scope.back = function() {
		$scope.flag = false;
	}

	$scope.update = function(projectName) {
		alert(projectName);
	}

	$scope.select = function(projectName) {
		alert("Selected Project : " + projectName);
		$cookieStore.put("projectName", projectName);
		$location.reload();
	}
});

mainApp.controller("StoryController", function($scope, $http, $cookieStore) {

	$scope.flag = false;
	$scope.story = {};
	$scope.story.projectName = $cookieStore.get("projectName");
	load();
	function load() {
		$http.get("/eWBS/resources/story/list/" + $scope.story.projectName)
				.success(function(data) {
					$scope.storyList = data;
				});
	}

	$scope.save = function() {
		$http.post('/eWBS/resources/story/add', $scope.story).success(
				function(data, status) {
					load();
					alert("Story added successfully.");
					$scope.flag = false;
				}).error(function(data, status) {
			alert(data + "Story not added.");
		});
	}
	$scope.back = function() {
		$scope.flag = false;
	}
	$scope.update = function() {
		$scope.flag = false;
	}
	$scope.select = function(storyId) {
		alert(storyId);
	}
	$scope.add = function() {
		$scope.flag = true;
	}
});

mainApp
		.controller(
				"StoryTaskController",
				function($scope, $http, $cookieStore) {

					$scope.flag = false;
					$scope.storyTask = {};
					$scope.storyTask.projectName = $cookieStore
							.get("projectName");
					load();
					loadStoryIds();
					function loadStoryIds() {
						$http.get(
								"/eWBS/resources/story/list/"
										+ $scope.storyTask.projectName)
								.success(function(data) {
									$scope.storyList = data;
								});
					}

					function load() {
						$http.get(
								"/eWBS/resources/storytask/list/"
										+ $scope.storyTask.projectName)
								.success(function(data) {
									$scope.storyTaskList = data;
								}).error(function(data) {
									alert(data);
								});
					}
					$scope.save = function() {
						$http.post('/eWBS/resources/storytask/add',
								$scope.storyTask).success(
								function(data, status) {
									load();
									alert("StoryTask added successfully.");
									$scope.flag = false;
								}).error(function(data, status) {
							alert(data + "StoryTask not added.");
						});

					}
					$scope.back = function() {
						$scope.flag = false;
					}
					$scope.update = function() {
						$scope.flag = false;
					}
					$scope.select = function(storyId) {
						alert(storyId);
					}
					$scope.add = function() {
						$scope.flag = true;
					}

					$scope
							.$watch(
									'storyTask.effortActual+storyTask.effortPlanned+storyTask.workCompletedPer',
									function() {
										var storyTask = $scope.storyTask;
										storyTask.effortVariance = ((storyTask.effortActual - ((storyTask.effortPlanned * 0.01) * storyTask.workCompletedPer)) / ((storyTask.effortPlanned * 0.01) * storyTask.workCompletedPer)) * 100;
									});

					$scope
							.$watch(
									'storyTask.actualEndDate+storyTask.plannedEndDate+storyTask.plannedStartDate',
									function() {
										var storyTask = $scope.storyTask;
										storyTask.scheduleVariance = (dateDifference(
												storyTask.actualEndDate,
												storyTask.plannedEndDate) / ((dateDifference(
												storyTask.plannedEndDate,
												storyTask.plannedStartDate) + 1))) * 100;
									});

					function dateDifference(date1, date2) {
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

mainApp.controller("reviewCommentsAndBugsController", function($scope, $http,
		$cookieStore) {
	$scope.dbBugs = {};
	$scope.dbBugs.requirementsDefects = [ 0, 0, 0, 0 ];
	$scope.dbBugs.analysisDefects = [ 0, 0, 0, 0 ];
	$scope.dbBugs.designDefects = [ 0, 0, 0, 0 ];
	$scope.dbBugs.codeReviewsDefects = [ 0, 0, 0, 0 ];
	$scope.dbBugs.unitTestingDefects = [ 0, 0, 0, 0 ];
	$scope.dbBugs.integrationTestingDefects = [ 0, 0, 0, 0 ];
	$scope.dbBugs.systemTestingDefects = [ 0, 0, 0, 0 ];
	$scope.dbBugs.productionDefects = [ 0, 0, 0, 0 ];

	$scope.submit = function() {
		alert("data bug" + JSON.stringify($scope.dbBugs));
		$http.post('/eWBS/resources/defect/save', $scope.dbBugs).success(

		function(data, status) {
			if (status == 200) {
				alert("dbBugs data entered into database successfully");

			}
		});
	}
});
