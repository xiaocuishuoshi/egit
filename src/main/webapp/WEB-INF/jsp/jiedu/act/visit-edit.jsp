<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/commons/include.inc.jsp"%>

<form method="post" action="jiedu/act/visit/submit.do" 
	onsubmit="return validateSubmitForm(this)">
	<input type="hidden" name="id" value="${one.id }"/>
	
	<div style="width: 100%; margin: 0 auto;">
	
		<table class="table table-bordered ">
		
			<tr>	
				<th style="width:70px">戒毒人员：</th>
				<td colSpan="3">
					<a href="sqzw/lookUp.do"  lookupGroup="fw" title="戒毒人员查询">
						<input type="text" name="toUser"  readonly="readonly"  toName="fw.jdRyxm"  style="width:150px" />
					</a>
					<input type="hidden" name="toUid" value="${one.toUid }" toName="fw.id" />
				</td>
			</tr>
			<tr>	
				<th style="width:70px">被访人：</th>
				<td>
					<input type="text" name="toVisitor"  value="${one.toVisitor }"   required="true"  style="width:150px" />
				</td>
				<th style="width:70px">和戒毒人员关系：</th>
				<td>
					<select  name="toVisitorRelationship" required="true" style="width:150px" >
						<option value="">(请选择)</option>
						<option>父亲</option>
						<option>母亲</option>
						<option>妻子</option>
						<option>丈夫</option>
						<option>子女</option>
						<option>朋友</option>
						<option>其它</option>
						
					</select>
				</td>
			</tr>
			<tr>	
				<th style="width:70px">联系方式：</th>
				<td>
					<input type="text" name="toVisitorPhone"  value="${one.toVisitorPhone }"   required="true"   style="width:150px" />
				</td>
				<th style="width:70px">访问时间：</th>
				<td >
					<input type="text" name="visitorDate"  value="${one.visitorDate }" onFocus="WdatePicker()" required="true" style="width:150px" />
				</td>
			</tr>
			<tr>	
				<th style="width:70px">访问地点：</th>
				<td colSpan="3">
					<input type="text" name="address"   value="${one.address }"   required="true" style="width:90%" />
				</td>
			</tr>
			<tr>	
				<th style="width:70px">1：社区戒毒人员及家庭状况：</th>
				<td colSpan="3">
					<textarea rows="3" cols="3" name="key1" style="width:90%;"  required="true">${one.key1 }</textarea>
				</td>
			</tr>
			<tr>	
				<th style="width:70px">2:社区戒毒人员工作（生产）状况：</th>
				<td colSpan="3">
					<textarea rows="3" cols="3" name="key2"  style="width:90%;"  required="true" >${one.key2 }</textarea>
				</td>
			</tr>
			<tr>	
				<th style="width:70px">3:对社区戒毒康复工作办公室的意见和建议：</th>
				<td colSpan="3">
					<textarea rows="3" cols="3" name="key3" style="width:90%;"   required="true" >${one.key3 }</textarea>
				</td>
			</tr>
			<tr>	
				<th style="width:70px">4:目前您最突出的困难是什么：</th>
				<td colSpan="3">
					<textarea rows="3" cols="3" name="key4" style="width:90%;"   required="true" >${one.key4 }</textarea>
				</td>
			</tr>
			<tr>	
				<th style="width:70px">5:基它问题：</th>
				<td colSpan="3">
					<textarea rows="3" cols="3" name="key5"  style="width:90%;"  required="true" >${one.key5 }</textarea>
				</td>
			</tr>
			<tr>	
				<th style="width:70px">
					走访人：
				</th>
				<td colSpan="3">
					<a href="user/lookUpPage.do?type=2&deptId=<%=member.getDeptId() %>"  lookupGroup="user" title="社区人员查询">
						<input type="text" name="visitorName"  readonly="readonly" value="${one.visitorName }"  toName="user.trueName"  style="width:90%;" />
						
					</a>
					<input type="hidden" name="visitorUid" value="${one.visitorUid }" toName="user.id" />
				</td>
			</tr>
			
			<tr>
				<th></th>
				<td colspan="3">
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
var toVisitorRelationship='${one.toVisitorRelationship}';
var sex='';
$(function(){

	if(toVisitorRelationship!=''){
		$("select[name='toVisitorRelationship']").val(toVisitorRelationship);
	}
})

</script>