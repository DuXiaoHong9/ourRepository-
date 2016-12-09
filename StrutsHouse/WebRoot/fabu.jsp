<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
<HEAD>
<TITLE>青鸟租房 -编辑房屋信息</TITLE>
<META content="text/html; charset=utf-8" http-equiv=Content-Type><LINK 
rel=stylesheet type=text/css href="css/style.css">
<META name=GENERATOR content="MSHTML 8.00.7601.17514">
<script language="javascript" type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="js/jquery-1.8.0.js"></script></HEAD>
<script type="text/javascript">
$(function(){  
    var id = document.getElementById("district_id").value;
	$("select[name=street_id]").empty();
	$("select[name=street_id]").append($("#streetInfo_"+id).html()); 
}); 

function streets(){
	var id = document.getElementById("district_id").value;
	$("select[name=street_id]").empty();
 	$("select[name=street_id]").append($("#streetInfo_"+id).html()); 
};

</script>
<script type="text/javascript">
	function check(){
		var title = $("input[name=title]").val();
  		var type_id = $("input[name=type_id]").val();
  		var floorage = $("input[name=floorage]").val();
  		var price = $("input[name=price]").val();
  		var houseDate = $("input[name=houseDate]").val();
  		var street_id = $("SELECT[name=street_id]").val();
  		var contact = $("input[name=contact]").val();
  		var description = $("TEXTAREA[name=description]").val();
  		if(title.length<=0){
  			$("#errors").html("请输标题");
  			return false;
  		}else if(type_id==0){
  			$("#errors").html("请选择房屋类型");
  			return false;
  		}else if(floorage.length<=0){
  			$("#errors").html("请输入房屋面积");
  			return false;
  		}else if(price.length<=0){
  			$("#errors").html("请输入价格");
  			return false;
  		}else if(houseDate.length<=0){
  			$("#errors").html("请输入房产日期");
  			return false;
  		}else if(street_id==0||street_id==null){
  			$("#errors").html("请选择区县街道");
  			return false;
  		}else if(contact.length<=0){
  			$("#errors").html("请输入联系信息");
  			return false;
  		}else if(description.length<=0){
  			$("#errors").html("请输入详细信息");
  			return false;
  		}
  		return true;
	}
</script>
<BODY>
<s:if test="userLogin==null">
	<script>
		location.href="login.jsp";
	</script>
</s:if>
<DIV id=header class=wrap>
<DIV id=logo><IMG src="images/logo.gif"></DIV></DIV>
<DIV id=regLogin class=wrap>
<DIV class=dialog>
<DL class=clearfix>
  <DT style="background-color: #6699CC;"><a href="guanli" style="text-decoration: none;color: white;">返回房屋信息列表</a></DT>
  <DD class=past>编辑房屋信息</DD></DL>
<DIV class=box>
<s:form id="add_action" method="post" name="add.action" action="fabu" onsubmit="">
<DIV class=infos>
<TABLE class=field>
  <TBODY>
  <TR>
    <TD class=field>标　　题：</TD>
    <TD><INPUT id=add_action_title class=text type=text name=title value="<s:property value="hou.title"/>"> </TD></TR>
    
  <TR>
    <TD class=field>户　　型：</TD>
    <TD>
    <SELECT class=text name=type_id>
    	<s:iterator value="listType" >
    		<OPTION <s:if test="id==hou.types.id"> selected </s:if> value="<s:property value='id'/>"><s:property value="name"/></OPTION>
    	</s:iterator>
    </SELECT>
    </TD></TR>
  <TR>
    <TD class=field>面　　积：</TD>
    <TD><INPUT id=add_action_floorage class=text type=text name=floorage value="<s:property value="hou.floorrage==''?floorage:hou.floorrage" />"></TD></TR>
  <TR>
    <TD class=field>价　　格：</TD>
    <TD><INPUT id=add_action_price class=text type=text name=price value="<s:property value="hou.price"/>"> </TD></TR>
  <TR>
    <TD class=field>房产证日期：</TD>
    <TD><INPUT class="Wdate" type="text" value="<s:property value="hou.pubdate"/>" onClick="WdatePicker()" class=text name=houseDate></TD></TR>
  <TR>
    <TD class=field>位　　置：</TD>
    
    <TD>区：
    <SELECT onchange="streets()" class=text name=district_id id="district_id"> 
    	<OPTION selected="selected" value=0>请选择</OPTION>
    	<s:iterator value="listDis">
    		<OPTION <s:if test="id==hou.street.dis.id"> selected </s:if> value="<s:property value='id'/>"><s:property value="name"/></OPTION>
    	</s:iterator>
    </SELECT>
    
    <s:hidden>
    	<s:iterator value="listDis" id="district">
    		<SELECT id="streetInfo_<s:property value='id'/>" style="display: none;">
    			<OPTION value=0>请选择区县</OPTION>
    			<s:iterator value="streets">
    				<OPTION <s:if test="id==hou.street.id"> selected </s:if> value="<s:property value='id'/>"><s:property value="name"/></OPTION>
    			</s:iterator>
			</SELECT> 
    	</s:iterator>
    </s:hidden>
    	 街：
    <SELECT class=text name=street_id>
		<OPTION value=0>请选择区县</OPTION>
    </SELECT> 
    </TD>
    
    </TR>
  <TR>
    <TD class=field>联系方式：</TD>
    <TD><INPUT id=add_action_contact class=text type=text name=contact value="<s:property value="hou.contact"/>"> </TD></TR>
  <TR>
    <TD class=field>详细信息：</TD>
    <TD><TEXTAREA name=description><s:property value="hou.description"/></TEXTAREA></TD>
  </TR></TBODY></TABLE>
<div id="errors" style="color: red;text-align: center;"><s:fielderror /><s:property value="message"/></div>
<DIV class=buttons>
<!-- <INPUT value=立即发布 type="submit">  -->
<s:submit value="立即发布"></s:submit>
</DIV></DIV>
</s:form></DIV></DIV></DIV>
<DIV id=footer class=wrap>
<DL>
  <DT>青鸟租房 © 2010 北大青鸟 京ICP证1000001号</DT>
  <DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD></DL></DIV></BODY></HTML>
