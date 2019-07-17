<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.whfp.oa.commons.util.ServletUtil"%>
<%@page import="com.whfp.oa.commons.model.Member"%>
<%@ include file="/WEB-INF/jsp/commons/include.inc.jsp" %>
<%

		Member member=(Member) ServletUtil.getSession().getAttribute("minfo"); 
 %>
<%--
	模块:公共平台--信息管理--法规管理--添加
--%>
<div style="width: 98%;margin: 0 auto;">
     <form method="post" action="regulation/add.do"  onsubmit="return validateSubmitForm(this)">
     		 <input type="hidden" name="orgid" value="<%=member.getOrgId()%>" />		
     		<table class="table table-bordered ">
	           <tr>
		        	 <th style="width: 50px">标题:</th>
		       		 <td><input type="text" name="rulesTitle" class="easyui-validatebox"  required='true' validType="minlength[1]" maxlength="50"></td>
		       </tr>
		       <tr>
		       		<th>类型:</th>
		      	    <td>
				       <select class="easyui-validatebox"  required='true'  name="rulesTypeid"  >
				       		<option value="">--请选择法规类型--</option>
				        	<my:outOptions type="9"/>
				       </select>
			       </td>
		       </tr>
		       <tr>
			       <th>内容:</th>
			       <td>
			       		<textarea  name="contents"  rows="13" class="editor" style="width: 98%;"></textarea>
			       </td>
		       </tr>
		       <tr>
					<th></th>
					<td >
						<div  style="margin-top: 10px;margin-bottom: 10px;">
							  <button type="submit" class="btn btn-primary" >保存</button>&nbsp;&nbsp;&nbsp;&nbsp;
							  <button type="button" class="btn clear" >清空</button>
						</div>
					</td>
				</tr>
		    </table> 		
     		 <input type="hidden" name="datagridId" value="${param.rel }_datagrid" />	
		 	 <input type="hidden" name="currentCallback" value="close" />
		
		</form>
</div>

