var postmodule = angular.module("post",[])
postmodule.controller("postCtl",function ($scope,$http) {
	
	$scope.loadnote =function () {
		console.log("start");
		
		var id = sessionStorage.lookNoteId
		$scope.posturl = localStorage.SERVERIP + "notefindone?id=" + id
		console.log($scope.posturl)
		$http({
			method: 'POST',
			url: $scope.posturl
		}).then(function successCallback(response) {
			console.log(response.data.data);
			var note = response.data.data;
			$scope.title = note.title
			$scope.context = note.context
			$scope.updateTime = note.updateTime
			//$scope.title = note.title
		}, function errorCallback(response) {
			console.log("加载失败")
		});
	}
	
	$scope.loadnote();
	
	
})