<%@page import="com.whfp.oa.commons.util.ServletUtil"%>
<%@page import="com.whfp.oa.commons.model.Member"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/commons/include.inc.jsp"%>
<%--
	模块：信息交互-通知书管理-添加通知书页面
--%>

<style>

	input{
		padding-top:40px;
		width:180px;
	}
	
</style>

<div style="width:80%;margin: 0 auto ;" >

	<form action="tzsgl/add.do" enctype="multipart/form-data" onsubmit="return validateSubmitForm(this)"
		method="post">
	<table class="table table-bordered " border="1">
			<tr>
				<td style="width:26%">标题：</td>
				<td>
					<input type="text" name="tzsmc" class="easyui-validatebox" required="true" validType="minlengtd[1]"  maxlengtd="100"   />
				</td>
				
				<td>接收人员：</td>
				<td>
					<a href="user/lookUpPage.do?type=2&deptId=<%=member.getDeptId() %>"  lookupGroup="user" title="用户查询">
						<input type="text" name="cjry" readonly="readonly"  toName="user.trueName" >
						
					</a>
					<input type="hidden" name="gsdw"  toName="user.id" />
				</td>
			</tr>
			<tr>
				<td style="padding-top:100px; padding-left:40px;white-space: nowrap;">通知书内容：</td>
				<td  colspan="3">
					<textarea  name="tzsnr"  rows="5"  class="editor"  style="width:800px; height:300px;" ></textarea>
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


