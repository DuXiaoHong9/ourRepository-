<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
<HEAD>
<TITLE>青鸟租房 - 用户管理</TITLE>
<META content="text/html; charset=utf-8" http-equiv=Content-Type><LINK 
rel=stylesheet type=text/css href="css/style.css">
<META name=GENERATOR ></HEAD>
<script type="text/javascript" src="js/jquery-1.8.0.js"></script>
<script type="text/javascript">
	function del(){
		if(confirm("确认删除么？")){
			return true;
		}else{
			return false;
		}
	}
</script>
<BODY>
<s:if test="userLogin==null">
	<script>
		location.href="login.jsp";
	</script>
</s:if>
<s:if test="yesorno == null">
	<script>
		location.href="guanli";
	</script>
</s:if>
<DIV id=header class=wrap>
<DIV id=logo><IMG src="images/logo.gif"></DIV>
<DIV class=search>
<LABEL class="ui-green searchs"><a href="list" title="">所有房屋列表</a></LABEL> 
<LABEL class="ui-green searchs"><a href="info" title="">发布房屋信息</a></LABEL> 
<LABEL class=ui-green><INPUT onclick='document.location="exit"' value="退       出" type=button name=search></LABEL> 
</DIV></DIV>
<DIV class="main wrap">
<DIV id=houseArea>
<TABLE class=house-list>
  <TBODY>
	
  <s:iterator value="listUhouse" id="house">
  <TR>
    <TD class=house-thumb><span><A href="houView?houseId=<s:property value='id'/>" target="_blank"><img src="images/thumb_house.gif" width="100" height="75" alt=""></a></span></TD>
    <TD>
      <DL>
        <DT><A href="houView?houseId=<s:property value='id'/>" target="_blank"><s:property value="title"/></A></DT>
        <DD><s:property value="street.dis.name"/><s:property value="street.name"/>,<s:property value="floorrage"/>平米<BR>联系方式：<s:property value="contact"/></DD>
      </DL>
    </TD>
    <TD class=house-type><a href="update?houseId=<s:property value='id'/>" ><LABEL class=ui-green><INPUT onclick=update(46) value="修    改" type=button name=search></LABEL></a></TD>
    <TD class=house-price><a href="delete?houseId=<s:property value='id' />" onclick="return del();"><LABEL class=ui-green><INPUT value="删    除" type=button name=search></LABEL></a></TD>
    </TR>
  </s:iterator>  
    </TBODY></TABLE></DIV>
<DIV class=pager>
</DIV></DIV>
<DIV id=footer class=wrap>
<DL>
  <DT>青鸟租房 © 2010 北大青鸟 京ICP证1000001号</DT>
  <DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD></DL></DIV></BODY></HTML>
