mainApp
		.controller(
				"StoryTaskController",
				function($scope, $cookieStore, HttpService) {

					$scope.flag = false;
					$scope.storyTask = {};
					$scope.projectName = $cookieStore.get("projectName");

					$scope.load = function() {
						HttpService.get("storytask/list/" + $scope.projectName)
								.success(function(data) {
									$scope.storyTaskList = data;
								});
					}

					$scope.loadStoryIds = function() {
						HttpService.get("story/list/" + $scope.projectName)
								.success(function(data) {
									$scope.storyList = data;
								});
					}

					$scope.load();
					$scope.loadStoryIds();

					$scope.save = function() {
						$scope.storyTask.projectName = $scope.projectName;
						HttpService.post("storytask/save", $scope.storyTask)
								.success(function(data) {
									$scope.load();
									alert("Action successfull !!!");
									$scope.flag = false;
								}).error(function(data) {
									alert("Action unsuccessful !!!");
								});
					}

					$scope.back = function() {
						$scope.flag = false;
					}

					$scope.update = function(index) {
						$scope.storyTask = $scope.storyTaskList[index];
						$scope.flag = true;
					}
					$scope.add = function() {
						$scope.storyTask = {};
						$scope.storyTask.resource = $cookieStore.get("name");
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
										storyTask.scheduleVariance = ($scope
												.dateDifference(
														storyTask.actualEndDate,
														storyTask.plannedEndDate) / (($scope
												.dateDifference(
														storyTask.plannedEndDate,
														storyTask.plannedStartDate) + 1))) * 100;
									});
				});
