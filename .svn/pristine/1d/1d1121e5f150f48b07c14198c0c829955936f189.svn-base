<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/commons/include.inc.jsp"%>
<%--
	模块：系统管理--用户管理  用户设置
--%> 

<div style="width: 320px; margin: 0 auto;">
	<form method="post" action="jbxx/jbsz.do"
		onsubmit="return validateSubmitForm(this)">
		<table class="table table-bordered ">
			<h3 style="margin-left: 100px;">分类-级别-设置</h3>
			<input type="hidden" name="id" value="${id}">
			<tr>	
				<th style="width:50px">类型：</th>
				<td>
					<select name="jdRylb" style="width: 220px;" sValue="${user.jdRylb}">
						<option value="1">吸毒人员</option>
						<option value="2">社区戒毒人员</option>
						<option value="3">社区康复人员</option>
						<option value="4">强制戒毒人员</option>
						
						<option value="5">其他</option> 
					</select>
				</td>
			</tr>
			
			<tr>
			<th style="width:50px">级别：</th>
				<td>
				<select name="jdJb" style="width: 220px;" sValue="${user.jdJb}">
						<option value="0">正常</option>
						<option value="1">一级</option>
						<option value="2">二级</option>
						<option value="3">三级</option>
					</select>
				</td>
			</tr>
			<tr>		
				<th></th>
				<td colspan="3">
					<div style="margin-top: 10px;margin-bottom: 10px;margin-left: 30px;">
						<button type="submit" class="btn btn-primary">设置</button>
					</div>
					</td>
			</tr>

		</table>
		<input type="hidden" name="datagridId" value="${param.rel }_datagrid" />
		<input type="hidden" name="currentCallback" value="close" />
	</form>
</div>