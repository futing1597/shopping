/**
 * 
 */

var myApp = angular.module('myApp', [ 'ngRoute' ]);
myApp.controller('TextController', function($scope) {
	$scope.someText = '测试显示内容';
});
function emailRouteConfig($routeProvider) {
	$routeProvider.when('/', {
		controller : ListController,
		templateUrl : 'html/email/list.html'
	}).when('/view/:id', {
		controller : DetailController,
		templateUrl : 'html/email/detail.html'
	}).otherwise({
		redirectTo : '/'
	});
}
myApp.config(emailRouteConfig);
