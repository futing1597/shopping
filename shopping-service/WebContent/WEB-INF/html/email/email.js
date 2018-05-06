/**
 * 
 */

function ListController($scope, $http) {
	$scope.pageIndex = 1;
	$scope.pageSize = 10;
	var data = {
		pageIndex : $scope.pageIndex,
		pageSize : $scope.pageSize
	};
	$http({
		method : "get",
		params : data,
		url : "/EmailEvent/findList"
	}).success(function(data) {
		$scope.messages = data;
	}).error(function(data) {
		alert("数据加载失败");
	});
}
function DetailController($scope, $routeParams, $http) {
	var data = {
		id : $routeParams.id
	};
	$http({
		method : "get",
		params : data,
		url : "/EmailEvent/findById"
	}).success(function(data) {
		$scope.message = data;
	}).error(function(data) {
		alert("数据加载失败");
	});
}
