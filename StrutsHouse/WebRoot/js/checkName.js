  	var xmlHttpRequest;
	//����XMLResquest����
	function createHttp(){
		var xmlHttpRequest;
		if(window.XMLHttpRequest){//����true˵�����°汾��IE�����������
			xmlHttpRequest = new XMLHttpRequest();
		}
		//������������
		if(window.ActiveXObject){
			xmlHttpRequest=new ActiveXObject("Microsoft.XMLHTTP");
			//�����֧��Microsoft.XMLHTTP������xmlHttp�������ɹ�
			if(!xmlHttpRequest){
				xmlHttpRequest=new ActiveXObject("Msxml2.XMLHTTP");
			}
		};
		return xmlHttpRequest;
	};
  	
  	//�ص����� callback�д����������Ӧ�Ĺؼ�����
	function callback(){
		//readyState �ĳ���ֵ	0----δ��ʼ��	1----��ʼ��������	2----���������	3----��ʼ��ȡ��Ӧ	4----��ȡ��Ӧ����
		//status	   �ĳ���ֵ	200--��ȷ����       404--û���ҵ����ʶ���
// 		alert(xmlHttpRequest.readyState+"+readyState");
// 		alert(xmlHttpRequest.status+"+status");
		if(xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200){
			//responseText	���ı���ʽ��ȡ��Ӧֵ	responseXML	��XML��ʽ��ȡ��Ӧֵ�����ҽ�����DOM���󷵻�
			var result = xmlHttpRequest.responseText;
//			$("#errors").html(result);
//			var user = $.parseJSON(result);
//			$("#errors").html(user.name);
			//�����������
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
  		//��ȡ�û�����
		var name = $("input[id=name]").val();
		if(name!=null || name.equals("")){
			xmlHttpRequest = createHttp();
			//���ûص�����
			xmlHttpRequest.onreadystatechange = callback;
			//3.��ʼ��XMLHttpRequest���
			var url = "regsCheckName?name="+name;//��������ַ
// 			var url = "regscheck?name="+name;//��������ַ
			xmlHttpRequest.open("GET",url,true);
			//4.��������   ȡ���� method ��ֵ    post����Ϊ��      get��Ϊnull
			//send()  �����Ѿ�����url����  ���  send() ��������ֵ  �ڲ�ͬ�������������ܴ��ڲ���������
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
  	
