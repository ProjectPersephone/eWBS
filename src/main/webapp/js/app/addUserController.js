mainApp.controller("addUserController", function($scope, $cookieStore,
		HttpService) {

	$scope.flag = false;
	$scope.savebtn = true;
	$scope.showLabel = false;
	$scope.user = {};
	$scope.user.project=[];
	var projectText="";
	
	if ($cookieStore.get("role") == 'Admin') {
		$scope.role = true;
	} else {
		$scope.role = false;
	}

	$scope.load = function() {
		HttpService.get("userController/users").success(function(data) {
			$scope.userList = data;
			for(var i=0;i<$scope.userList.length;i++)
				{
				projectText="";
			 		for(var j=0;j<$scope.userList[i].project.length;j++)
			 			{
			 				projectText+=$scope.userList[i].project[j];
			 				projectText+=", ";
			 			}
			 		projectText=projectText.substring(0,projectText.length-2);
			 		$scope.userList[i].project=projectText;
				}
		});
	}

	$scope.load();

	$scope.save = function() {
		$scope.showLabel = true;
		$scope.user.project=[$scope.user.project];

		HttpService.post('userController/user', $scope.user).success(
				function(data, status) {
					$scope.load();
					alert("User added successfull !!!");
					$scope.flag = false;
					$scope.showLabel = false;
				}).error(function(data) {
			alert("User adding unsuccessfull !!! ");
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
					alert("User updated successfull !!!");
					$scope.flag = false;
					$scope.savebtn = true;
				}).error(function(data) {
			alert("User adding unsuccessfull !!!");
		});
	}

	$scope.add = function() {
		$scope.user = {};
		$scope.flag = true;
		$scope.savebtn = true;
		HttpService.get("project/list").success(function(projectList) {
			$scope.projectList = projectList;
			//alert(projectList);
		});
		//alert(JSON.stringify($scope.user.project));
	}

	$scope.back = function() {
		$scope.flag = false;
	}

});
