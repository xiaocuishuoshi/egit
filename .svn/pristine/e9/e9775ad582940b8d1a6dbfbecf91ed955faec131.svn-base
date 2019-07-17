<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/commons/include.inc.jsp"%>
<%--
	模块：二维码管理-产品登记添加
--%>

<form method="post" action="sqzw/addBfqk.do" enctype="multipart/form-data"
	onsubmit="return validateSubmitForm(this)">
	<div style="width: 650px; margin: 0 auto;">
		<table class="table table-bordered ">
			<h3 style="margin-left: 250px;">帮扶情况登记</h3>
		<input type="hidden" name="fwcs" value="0"/>
			<tr>	
				<th style="width:150px">被帮扶人姓名：</th>
				<td>
				<a href="sqzw/lookUp.do" lookupGroup="fw" title="人员查询">
						<input type="text" readonly="readonly" toName="fw.jdRyxm" style="width: 460px;"
						placeholder="帮扶人员列表" class="easyui-validatebox" name="bfrname"/> </a> 
						
				<input type="hidden" name="bfrid" toName="fw.id">		
				</td>
			</tr>
			
			<tr>
			<th style="width:150px">提供帮扶社区：</th>
				<td>
					<select name="sqzwid"  style="width:460px" >
						<c:forEach items="${list}" var="s">
							<option value="${s.id}">${s.sqmj}</option>							
						</c:forEach>
					</select>
				</td>
				</tr>
				
				<tr>
				<th style="width:150px">帮扶时间：</th>
				<td>
				<input type="text" required="true" style="width: 460px;"
					class="easyui-validatebox span3"   readonly="readonly"
					onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"
					name="bfsj"  />
				</td>
			</tr>
			<tr>
				<th style="width:150px">帮扶图片：</th>
				<td colspan="3">
				<input type="file" accept="image/png,image/jpg,image/jpeg,image/gif"  name="file"  style="border:1px solid red"/>  
				</td>
			</tr>
			<tr>		
			<th >帮扶内容：</th>
				<td colspan="3">
				<textarea rows="5" cols="5" name="bfnr"  style="width: 97%;height: 80px;"></textarea>
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