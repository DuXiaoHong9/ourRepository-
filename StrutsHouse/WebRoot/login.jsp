<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
<HEAD><TITLE>青鸟租房 - 用户登录</TITLE>
<META content="text/html; charset=utf-8" http-equiv=Content-Type><LINK 
rel=stylesheet type=text/css href="css/style.css">
<META name=GENERATOR content="MSHTML 8.00.7601.17514">
<script type="text/javascript" src="js/jquery-1.8.0.js"></script>
</HEAD>
<script type="text/javascript">
  	function check(){
  		var name = $("input[id=user_name]").val();
  		var pwd = $("input[id=user_password]").val();
  		if(name.length<=0){
  			$("#errors").html("请输入用户名");
  			return false;
  		}else if(pwd.length<=0){
  			$("#errors").html("请输入密码");
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
<DIV class=box>
<H4>用户登录</H4>
<s:form id="user" action="SLoginAction" method="post" onsubmit="return check();">
<DIV class=infos>
<TABLE class=field>
  <TBODY>
  <TR>
    <TD colSpan=2 style="color: red;"></TD></TR>
  <TR>
    <TD class=field>用 户 名：</TD>
    <TD><!-- <input type="text" class="text" name="name" /> -->
<!--     	<INPUT id=user_name class=text type=text name=user.name>  -->
    	<s:textfield id="user_name" class="text" name="user.name"></s:textfield>
    </TD>
      </TR>
  <TR>
    <TD class=field>密　　码：</TD>
    <TD>
    <!-- <input type="password" class="text" name="password" /> -->
<!--     	<INPUT id=user_password class=text type=password >  -->
    	<s:password id="user_password" class="text" name="user.password"></s:password>
    </TD>
      </TR>
</TBODY>
</TABLE>
<div id="errors" style="color: red;text-align: center;"><s:fielderror /><s:property value="message"/></div>
<DIV class=buttons> 
<!-- <input type="submit" value="登录" /> -->
<s:submit value="登陆"></s:submit>
<INPUT onclick='document.location="regs.jsp"' value=注册 type=button> 
<a style="color: red;" href="list">游客？</a>
</DIV>
</DIV>
</s:form>
</DIV>
</DIV>
</DIV>
<DIV id=footer class=wrap>
<DL>
  <DT>青鸟租房 © 2010 北大青鸟 京ICP证1000001号</DT>
  <DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD></DL></DIV></BODY></HTML>
