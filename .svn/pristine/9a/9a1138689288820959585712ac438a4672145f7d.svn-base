<%@page import="com.whfp.oa.commons.util.ServletUtil"%>
<%@page import="com.whfp.oa.commons.model.Member"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/commons/include.inc.jsp"%>

<style>
	table{
		
		font-size:15px;
	}
</style>
<div style="width:750px;margin: 0 auto ;" >

	<form action="tzs/updateQrtzDo.do"  onsubmit="return validateSubmitForm(this)"
		method="post">
	<table class="table table-bordered " border="1" >
		<caption>处理结果</caption>
		
		<tr>
			<td style="text-align:center;">内容:</td>		
			<td>
				<input  type="text" name="bz" style="width:350px; height:30px;"/>
			</td>		
		</tr>
		
	</table>
		<center>
			<button type="submit" class="btn btn-primary" >确认</button>&nbsp;&nbsp;&nbsp;&nbsp;
			<button type="button" class="btn clear" >清空</button>
		</center>
		
		<input type="hidden" name="id" value="${requestScope.tzs.id }"/>
		<input type="hidden"  name="gxbmid" value="${requestScope.tzs.gxbmid}"/>
		<input type="hidden" name="datagridId" value="${param.rel }_datagrid" />
		<input type="hidden" name="currentCallback" value="close" />

	</form>
</div>


