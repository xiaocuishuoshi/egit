<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/commons/include.inc.jsp"%>

<form method="post" action="jiedu/act/talk/submit.do" 
	onsubmit="return validateSubmitForm(this)">
	<input type="hidden" name="id" value="${one.id }"/>
	
	<div style="width: 100%; margin: 0 auto;">
	
		<table class="table table-bordered ">
		
			<tr>	
				<th style="width:70px">戒毒人员：</th>
				<td>
					<a href="sqzw/lookUp.do"  lookupGroup="fw" title="戒毒人员查询">
						<input type="text" name="toUser"  readonly="readonly"  toName="fw.jdRyxm"  style="width:150px" />
					</a>
					<input type="hidden" name="toUid" value="${one.toUid }" toName="fw.id" />
				</td>
			</tr>
			<tr>	
				<th style="width:70px">谈话地点：</th>
				<td>
				<input type="text" name="address"  required="true"   style="width:150px" />
				</td>
			</tr>
			<tr>	
				<th style="width:70px">谈话时间：</th>
				<td>
				<input type="text" name="talkDate"  required="true" onFocus="WdatePicker()"    style="width:150px" />
				</td>
			</tr>
		
			<tr>	
				<th style="width:70px">谈话内容：</th>
				<td>
					<textarea rows="3" cols="3" name="content"  style="width:90%;"  required="true"></textarea>
				</td>
			</tr>
			<tr>	
				<th style="width:70px">谈话人：</th>
				<td>
					<a href="user/lookUpPage.do?type=2&deptId=<%=member.getDeptId() %>"  lookupGroup="user" title="社区人员查询">
						<input type="text" name="talkUser"  readonly="readonly"  toName="user.trueName"  style="width:150px" />
					</a>
					<input type="hidden" name="talkUid" value="${one.toUid }" toName="user.id" />
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

		<input type="hidden" name="datagridId" value="${param.rel}_datagrid" />
		<input type="hidden" name="currentCallback" value="close" />
	</div>
</form>

<script type="text/javascript">

$(function(){

	
})

</script>