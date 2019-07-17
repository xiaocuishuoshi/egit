<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/commons/include.inc.jsp"%>
<%--
	模块：帮扶列表管理-社区职务添加
--%>

<form method="post" action="sqzw/addSqzw.do" 
	onsubmit="return validateSubmitForm(this)">
	<div style="width: 300px; margin: 0 auto;">
		<table class="table table-bordered ">
			<h3 style="margin-left: 80px;">社区职务登记</h3>
		<input type="hidden" name="fwcs" value="0"/>
			<tr>	
				<th style="width:70px">社区干部：</th>
				<td>
				<input type="text" name="sqgb"  required="true" style="width:150px" />
				</td>
			</tr>
			<tr>	
				<th style="width:70px">社区民警：</th>
				<td>
				<input type="text" name="sqmj"  required="true" style="width:150px" />
				</td>
			</tr>
			<tr>	
				<th style="width:70px">禁毒社工：</th>
				<td>
				<input type="text" name="jdsg"  required="true" style="width:150px" />
				</td>
			</tr>
			<tr>	
				<th style="width:70px">网格员：</h>
				<td>
				<input type="text" name="wgy"  required="true" style="width:150px" />
				</td>
			</tr>
			<tr>	
				<th style="width:70px">X：</th>
				<td>
				<input type="text" name="x"  required="true" style="width:150px" />
				</td>
			
			<tr>
				<th></th>
				<td colspan="2">
					<div style="margin-top: 10px;margin-bottom: 10px;">
						<button type="submit" class="btn btn-primary">保存</button>
					</div>
				</td>
			</tr>
			
			
		</table>

		<input type="hidden" name="datagridId" value="${param.rel }_datagrid" />
		<input type="hidden" name="currentCallback" value="close" />
	</div>
</form>



