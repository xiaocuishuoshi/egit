<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/commons/include.inc.jsp"%>
<%--
	模块：宣传教育管理-添加
--%>

<form method="post" action="xcjy/addXcjy.do" enctype="multipart/form-data"
	onsubmit="return validateSubmitForm(this)">
	<div style="width: 650px; margin: 0 auto;">
		<table class="table table-bordered ">
			<h3 style="margin-left: 250px;">帮扶情况登记</h3>
			<tr>	
				<th style="width:150px">宣传六进：</th>
				<td>
				<select name="jdXcbt"  style="width: 99%;"> 
					<option value="进学校">进学校</option>
					<option value="进社区">进社区</option>
					<option value="进农村">进农村</option>
					<option value="进单位">进单位</option>
					<option value="进家庭">进家庭</option>
					<option value="进场所">进场所</option>
				</select>	
				</td>
			</tr>
			
				<tr>
				<th style="width:150px">宣传时间：</th>
				<td>
				<input type="text" required="true" style="width: 97%;"
					class="easyui-validatebox span3"   readonly="readonly"
					onFocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"
					name="jdSj"  />
				</td>
			</tr>
			<tr>
				<th style="width:150px">宣传图片：</th>
				<td colspan="3">
				<input type="file" accept="image/png,image/jpg,image/jpeg,image/gif"  name="file"  style="border:1px solid red"/>  
				</td>
			</tr>
			<tr>		
			<th >宣传内容：</th>
				<td colspan="3">
				<textarea rows="5" cols="5" name="jdXcnr"  style="width: 97%;height: 80px;"></textarea>
				</td>
			</tr>
			
			<tr>
				<th></th>
				<td colspan="4">
					<div style="margin-top: 10px;margin-bottom: 10px;">
						<button type="submit" class="btn btn-primary">保存</button>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<button type="button" class="btn clear">清空</button>
					</div>
				</td>
			</tr>
		</table>
		<input type="hidden" name="datagridId" value="${param.rel }_datagrid" />
		<input type="hidden" name="currentCallback" value="close" />
	</div>
</form>