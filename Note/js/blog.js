var notesModule = angular.module("notes", []);
notesModule.controller("noteCtl", function($scope, $http) {
	 sessionStorage.userId = 8
	$scope.lodeData = function() {

		$http({
			method: 'POST',
			url: 'http://127.0.0.1:8080/noteslist?userid=' + sessionStorage.userId+'&statusid='+0
		}).then(function successCallback(response) {
			console.log(response.data.data);
			$scope.notes = response.data.data;
		}, function errorCallback(response) {
			console.log("加载失败")
		});
//		console.log("start")
//		$scope.url = 'http://127.0.0.1:8080/noteslist?userid=' + sessionStorage.userId+'&statusid='+0
//		PostProxy($http,$scope.url,function(data){
//			console.log(data.data);
//		});
		
	};
	$scope.lodeData();
	$scope.lookNote = function  (id) {
		sessionStorage.lookNoteId = id;
		window.location = "post.html";
	}
	$scope.updateTime = function(updateTime) {
		return BFdateLang2Str2(updateTime);
	}
	$scope.show = function(id) {
		$scope.rmid = id
		document.getElementById('light').style.display = 'block';
		document.getElementById('fade').style.display = 'block'
	}
	$scope.hide = function() {
		document.getElementById('light').style.display = 'none';
		document.getElementById('fade').style.display = 'none'
	}
	$scope.addnote = function  () {
		window.location = "edit.html";
	}
	$scope.sure = function() {
		//http://127.0.0.1:8080/dropnote
		$http({
			method: 'POST',
			url: 'http://127.0.0.1:8080/dropnote?id=' + $scope.rmid
		}).then(function successCallback(response) {
			console.log(response.data.data);
			if(response.data.data == 1) {
				$scope.lodeData();
				alert("删除成功")
			}
		}, function errorCallback(response) {
			console.log("加载失败")
		});

		$scope.hide();
	}

});