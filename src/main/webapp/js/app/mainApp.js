var mainApp = angular.module("mainApp", [ 'ngRoute', 'ngCookies' ]);

var loginApp = angular.module("loginApp", [ 'ngCookies' ]);

mainApp.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/', {
		templateUrl : 'coverpage.html',
	});
	$routeProvider.when('/projects', {
		templateUrl : 'projects.html',
		controller : 'ProjectController'
	});

	$routeProvider.when('/UserAllocation/:projectName', {
		templateUrl : 'userAllocationToProject.html',
		controller : 'UserAllocationToProjectController'
	});

	$routeProvider.when('/functionalTask', {
		templateUrl : 'functionalTask.html',
		controller : 'functionalTaskController'
	});

	$routeProvider.when('/stories', {
		templateUrl : 'stories.html',
		controller : 'StoryController'
	});
	$routeProvider.when('/storytask', {
		templateUrl : 'storytask.html',
		controller : 'StoryTaskController'
	});
	$routeProvider.when('/reviewCommentsAndBugs', {
		templateUrl : 'reviewCommentsAndBugs.html',
		controller : 'reviewCommentsAndBugsController'
	});
	$routeProvider.when('/defectLeakageMatrics', {
		templateUrl : 'defectLeakageMetrics.html',
		controller : 'defectLeakageMatricsController'
	});

	$routeProvider.when('/causalAnalysis', {
		templateUrl : 'causalAnalysis.html',
		controller : 'causalAnalysisController'
	});

	$routeProvider.when('/addUser', {
		templateUrl : 'addUser.html',
		controller : 'addUserController'
	});

	$routeProvider.when('/metricReport', {
		templateUrl : 'metricReport.html',
		controller : 'metricReportController'
	});

	$routeProvider.when('/teamLeaves', {
		templateUrl : 'teamLeaves.html',
		controller : 'teamLeavesController'
	});

	$routeProvider.when('/defectPreventionPlan', {
		templateUrl : 'defectPreventionPlan.html',
		controller : 'defectPreventionPlanController'
	});

	$routeProvider.when('/user', {
		templateUrl : 'addUser.html',
		controller : 'userController'
	});

	$routeProvider.when('/projectDetails', {
		templateUrl : 'projectDetails.html',
		controller : 'projectDetailsController'
	});

	$routeProvider.when('/storyWiseMetricReport', {
		templateUrl : 'storyWiseMetricReport.html',
		controller : 'storyWiseMetricReportController'
	});
	
	$routeProvider.when('/phaseWiseMetricReport', {
		templateUrl : 'phaseWiseMetricReport.html',
		controller : 'phaseWiseMetricReportController'
	});
	
	$routeProvider.when('/resourceWiseMetricReport', {
		templateUrl : 'resourceWiseMetricReport.html',
		controller : 'resourceWiseMetricReportController'
	});

	$routeProvider.when('/changepass', {
		templateUrl : 'changepassword.html',
		controller : 'ChangePSController'
	});

	$routeProvider.otherwise({
		redirectTo : '/'
	});
} ]);

mainApp.service('HttpService', function($http, $cookieStore) {

	var URL = "/eWBS/resources/";

	this.get = function(path) {
		return $http.get(URL + path);
	}

	this.post = function(path, data) {
		return $http.post(URL + path, data);
	}

});
