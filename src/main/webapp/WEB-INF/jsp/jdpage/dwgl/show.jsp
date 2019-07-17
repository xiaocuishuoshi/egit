<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/commons/include.inc.jsp" %>
<%--
	模块：系统管理--用户管理 --单个用户详情
--%>
	<style>

div{
	padding:5px;
	
}
input{
	width:100px;
}
#tp{

	margin-top:180px;
}
td{
	white-space: nowrap;
}
</style>				
<div style="width: 900px;">				
		
		<table class="table table-bordered" >			
		<tr>
				<td style="width:26%">标题：</td>
				<td>
					<input type="text" name="tzsmc" value="${requestScope.tzsmb.tzsmc}" class="easyui-validatebox" required="true" validType="minlengtd[1]"  maxlengtd="100"   />
				</td>
				
				<td>接收人员：</td>
				<td>
					<a href="user/lookUpPage.do?type=2"  lookupGroup="user" title="用户查询">
						<input type="text" name="cjry" value="${requestScope.tzsmb.cjry}" readonly="readonly"  toName="user.trueName" >
						
					</a>
					<input type="hidden" name="gsdw"  toName="user.id" />
				</td>
			</tr>
			<tr>
				<td style="padding-top:100px; padding-left:40px;">通知书内容：</td>
				<td  colspan="3">
					<textarea  name="tzsnr" value="${requestScope.tzsmb.tzsnr}"  class="editor"  style="width:800px;" ></textarea>
				</td>
			</tr>
		</table>
	
	

</div>	
					
		

	

