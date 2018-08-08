function BFdateStr2Lang(time){
	var time = new Date(time);
	return time.getTime() + 24*60*60*1000;	
};

function BFdateLang2Str(time){
	var time = new Date(time);
	return time.getMonth() + 1 + "/" + time.getDate() + "/" + time.getFullYear();
};

function BFdateLang2Str2(time){
	var time = new Date(time);
	var month = time.getMonth() + 1;
	var date = time.getDate();
	var year = time.getFullYear();
	return year + "/" + month + "/" + date;
};

function BFdateLang2Year(time){
	var time = new Date(time);
	var year = time.getFullYear();
	return year;
};

function BFsubstring(str,length){
	if(str.length >= length){
		return str.substring(0,length-3) + "...";
	} 
	return str;
};

function BFhandleSuccessData(data){
	
	if(!data.success){
		
		alert(data.errorCode+"  "+data.errorName+"  "+data.message);
		
		if(data.errorCode == '101'){
			window.location.href = "/login.html";
		}
		return false;
	}
	return true;
};

function BFhandleErrorData(data){
	
	alert(data.status+"  "+data.error);
};

function BFAdjustUrl(url){
	
	var currentTime = (new Date()).valueOf();
	var FNUSERCODE = localStorage.userCode;
	var FNTOKEN = localStorage.apiToken;
	console.log(FNTOKEN);
	var FNTIMESTAMP = currentTime - localStorage.timeSpace; 
	
	var pre = url;
	var bac = '';
	var paramIndex = url.indexOf("?");
	if(paramIndex != -1){
		pre = url.substring(0,paramIndex);
		bac = url.substring(paramIndex+1);
	}
	
	var signCode = pre + "?" + "FNUSERCODE=" + FNUSERCODE + "&" + "FNTOKEN=" + FNTOKEN + "&" + "FNTIMESTAMP=" + FNTIMESTAMP;
	var urlParam = pre + "?" + "FNUSERCODE=" + FNUSERCODE + "&" + "FNTIMESTAMP=" + FNTIMESTAMP;
	var sign = md5(signCode);
	
	var url = urlParam + "&FNSIGN=" + sign;
	if(bac != ''){
		url = url + "&" + bac;
	}	
	
	return localStorage.SERVICEIP + url;
};

function BFPostJson(http,url,data,successCallback){
	
	url = BFAdjustUrl(url);
	http({
        method  : 'POST',
        url   : url,
        data  : data     
	 }).success(function(data) {
		 	
	        if (BFhandleSuccessData(data)) {
	        	//alert('sucess');
	        	if(successCallback)
	        	successCallback(data);
	        } 
	        
	  }).error(function(data, status, headers, config) {
		  BFhandleErrorData(data);
	  });
	
};

function BFPostProxy(http,url,data,successCallback){
	
	url = BFAdjustUrl(url);
	http({
        method  : 'POST',
        url     : url,
        data    : data,  // pass in data as strings
        headers : { 'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8' }  // set the headers so angular passing info as form data (not request payload)
	 }).success(function(data) {
		 	
	        if (BFhandleSuccessData(data)) {
	        	//alert('sucess');
	        	if(successCallback)
	        	successCallback(data);
	        } 
	        
	  }).error(function(data, status, headers, config) {
		  BFhandleErrorData(data);
	  });
	
};

function BFGetProxy(http,url,successCallback,param){
	
	url = BFAdjustUrl(url);
	console.log(url);
	http.get(url)
    .success(function (data) {    

        if (BFhandleSuccessData(data)) {
        	if(successCallback)
	        	successCallback(data,param);
        } 
    	
    }).error(function(data, status, headers, config) {
    	  BFhandleErrorData(data);
    });
	
};

function BFFileUpload(http,url,file,successCallback){
	
	 url = BFAdjustUrl(url);
	 http({         
		 method:'POST',
		 url:url,
		 data:file,
		 transformRequest: angular.identity,  
         headers: {'Content-Type': undefined}  
	 
     }).success(function(data){  

         if (BFhandleSuccessData(data)) {
         	if(successCallback)
 	        	successCallback(data);
         } 
     	 
     }).error(function(data, status, headers, config) {   	  		
    	 BFhandleErrorData(data);
     });  
};

function BFLoadList($scope,$http,url){
	        
			$scope.list = {};
			$scope.loadList = function() {
				//var url = '/employee/euc/list?restaurantId=' + restaurantId;
				console.log(url);
				BFGetProxy($http, url, function(data) {
					console.dir(JSON.stringify(data.result.data));
					$scope.list = data.result.data;
				});
			};
			$scope.loadList();			
		
}