<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
<HEAD><TITLE><s:text name="regs.page"></s:text> </TITLE>
<META content="text/html; charset=utf-8" http-equiv=Content-Type><LINK 
rel=stylesheet type=text/css href="css/style.css">
<META name=GENERATOR content="MSHTML 8.00.7601.17514">
<script type="text/javascript" src="js/checkName.js"></script></HEAD>
<script type="text/javascript" src="js/jquery-1.8.0.js"></script>
<script type="text/javascript">
  	
  	function checkRegist(){
  		var name = $("input[id=name]").val();
  		var fPwd = $("input[id=pwd]").val();
  		var sPwd = $("input[id=rpwd]").val();
  		var tel = $("input[id=tel]").val();
  		var uname = $("input[id=uname]").val();
  		if(name.length<3){
  			$("#errors").html("用户名长度至少为3");
  			return false;
  		}else if(fPwd.length<=0){
  			$("#errors").html("请输入密码");
  			return false;
  		}else if(fPwd!=sPwd){
  			$("#errors").html("两次输入的密码不一致");
  			return false;
  		}else if(tel.length<=0){
  			$("#errors").html("请输入电话号码");
  			return false;
  		}else if(uname.length<=0){
  			$("#errors").html("请输入用户姓名");
  			return false;
  		}
  		return true;
  	}
  
  	
  	</script>
<BODY>
<DIV id=header class=wrap>
<DIV id=logo><IMG src="images/logo.gif"></DIV></DIV>
<DIV id=regLogin class=wrap>
<DIV class=dialog>
<DL class=clearfix>
  <DT style="background-color: #6699CC;"><a href="login.jsp" style="text-decoration: none;color: white;"><s:text name="regs.logi" /></a></DT>
  <DD class=past><s:text name="regs.title" /> </DD></DL>
<DIV class=box>
<s:form action="Sregister" method="post" onsubmit="return checkRegist();">
<DIV class=infos>
<TABLE class=field>
  <TBODY>
  <TR>
    <TD class=field><s:text name="tetname" />：</TD>
    <TD><s:textfield onkeyup="checkName1();" class="text name" id="name" type="text" name="user.name" /> </TD></TR>
  <TR>
    <TD class=field><s:text name="tetpassword" />：</TD>
    <TD><INPUT class="text pwd" id="pwd" type=password name=user.password></TD></TR>
  <TR>
    <TD class=field><s:text name="tetrepassword" />：</TD>
    <TD><INPUT class="text rpwd" id="rpwd" type=password name=repassword> </TD></TR>
  <TR>
    <TD class=field><s:text name="tetphone" />：</TD>
    <TD><INPUT class="text tel" id="tel" type=text name=user.telephone> </TD></TR>
  <TR>
    <TD class=field><s:text name="tetusername" />：</TD>
    <TD><INPUT class="text uname" id="uname" type=text name=user.username> </TD></TR></TBODY></TABLE>
    <div id="errors" style="color: red;text-align: center;"><s:fielderror /> <s:property value="name"/><s:property value="message"/></div>
<DIV class=buttons>
<!-- <INPUT value=立即注册 type=submit > -->
<s:submit value="%{getText('submit')}"></s:submit>
</DIV></DIV>
</s:form></DIV></DIV></DIV>
<DIV id=footer class=wrap>
<DL>
  <DT>青鸟租房 © 2010 北大青鸟 京ICP证1000001号</DT>
  <DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD></DL></DIV></BODY></HTML>
