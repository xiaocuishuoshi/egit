<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/commons/include.inc.jsp" %>

	<style>


td{
	padding-left:40px;white-space: nowrap;

}
</style>				
<div style="width: 95%;margin: 0 auto ;" >				
		
<form method="post" action="qjgl/updateXj.do" onsubmit="return validateSubmitForm(this)">
		<table class="table table-bordered" >			
			<tr>
				<td style="padding-left:50px;">
					请假人姓名
				</td>
				<td >
					<input type="text" name="qjryxm" class="easyui-validatebox"
					required="true" 	value="${requestScope.qj.qjryxm}"/>
				</td>
			</tr>	
					
			<tr>
				<td style="padding-left:50px;">销假:</td>		
				<td>
					<select name="xjbz" >
						<option value="1">销假</option>
					</select>
				</td>		
			</tr>
		</table>
		<center>
			<button type="submit" class="btn btn-primary">
				保存
			</button>
			&nbsp;&nbsp;&nbsp;&nbsp;
			<button type="button" class="btn clear">
				清空
			</button>
		</center>
		<input type="hidden" name="id" value="${requestScope.qj.id }" />
		
		<input type="hidden" name="datagridId" value="${param.rel }_datagrid" />
		<input type="hidden" name="currentCallback" value="close" />



	</form>
</div>	
					
		

	

