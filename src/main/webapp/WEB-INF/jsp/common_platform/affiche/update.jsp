<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/commons/include.inc.jsp" %>
<%@page import="com.whfp.oa.commons.util.ServletUtil"%>
<%@page import="com.whfp.oa.commons.model.Member"%> 
 
<%--
	模块：公共平台--公告管理--系统公告修改
--%>

<div style="width: 98%;margin: 0 auto ;" >
			
<form method="post" action="affiche/update.do"  onsubmit="return validateSubmitForm(this)">
		 <input type="hidden" name="orgid" value="<%=member.getOrgId()%>" />				
	<table class="table table-bordered ">
			<tr>
				<th style="width: 80px">标题：</th>
				<td>
					<input type="text" name="afficheTitle"  class="easyui-validatebox" required="true" data-options="validType:['length[1,50]']"  maxlength="50"   value="<c:out value="${requestScope.xa.afficheTitle }" />"/>
					&nbsp;&nbsp;&nbsp;<label class="checkbox inline" style="margin-top: -15px"><input <c:if test="${requestScope.xa.isTop==1 }">checked="checked"</c:if>  type="checkbox" name="isTop" value="1" />置顶</label>
				
					
				</td>
			</tr>
			<tr>
				<th>公告类型：</th>
				<td>
					<select   name="afficheType"  sValue="<c:out value="${requestScope.xa.afficheType }" />">
						<my:outOptions type="7"/>
					</select>
				</td>
			</tr>
			<tr>
				<th>内容：</th>
				<td>
					<textarea  name="afficheContent" rows="5" class="editor"  style="width: 98%;"><c:out value="${requestScope.xa.afficheContent }" /></textarea>
				</td>
			</tr>
			<tr>
				<th></th>
				<td>
					<div  style="margin-top: 10px;margin-bottom: 10px;">
						  <button type="submit" class="btn btn-primary" >修改</button>&nbsp;&nbsp;&nbsp;&nbsp;
						  <button type="button" class="btn clear" >清空</button>
					</div>
				</td>
			 </tr>
		
	</table>
		
		<input type="hidden" name="id" value="${requestScope.xa.id }"/>
		<input type="hidden" name="datagridId" value="${param.rel }_datagrid" />	
   		<input type="hidden" name="currentCallback" value="close" />
	
</form>
</div>
										
						
					