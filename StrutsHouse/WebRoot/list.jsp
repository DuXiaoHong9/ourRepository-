<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
<HEAD><TITLE>青鸟租房 - 首页</TITLE>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">    
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<LINK rel=stylesheet type=text/css href="css/style.css">
<META name=GENERATOR content="MSHTML 8.00.7601.17514"></HEAD>
<BODY>
<DIV id=header class=wrap>
<DIV id=logo><IMG src="images/logo.gif"></DIV>
<DIV class=search>
<s:if test="isGo == null">
	<script>
		location.href="list";
	</script>
</s:if>
<s:if test="users != null">
	<a href="guanli" title="">返回个人页面</a>
	&nbsp;&nbsp;&nbsp;
	<a href="exit" title="">注销</a>
</s:if>
<s:else>
	<a href="login.jsp" title="">登录</a>
</s:else>
</DIV></DIV>
<DIV id=navbar class=wrap>
<DL class="search clearfix">
  <DT>
  <UL>
    <LI class=bold>房屋信息</LI>
    <LI>标题：
    <form action="list?types=<s:property value="tid"/>&streets=<s:property value="sid"/>&Floorrage=<s:property value="Floorrage"/>&Price=<s:property value="Price"/>" method="post">
	    <INPUT class=text type=text name=title /> 
	    <LABEL class=ui-blue>
	    	<INPUT  value=搜索房屋 type="submit" name=search />
	    </LABEL> 
    </form>
    </LI>
    </UL>
    </DT>
  <DD>
  <UL>
    <LI class=first>价格 </LI>
    <LI>
    <SELECT name=Price onchange="javascript:location.href='list?title=<s:property value="title"/>&types=<s:property value="tid"/>&streets=<s:property value="sid"/>&Floorrage=<s:property value="Floorrage"/>&Price='+this.value+''"> 
      <OPTION selected value="0-0">不限</OPTION> 
      <OPTION <s:if test="Price == '0-200'"> selected="selected" </s:if> value=0-200>200元以下</OPTION> 
      <OPTION <s:if test="Price == '200-400'"> selected="selected" </s:if> value=200-400>200元-400元</OPTION> 
      <OPTION <s:if test="Price == '400-1000000'"> selected="selected" </s:if> value=400-1000000>400元以上</OPTION>
      </SELECT> </LI></UL></DD>
  <DD>
  <UL>
    <LI class=first>房屋位置</LI>
    <LI>
    <SELECT id=street name="streets" onchange="javascript:location.href='list?title=<s:property value="title"/>&types=<s:property value="tid"/>&Price=<s:property value="Price"/>&Floorrage=<s:property value="Floorrage"/>&streets='+this.value+''"> 
    <OPTION selected  value="-1">不限</OPTION>
	<s:iterator value="listStr">
    		<OPTION <s:if test="id == sid"> selected </s:if> value="<s:property value='id'/>"><s:property value="name"/></OPTION>
    </s:iterator>
    </SELECT> 
      </LI></UL></DD>
  <DD>
  <UL>
    <LI class=first>房型</LI>
    <LI>
    <SELECT name=types onchange="javascript:location.href='list?title=<s:property value="title"/>&streets=<s:property value="sid"/>&Price=<s:property value="Price"/>&Floorrage=<s:property value="Floorrage"/>&types='+this.value+''" > 
	    <OPTION selected value="-1">不限</OPTION> 
	    <s:iterator value="listType">
    		<OPTION <s:if test="id == tid"> selected </s:if> value="<s:property value='id'/>"><s:property value="name"/></OPTION>
    	</s:iterator>
    </SELECT> 
  </LI></UL></DD>
  <DD>
  <UL>
    <LI class=first>面积 </LI>
    <LI><SELECT name=Floorrage onchange="javascript:location.href='list?title=<s:property value="title"/>&types=<s:property value="tid"/>&streets=<s:property value="sid"/>&Price=<s:property value="Price"/>&Floorrage='+this.value+''"> 
    	<OPTION selected value="0-0">不限</OPTION> 
    	<OPTION <s:if test="Floorrage == '0-40'"> selected="selected" </s:if>  value=0-40>40以下</OPTION> 
    	<OPTION <s:if test="Floorrage == '40-500'"> selected="selected" </s:if>  value=40-500>40-500</OPTION> 
    	<OPTION <s:if test="Floorrage == '500-1000000'"> selected="selected" </s:if>  value=500-1000000>500以上</OPTION>
    </SELECT> </LI></UL></DD></DL></DIV>
<DIV class="main wrap">
<TABLE class=house-list>
  <TBODY>
  
  <s:iterator value="pagehouse">
	  <TR>
	    <TD class=house-thumb><span><A href="houView?houseId=<s:property value='id'/>" target="_blank"><img src="images/thumb_house.gif" width="100" height="75" alt=""></a></span></TD>
	    <TD>
	     <DL>
        <DT><A href="houView?houseId=<s:property value='id'/>" target="_blank"><s:property value="title"/></A></DT>
        <DD><s:property value="street.dis.name"/><s:property value="street.name"/>,<s:property value="floorrage"/>平米<BR>联系方式：<s:property value="contact"/></DD>
      </DL>
	    </TD>
	    <TD class=house-type><s:property value="types.name"/></TD>
	    <TD class=house-price><SPAN><s:property value="price"/></SPAN>元/月</TD>
	  </TR>
  </s:iterator>


  </TBODY>
  </TABLE>
<DIV class=pager>
<UL>
  <LI class=current><A href="list?title=<s:property value="title"/>&pageIndex=1&types=<s:property value="tid"/>&streets=<s:property value="sid"/>&Price=<s:property value="Price"/>&Floorrage=<s:property value="Floorrage"/>">首页</A></LI>
  <LI><A href="list?title=<s:property value="title"/>&pageIndex=<s:property value="pageIndexs-1<=0?1:pageIndexs-1"/>&types=<s:property value="tid"/>&streets=<s:property value="sid"/>&Price=<s:property value="Price"/>&Floorrage=<s:property value="Floorrage"/>">上一页</A></LI>
  <LI><A href="list?title=<s:property value="title"/>&pageIndex=<s:property value="pageIndexs+1>=totalPageCount?totalPageCount:pageIndexs+1"/>&types=<s:property value="tid"/>&streets=<s:property value="sid"/>&Price=<s:property value="Price"/>&Floorrage=<s:property value="Floorrage"/>">下一页</A></LI>
  <LI><A href="list?title=<s:property value="title"/>&pageIndex=<s:property value="totalPageCount"/>&types=<s:property value="tid"/>&streets=<s:property value="sid"/>&Price=<s:property value="Price"/>&Floorrage=<s:property value="Floorrage"/>">末页</A></LI></UL><SPAN 
class=total><s:property value="totalPageCount"/>/<s:property value="pageIndexs"/>页</SPAN> </DIV></DIV>
<DIV id=footer class=wrap>
<DL>
  <DT>青鸟租房 © 2010 北大青鸟 京ICP证1000001号</DT>
  <DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD></DL></DIV></BODY></HTML>
