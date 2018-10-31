$('.form').find('input, textarea').on('keyup blur focus', function (e) {
  
  var $this = $(this),
      label = $this.prev('label');

	  if (e.type === 'keyup') {
			if ($this.val() === '') {
          label.removeClass('active highlight');
        } else {
          label.addClass('active highlight');
        }
    } else if (e.type === 'blur') {
    	if( $this.val() === '' ) {
    		label.removeClass('active highlight'); 
			} else {
		    label.removeClass('highlight');   
			}   
    } else if (e.type === 'focus') {
      
      if( $this.val() === '' ) {
    		label.removeClass('highlight'); 
			} 
      else if( $this.val() !== '' ) {
		    label.addClass('highlight');
			}
    }

});

$('.tab a').on('click', function (e) {

e.preventDefault();

$(this).parent().addClass('active');
$(this).parent().siblings().removeClass('active');

target = $(this).attr('href');

$('.tab-content > div').not(target).hide();

$(target).fadeIn(600);

});
/////////////////////////////////////////////////////////////////////////////////////////////////
///angular
var postmodule = angular.module("login",[])
postmodule.controller("loginCtl",function ($scope,$http) {
	$scope.msg = "免费注册"
	$scope.logmsg="Welcom To MyNote"
		
		
		$scope.regist = function() {

			console.log($scope.rUsername);
			console.log($scope.rPasswd);
			
			if ($scope.rUsername) {
				if ($scope.rPasswd) {
					if ($scope.rRepasswd&&($scope.rPasswd==$scope.rRepasswd)) {
						$scope.registUrl = localStorage.SERVERIP + "adduser?username="+$scope.rUsername +"&password="+$scope.rPasswd
						console.log($scope.registUrl)
//						var per = {}
//						per.username= $scope.rUsername 
//						per.password = $scope.rPasswd
						$http({
							method: 'POST',
//							data:per,
							url: $scope.registUrl
						}).then(function successCallback(response) {
							console.log(response.data);
							if (response.data.code==0) {
								sessionStorage.userId = response.data.data.id;
								alert("注册成功,直接登录")
							    window.location = "index.html"
							} else{
								alert(response.data.msg)
							}
						    
						}, function errorCallback(response) {
							console.log("加载失败")
						});
					} else{
						$scope.msg = "两次输入密码不一致"
						console.log("两次输入密码不一致")
					}
				} else{
				   $scope.msg = "请设置密码"
				   console.log("请设置密码")
				}
			}else{
				$scope.msg = "用户名不能为空"
				 console.log("用户名不能为空")
			}
		}
		$scope.login = function  () {
			
			
			if($scope.lUsername){
				if ($scope.lPasswd) {
					$scope.loginUrl = localStorage.SERVERIP+"login?username="+$scope.lUsername+"&password="+$scope.lPasswd
					$http({
						method: 'POST',
						url: $scope.loginUrl
					}).then(function successCallback(response) {
						console.log(response.data);
						if(response.data.code == 0) {
							sessionStorage.userId = response.data.data.id;
							console.log(response.data)
							
						} else {
							alert(response.data.msg)
						}
					
					}, function errorCallback(response) {
						console.log("加载失败")
					});
				} else{
					$scope.msg = "请输入密码"
				}
			}else{
				$scope.msg = "请输入用户名"
			}
		}
		
		
	
	
})