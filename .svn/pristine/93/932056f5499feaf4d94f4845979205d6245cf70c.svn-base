<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/commons/include.inc.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%--
	模块：系统管理--用户管理  用户更新
--%>
<style>

input{
	width:130px;
}
#tp{

	margin-top:180px;
}

</style>					
<div style="width: 95%;margin: 0 auto ;" >				
	
				
<form method="post" action="tzs/update.do"  onsubmit="return validateSubmitForm(this)">
		<table class="table table-bordered">				
		<tr>
				<td style="width:26%">标题：</td>
				<td>
					<input type="text" name="tzsmc" value="${requestScope.tzs.tzsmc}" class="easyui-validatebox" required="true" validType="minlengtd[1]"  maxlengtd="100"   />
				</td>
				
				<td>接收人员：</td>
				<td>
					<a href="user/lookUpPage.do?type=2"  lookupGroup="user" title="用户查询">
						<input type="text" name="tzsjsrxm" value="${requestScope.tzs.tzsjsrxm}" readonly="readonly"  toName="user.trueName" >
						
					</a>
					<input type="hidden"  toName="user.id" />
				</td>
			</tr>
			<tr>
				<td style="padding-top:100px; padding-left:40px;white-space: nowrap;">通知书内容：</td>
				<td  colspan="3">
					<textarea  name="tzsnr"  class="editor"  style="width:600px;" >${requestScope.tzs.tzsnr}</textarea>
				</td>
			</tr>
		</table>
				<center>
						  <button type="submit" class="btn btn-primary" >保存</button>&nbsp;&nbsp;&nbsp;&nbsp;
						  <button type="button" class="btn clear" >清空</button>
				</center>
		<input type="hidden"  name="id" value="${requestScope.tzs.id }"/>
<input type="hidden"  name="gxbmid" value="${requestScope.tzs.gxbmid}"/>
	    <input type="hidden" name="datagridId" value="${param.rel }_datagrid" />	
	    <input type="hidden" name="currentCallback" value="close" />
		
		  
	
</form>
</div>	