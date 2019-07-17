<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/commons/include.inc.jsp"%>

<style>

td {
	padding-left: 40px;white-space: nowrap;
}
</style>
<div style="width: 95%;margin: 0 auto ;" >				

	<form method="post" action="qjgl/updateSp.do" onsubmit="return validateSubmitForm(this)">
		<table class="table table-bordered">
			<tr>
				<td style="padding-left: 50px;">
					请假人姓名
				</td>
				<td>
					<input type="text" readonly="readonly" name="qjryxm" class="easyui-validatebox"
						required="true" value="${requestScope.qj.qjryxm}" />
				</td>
			</tr>
			<tr>
				<td style="padding-left: 50px;">
					标题
				</td>
				<td>
					<input type="text" readonly="readonly" name="cgbz" class="easyui-validatebox"
						value="${requestScope.qj.cgbz}" />
				</td>
			</tr>
			<tr>
				<td style="padding-left: 50px;">
					请假内容
				</td>
				<td>
					<textarea readonly="readonly" rows="5" cols="30" name="qjnr">${requestScope.qj.qjnr}</textarea>	
				</td>
			</tr>
			<tr>
				<td style="padding-left: 50px;">
					请假开始时间
				</td>
				<td>
				<input type="text" readonly="readonly" name="qjkssj" value="${requestScope.qj.qjkssj}" class="easyui-validatebox" 
						required="true" maxlength="50" size="50" style="width: 300PX"/> 
				</td>
			</tr>
			<tr>
				<td style="padding-left: 50px;">
					请假结束时间
				</td>
				<td>
				<input type="text" readonly="readonly" name="qjjssj" value="${requestScope.qj.qjkssj}" class="easyui-validatebox" 
						maxlength="50" size="50" style="width: 300PX"/> 
				</td>
			</tr>
			<tr>
				<td style="padding-left: 50px;">
					审批:
				</td>
				<td>
					<select name="spzt" required="true">
						<option value="1">
							同意
						</option>
						<option value="2">
							不同意
						</option>
					</select>
				</td>
			</tr>
		</table>

		<center>
			<button type="submit" class="btn btn-primary">
				审批 
			</button>
			&nbsp;&nbsp;&nbsp;&nbsp;
			<button type="button" class="btn clear">
				清空
			</button>
		</center>
		<input type="hidden" name="id" value="${requestScope.qj.id }" />
		<input type="hidden" name="gxbmid" value="${requestScope.qj.gxbmid}" />
		<input type="hidden" name="datagridId" value="${param.rel }_datagrid" />
		<input type="hidden" name="currentCallback" value="close" />



	</form>
</div>





