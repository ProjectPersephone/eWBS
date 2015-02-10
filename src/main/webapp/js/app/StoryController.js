mainApp.controller("StoryController", function($scope, $cookieStore,
		HttpService) {

	$scope.flag = false;
	$scope.story = {};

	$scope.load = function() {
		HttpService.get("story/list/" + $cookieStore.get("projectName"))
				.success(function(data) {
					$scope.storyList = data;
				});
	}

	$scope.load();

	$scope.save = function() {
		$scope.story.projectName = $cookieStore.get("projectName");
		HttpService.post("story/save", $scope.story).success(function(data) {
			$scope.load();
			alert("Action Successfull !!!");
			$scope.flag = false;
		}).error(function(data, status) {
			alert("Action unsuccessfull !!!");
		});
	}
	$scope.back = function() {
		$scope.flag = false;
	}

	$scope.update = function(index) {
		$scope.story = $scope.storyList[index];
		$scope.flag = true;
	}
	$scope.add = function() {
		$scope.story = {};
		$scope.flag = true;
	}
});
