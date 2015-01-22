var mainApp = angular.module("mainApp", [ 'ngRoute', 'ngCookies' ]);

var loginApp = angular.module("loginApp", [ 'ngCookies' ]);

mainApp.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/', {
		templateUrl : 'projects.html',
		controller : 'ProjectController'
	});
	$routeProvider.when('/projects', {
		templateUrl : 'projects.html',
		controller : 'ProjectController'
	});
	$routeProvider.otherwise({
		redirectTo : '/'
	});
} ]);
