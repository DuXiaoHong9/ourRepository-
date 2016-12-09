  	var xmlHttpRequest;
	//创建XMLResquest对象
	function createHttp(){
		var xmlHttpRequest;
		if(window.XMLHttpRequest){//返回true说明是新版本的IE或其他浏览器
			xmlHttpRequest = new XMLHttpRequest();
		}
		//解决浏览器兼容
		if(window.ActiveXObject){
			xmlHttpRequest=new ActiveXObject("Microsoft.XMLHTTP");
			//如果不支持Microsoft.XMLHTTP参数。xmlHttp创建不成功
			if(!xmlHttpRequest){
				xmlHttpRequest=new ActiveXObject("Msxml2.XMLHTTP");
			}
		};
		return xmlHttpRequest;
	};
  	
  	//回调函数 callback中处理服务器相应的关键代码
	function callback(){
		//readyState 的常用值	0----未初始化	1----开始发送请求	2----请求发送玩成	3----开始读取响应	4----读取响应结束
		//status	   的常用值	200--正确返回       404--没有找到访问对象
// 		alert(xmlHttpRequest.readyState+"+readyState");
// 		alert(xmlHttpRequest.status+"+status");
		if(xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200){
			//responseText	以文本形式获取响应值	responseXML	以XML形式获取响应值，并且解析成DOM对象返回
			var result = xmlHttpRequest.responseText;
//			$("#errors").html(result);
//			var user = $.parseJSON(result);
//			$("#errors").html(user.name);
			//解析获得数据
			var json=eval("("+result+")");
			var tishi = "";
			for ( var i = 0; i < json.length; i++) {
				tishi = tishi + json[i];
			}
			$("#errors").html(tishi);
	//		$("#errors").html(result);
			}
	};
	
  	function checkName1(){
  		//获取用户输入
		var name = $("input[id=name]").val();
		if(name!=null || name.equals("")){
			xmlHttpRequest = createHttp();
			//设置回调函数
			xmlHttpRequest.onreadystatechange = callback;
			//3.初始化XMLHttpRequest组件
			var url = "regsCheckName?name="+name;//服务器地址
// 			var url = "regscheck?name="+name;//服务器地址
			xmlHttpRequest.open("GET",url,true);
			//4.发送请求   取决于 method 的值    post：不为空      get：为null
			//send()  参数已经放在url后面  如果  send() 方法不赋值  在不同的浏览器下面可能存在不兼容问题
			xmlHttpRequest.send(null);
		};
  	};
  	
  	
  	
  	function checkName2(){
  		var name = $("input[id=name]").val();
  		var data = "name="+name;
  		$.ajax({
  			url:"regsCheckName",
  			type:"GET",
  			data:data,
  			async:true,
  			dataType:"text",
  			success:function(result){
  	           var obj=eval("("+result+")");
  	           var tishi=" ";
  	           for(var i in obj){
  	        	 tishi = tishi + obj[i].name;
//  					alert("ID:"+obj[i].flag+"\nName:"+obj[i].msg);
  	             }
  				$("#errors").html(tishi);
  				
  			}
  		});
  	};
  	
  	function checkName3(){
  		var name = $("input[id=name]").val();
  		var data = "name="+name;
  		$.get("regsCheckName",data,function(result){
  			$("#errors").html(result);
  		});
  	};
  	
  	function checkName4(){
  		var name = $("input[id=name]").val();
  		var data = "name="+name;
  		$.post("regsCheckName",data,function(result){
  			var res = $.parseJSON(result);
  			$("#errors").html(res.name);
  		});
  	};
  	
  	function checkName5(){
  		var name = $("input[id=name]").val();
  		var data = "name="+name;
  		$("#errors").load("regsCheckName",data);
  	};
  	
