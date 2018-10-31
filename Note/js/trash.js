var trashmodule = angular.module("trash", []);
trashmodule.controller("trashCtl", function($scope,$http) {
	$scope.lodeData = function() {
		
		$scope.listurl = localStorage.SERVERIP + "noteslist?userid="sessionStorage.userId+"&statusid="+1
		console.log($scope.listurl)
		$http({
			method: 'POST',
			url: $scope.listurl
		}).then(function successCallback(response) {
			console.log(response.data.data);
			if (response.code == 0) {
				
			}
			
		}, function errorCallback(response) {
			console.log("加载失败")
		});
		
	}
	$scope.lodeData()
	
	
	$scope.addnote = function  () {
		var per = {}
		per.userid=sessionStorage.userId
		per.title = $scope.title
		per.context= $scope.context
		
		$scope.addurl = localStorage.SERVERIP + "noteadd"
		console.log($scope.addurl)
		console.log(per)
		$http({
			method: 'POST',
			data:per,
			url: $scope.addurl
		}).then(function successCallback(response) {
			console.log(response.data.data);
			if (response.code == 0) {
				window.location = "blog-1.html"
			}
			
		}, function errorCallback(response) {
			console.log("加载失败")
		});
	}
	
	

});