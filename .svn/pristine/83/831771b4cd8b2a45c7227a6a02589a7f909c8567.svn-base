<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/commons/include.inc.jsp"%>

<form method="post" action="jiedu/man/work/submit.do" 
	onsubmit="return validateSubmitForm(this)">
	<input type="hidden" name="id" value="${one.id }"/>
	<input type="hidden" name="userId" value="${userId }"/>
	
	<div style="width: 100%; margin: 0 auto;">
	
		<table class="table table-bordered ">
		
			<tr>	
				<th style="width:70px">开始时间：</th>
				<td>
					<input type="text" name="startDate"  required="true"  onFocus="WdatePicker({dateFmt:'yyyy-MM'})" value="${one.startDate }" style="width:150px" />
				</td>
				<th style="width:70px">结束时间：</th>
				<td>
					<input type="text" name="endDate"  required="true"  onFocus="WdatePicker({dateFmt:'yyyy-MM'})"  value="${one.endDate }" style="width:150px" />
				</td>
			</tr>
			<tr>	
				<th style="width:70px">行业：</th>
				<td colSpan="3">
					<input type="text" name="job"  value="${one.job }"  required="true" style="width:90%" />
				</td>
			</tr>
			<tr>	
				<th style="width:70px">公司：</th>
				<td  colSpan="3">
					<input type="text" name="company"  value="${one.company }"  required="true"  style="width:90%" />
				</td>
			</tr>
			<tr>	
				<th style="width:70px">职位：</th>
				<td  colSpan="3">
					<input type="text" name="postion"  value="${one.postion }"  required="true" style="width:90%" />
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

		<input type="hidden" name="datagridId" value="man_work_datagrid" />
		<input type="hidden" name="currentCallback" value="close" />
	</div>
</form>

<script type="text/javascript">
var relationship='';
var sex='';
$(function(){

	if(relationship!=''){
		$("select[name='relationship']").val(relationship);
	}

	if(sex!=''){
     	 $("input[name='sex'][value="+sex+"]").attr("checked","checked");
    }   
})

</script>