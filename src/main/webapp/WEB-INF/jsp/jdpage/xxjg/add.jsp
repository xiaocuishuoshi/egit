<%@page import="com.whfp.oa.commons.util.ServletUtil"%>
<%@page import="com.whfp.oa.commons.model.Member"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/commons/include.inc.jsp"%>
	
<div style="width:70%;margin: 0 auto ;" >

	<form action="xxjg/add.do"  onsubmit="return validateSubmitForm(this)"
		method="post">
	<table class="table table-bordered " border="1">
			<caption>信息警告</caption>
			<tr>
					<th style="width:25%;padding:20px;">接受人姓名：</td>
					<td >
						<a href="user/lookUpPage.do?type=2&deptId=<%=member.getDeptId() %>"  lookupGroup="user" title="用户查询">
							<input type="text" name="jsrxm" readonly="readonly"  class="easyui-validatebox" toName="user.trueName"  required="required">
						</a>
						<input type="hidden" name="cid" toName="user.cid" />
					</td>
			</tr>
			<tr>
				<th style="width:25%;padding:20px;">发送内容：</td>
					<td  >
						<textarea rows="4" cols="150" name="fsnr" class="easyui-validatebox" ></textarea>
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


