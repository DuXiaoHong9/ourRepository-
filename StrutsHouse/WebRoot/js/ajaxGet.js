//1.����XMLResquest����
var xmlHttpRequest;
if(window.XMLHttpRequest){//����true˵�����°汾��IE�����������
	xmlHttpRequest = new XMLHttpRequest();
}else{
	xmlHttpRequest = new ActiveXOject("Microsoft.XMLHTTP");
};
//2.���ûص�����
xmlHttpRequest.onreadystatechange = callBack;




//3.��ʼ��XMLHttpRequest���
var url = "URL?name=du";//��������ַ
xmlHttpRequest.open("GET",url,true);
//4.��������   ȡ���� method ��ֵ    post����Ϊ��      get��Ϊnull
//send()  �����Ѿ�����url����  ���  send() ��������ֵ  �ڲ�ͬ�������������ܴ��ڲ���������
xmlHttpRequest.send(null);





//�ص����� callback�д�����������Ӧ�Ĺؼ�����
function callback(){
	//readyState �ĳ���ֵ	0----δ��ʼ��	1----��ʼ��������	2----���������	3----��ʼ��ȡ��Ӧ	4----��ȡ��Ӧ����
	//status	   �ĳ���ֵ	200--��ȷ����       404--û���ҵ����ʶ���
	if(xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200){
		//responseText	���ı���ʽ��ȡ��Ӧֵ	responseXML	��XML��ʽ��ȡ��Ӧֵ�����ҽ�����DOM���󷵻�
		var result = xmlHttpRequest.responseText;
		
	}
};