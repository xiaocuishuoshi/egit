<%@page import="com.whfp.oa.commons.util.ServletUtil"%>
<%@page import="com.whfp.oa.commons.model.Member"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/commons/include.inc.jsp"%>
<%--
	模块：信息交互-通知书管理-添加通知书页面
--%>
<%
	String path=request.getContextPath();
 %>
<link rel="stylesheet" href="<%= path %>/css/animate.css" type="text/css"></link>
<style>

	input{
		padding-top:40px;
		width:180px;
	}
	
</style>
<div style="width:90%;margin: 0 auto ;" >

	<form action="jdxc/add.do"  onsubmit="return validateSubmitForm(this)"
		method="post">
	<table class="table table-bordered " border="1">
			<caption>戒毒宣传</caption>
			<tr>
				<td style="width:30%;text-align:center;padding-top:33px; ">标题:</td>
				<td><input type="text" name="title" style="height:29px;width:300px;" /></td>
			</tr>
			<tr>
				<td style="padding-top:100px; padding-left:40px;white-space: nowrap;">发布内容：</td>
				<td  >
					<textarea  name="nr"  rows="5"  class="editor"  style="width:600px; height:300px;" ></textarea>
				</td>
			</tr>
	</table>

		<center>
			<button type="submit" class="btn btn-primary" >保存</button>&nbsp;&nbsp;&nbsp;&nbsp;
			<button type="button" class="btn clear" >清空</button>
		</center>

		<input type="hidden" name="datagridId" value="${param.rel }_datagrid" />
		<input type="hidden" name="currentCallback" value="close" />

	</form>
</div>

