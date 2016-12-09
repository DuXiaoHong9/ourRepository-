//1.创建XMLResquest对象
var xmlHttpRequest;
if(window.XMLHttpRequest){//返回true说明是新版本的IE或其他浏览器
	xmlHttpRequest = new XMLHttpRequest();
}else{
	xmlHttpRequest = new ActiveXOject("Microsoft.XMLHTTP");
};
//2.设置回调函数
xmlHttpRequest.onreadystatechange = callBack;




//3.初始化XMLHttpRequest组件
var url = "URL";//服务器地址
xmlHttpRequest.open("POST",url,true);
xmlHttpRequest.setRequstHeader("Content-Type","application/x-www-form-urlencoded");
//4.发送请求   取决于 method 的值    post：不为空      get：为null
//send()  参数已经放在url后面  如果  send() 方法不赋值  在不同的浏览器下面可能存在不兼容问题
var data = "name="+"123";
xmlHttpRequest.send(data);



//回调函数 callback中处理服务器相应的关键代码
function callback(){
	//readyState 的常用值	0----未初始化	1----开始发送请求	2----请求发送玩成	3----开始读取响应	4----读取响应结束
	//status	   的常用值	200--正确返回       404--没有找到访问对象
	if(xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200){
		//responseText	以文本形式获取响应值	responseXML	以XML形式获取响应值，并且解析成DOM对象返回
		var result = xmlHttpRequest.responseText;
		
	}
};
