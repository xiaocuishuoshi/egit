﻿<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
<div style="width: 95%;margin: 0 auto ;" >				
	
				
<form method="post" action="shqz/update.do"  onsubmit="return validateSubmitForm(this)">
		<table class="table table-bordered">				
			<caption>求活求助</caption>
		
			<tr>
				<td style="text-align:center;padding-top:18px;">
					回复内容:
				</td>
				<td>
					<textarea rows="4" cols="60" name="hfnr" class="easyui-validatebox"></textarea>
				</td>
			</tr>
			
			
		</table>
			<center>
						  <button type="submit" class="btn btn-primary" >保存</button>&nbsp;&nbsp;&nbsp;&nbsp;
						  <button type="button" class="btn clear" >清空</button>
			</center>
		<input type="hidden"  name="id" value="${requestScope.shqz.id }"/>
		
	    <input type="hidden" name="datagridId" value="${param.rel }_datagrid" />	
	    <input type="hidden" name="currentCallback" value="close" />
		
		  
	
</form>
</div>	