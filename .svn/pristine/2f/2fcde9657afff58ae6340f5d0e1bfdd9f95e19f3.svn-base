<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/commons/include.inc.jsp"%>
<%--
	模块：康复检查管理-添加
--%>

<form method="post" action="kfjc/addKfjc.do" 
	onsubmit="return validateSubmitForm(this)">
	<div style="width: 460px; margin: 0 auto;">
		<table class="table table-bordered ">
			<h3 style="margin-left: 150px;">定期检查登记</h3>
		<input type="hidden" name="fwcs" value="0"/>
			<tr>	
				<th style="width:80px">戒毒人员：</th>
				<td>
				<a href="sqzw/lookUp.do" lookupGroup="fw" title="人员查询">
						<input type="text" readonly="readonly" toName="fw.jdRyxm" style="width: 260px;"
						placeholder="检查人员列表" class="easyui-validatebox" name="name" required="true"/> </a> 
				<input type="hidden" name="ryid" toName="fw.id">	
				<input type="hidden" name="dh" toName="fw.jdDwdh">
				</td>
			</tr>
				<tr>	
				<th style="width:80px">负责人：</th>
				<td>
				<input type="text" name="fzr"  required="true" style="width:260px" />
				</td>
			</tr>
				<tr>	
				<th style="width:80px">时间：</th>
				<td>
					<input type="text" required="true" style="width: 150px;"
						class="easyui-validatebox span3"   readonly="readonly"
						onFocus="WdatePicker({dateFmt:'yyyy-MM'})"
						name="jcsj"/>
				</td>
			</tr>
			<tr>	
				<th style="width:70px">是否正常：</th>
				<td>
					<select name="sfzc" style="width:270px"> 
						<option value="阴性">阴性</option>
						<option value="阳性">阳性</option>
						<option value="未检查">未检查</option>
						<option value="本月不用检查">本月不用检查</option>
					</select>
				</td>
			</tr>
				<tr>	
				<th style="width:70px">检查说明：</th>
				<td>
					<textarea style="width:300px;height: 60px;" required="true" name="jcsm"></textarea>
				</td>
			</tr>
			
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



