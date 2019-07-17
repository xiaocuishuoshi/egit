<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/commons/include.inc.jsp"%>

<form method="post" action="jiedu/man/relationship/submit.do" 
	onsubmit="return validateSubmitForm(this)">
	<input type="hidden" name="id" value="${one.id }"/>
	<input type="hidden" name="userId" value="${userId }"/>
	
	<div style="width: 100%; margin: 0 auto;">
	
		<table class="table table-bordered ">
		
			<tr>	
				<th style="width:70px">姓名：</th>
				<td>
				<input type="text" name="name"  required="true"  value="${one.name }" style="width:150px" />
				</td>
			</tr>
			<tr>	
				<th style="width:70px">性别：</th>
				<td>
					<ul class="list-unstyled">
						<li><input type="radio"  name="sex" value="1"/> 男</li>
						<li><input type="radio"  name="sex" value="0"/> 女</li>
					</ul>
				</td>
			</tr>
			<tr>	
				<th style="width:70px">出生年月：</th>
				<td>
					<input type="text" name="birthday"  value="${one.birthday }"  required="true" onFocus="WdatePicker()"  style="width:150px" />
				</td>
			</tr>
			<tr>	
				<th style="width:70px">联系方式：</th>
				<td>
					<input type="text" name="phone"  value="${one.phone }"  required="true" style="width:150px" />
				</td>
			</tr>
			<tr>	
				<th style="width:70px">关系：</h>
				<td>
				<select name="relationship"  required="true" style="width:150px">
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
				<th style="width:70px">住址：</th>
				<td>
					<textarea rows="3" cols="3" name="address"  required="true" >${one.address }</textarea>
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

		<input type="hidden" name="datagridId" value="man_relationship_datagrid" />
		<input type="hidden" name="currentCallback" value="close" />
	</div>
</form>

<script type="text/javascript">
var relationship='${one.relationship}';
var sex='${one.sex}';
$(function(){

	if(relationship!=''){
		$("select[name='relationship']").val(relationship);
	}

	if(sex!=''){
     	 $("input[name='sex'][value="+sex+"]").attr("checked","checked");
    }   
})

</script>