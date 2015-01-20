var mainApp = angular.module("mainApp", [ 'ngRoute' ]);

mainApp.service('UserService', function() {
	var user = {
		username : '',
		resource : '',
		role : '',
		isLogged : 'false'
	};

	this.getUser = function() {
		return user;
	}

	this.setUserField = function(username1, resource1, role1, isLogged1) {
		user.username = username1;
		user.resource = resource1;
		user.role = role1;
		user.isLogged = isLogged1;
	}
});


mainApp.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/', {
		templateUrl : 'login.html',
		controller : 'LoginController'
	});
	$routeProvider.when('/projects', {
		templateUrl : 'projects.html',
		controller : 'ProjectController'
	});
	$routeProvider.otherwise({
		redirectTo : '/'
	});
} ]);
