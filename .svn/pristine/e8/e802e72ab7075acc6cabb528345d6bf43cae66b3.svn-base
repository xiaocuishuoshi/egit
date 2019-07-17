<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/commons/include.inc.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%--
	模块：系统管理--用户管理  用户更新
--%>
<style>
td{
white-space: nowrap;
}
</style>					
<div style="width: 96%;margin: 0 auto ;" >	
				
<form method="post" action="jdxc/update.do"  onsubmit="return validateSubmitForm(this)">
		<table class="table table-bordered">				
				<caption>戒毒宣传</caption>
		<tr>
				<td style="width:30%;text-align:center;padding-top:33px; ">标题</td>
				<td><input type="text" name="title" value="${requestScope.jc.title}"/></td>
			</tr>	
			
			<tr >
				<td style="padding-top:100px; padding-left:40px;white-space: nowrap;">发布内容</td>&nbsp;&nbsp;
				<td><textarea rows="4" cols="80" class="editor" name="nr" style="width:600px; height:300px;" >${requestScope.jc.nr}</textarea></td>
			</tr>

		</table>
			<center>
						  <button type="submit" class="btn btn-primary" >保存</button>&nbsp;&nbsp;&nbsp;&nbsp;
						  <button type="button" class="btn clear" >清空</button>
			</center>
		<input type="hidden"  name="id" value="${requestScope.jc.id }"/>
	    <input type="hidden" name="datagridId" value="${param.rel }_datagrid" />	
	    <input type="hidden" name="currentCallback" value="close" />
		
		  
	
</form>
</div>	